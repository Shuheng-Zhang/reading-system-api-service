package com.heng.reading.apiservice.controller;

import com.heng.reading.apiservice.comms.data.CommCodeMsg;
import com.heng.reading.apiservice.comms.data.ResultData;
import com.heng.reading.apiservice.comms.enums.FileMimeType;
import com.heng.reading.apiservice.comms.exception.BusinessException;
import com.heng.reading.apiservice.comms.utils.StringUtil;
import com.heng.reading.apiservice.entity.AccountBookIndex;
import com.heng.reading.apiservice.entity.GeneralBook;
import com.heng.reading.apiservice.service.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import nl.siegmann.epublib.domain.Book;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.util.ArrayList;
import java.util.Map;

/**
 * 资源导入控制器
 * @author heng
 */
@Api(tags = "资源导入控制器")
@RestController
@RequestMapping("/importer")
public class ImporterController {

    @Resource
    private AccountUserService accountUserService;

    @Resource
    private ImporterService importerService;

    @Resource
    private EpubBookFileParseService epubBookFileParseService;

    @Resource
    private GeneralBookService generalBookService;

    @Resource
    private AccountBookIndexService accountBookIndexService;

    @Value("${extendStorage.accountDataDirRoot}")
    private String accountDataDirRoot;

    /**
     * 导入 ePub 电子书
     * @param accountId 用户帐号ID
     * @param fileList 电子书文件列表
     * @return
     */
    @ApiOperation("导入 ePub 电子书")
    @PostMapping("epub/{accountId}")
    public ResultData<Object> epubBookImport(@PathVariable("accountId") String accountId,
                                             @RequestParam("files") MultipartFile[] fileList) {
        if (fileList == null || fileList.length == 0) {
            throw new BusinessException(CommCodeMsg.CODE_TERMINATE, CommCodeMsg.MSG_PARAMS_ERR);
        }

        // 检查用户帐号
        accountUserService.checkAccountExist(accountId);

        // 检查文件类型
        importerService.checkFilesContentType(FileMimeType.EPUB, fileList);
        // 处理用户目录
        importerService.checkUserDir(accountId);
        // 处理文件转存
        ArrayList<String[]> storedFileList = new ArrayList<>();
        for (MultipartFile file : fileList) {
            String[] res = importerService.transFile2Dest(file, FileMimeType.EPUB, accountId);
            if (res == null) {
                continue;
            }
            storedFileList.add(res);
        }
        // 处理 ePub 解析
        for (String[] bookInfo : storedFileList) {

            File bookFile = new File(accountDataDirRoot + bookInfo[1]);
            if (!bookFile.exists()) {
                throw new BusinessException(CommCodeMsg.CODE_SYS_ERR, CommCodeMsg.MSG_OBJ_NOT_FOUND);
            }

            // 解压缩 ePub
            String bookFileName = bookFile.getName();
            String bookUnzipDirName = bookFileName.replaceAll("\\.epub", "");
            String destUnzipDirPath = "/" + accountId + "/unpack/" + bookUnzipDirName;
            epubBookFileParseService.ePubUnzip(accountDataDirRoot + bookInfo[1],
                    accountDataDirRoot + destUnzipDirPath);

            // 获取解压缩容量
            File unzippedDir = new File(accountDataDirRoot + destUnzipDirPath);
            if (!unzippedDir.exists()) {
                throw new BusinessException(CommCodeMsg.CODE_SYS_ERR, CommCodeMsg.MSG_SYS_ERR);
            }
            long unzipBookSize = FileUtils.sizeOf(unzippedDir);

            // 加载 ePub 文件
            Book epubBook = epubBookFileParseService.loadEpub(accountDataDirRoot + bookInfo[1]);

            // 获取 ePub OPF 相对地址
            String bookOpfUrl = epubBookFileParseService.fetchOpfUrl(epubBook, accountId, bookUnzipDirName);

            // 解析 ePub 文件以获取元数据
            Map<String, String> metadata = epubBookFileParseService.fetchMetadata(epubBook);
            // 解析 ePub 文件以获取封面并存入
            String coverFileName = epubBookFileParseService.fetchBookCover(epubBook, accountId);

            // 创建 电子书数据对象
            GeneralBook book = generalBookService.config(
                    metadata,
                    coverFileName,
                    bookInfo[1], bookOpfUrl, destUnzipDirPath,
                    StringUtil.storageUnitConvert(unzipBookSize),
                    StringUtil.getCurrentTime()
            );

            // 处理 电子书标题为空/Untitled/未命名
            String bookTitle = book.getBookTitle();
            if (StringUtil.isNullOrEmpty(bookTitle) || "Untitled".equals(bookTitle) || "未命名".equals(bookTitle)) {
                book.setBookTitle(bookInfo[0]);
            }

            // 建立 GeneralBook 信息与用户帐号的关联索引
            AccountBookIndex accountBookIndex = accountBookIndexService.config(accountId, book.getId());

            generalBookService.save(book);

            accountBookIndexService.save(accountBookIndex);
        }
        return ResultData.success();
    }
}
