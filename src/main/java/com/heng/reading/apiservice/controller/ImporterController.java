package com.heng.reading.apiservice.controller;

import com.heng.reading.apiservice.comms.data.CommCodeMsg;
import com.heng.reading.apiservice.comms.data.ResultData;
import com.heng.reading.apiservice.comms.enums.FileMimeType;
import com.heng.reading.apiservice.comms.exception.BusinessException;
import com.heng.reading.apiservice.comms.utils.StringUtil;
import com.heng.reading.apiservice.comms.utils.UUIDUtil;
import com.heng.reading.apiservice.entity.AccountBookIndex;
import com.heng.reading.apiservice.entity.GeneralBook;
import com.heng.reading.apiservice.service.*;
import nl.siegmann.epublib.domain.Book;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

/**
 * 资源导入控制器
 * @author heng
 */
@RestController
@RequestMapping("/importer")
public class ImporterController {

    @Resource
    private AccountUserService accountUserService;

    @Resource
    private ImporterService importerService;

    @Resource
    private BookFileParseService bookFileParseService;

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
    @PostMapping("epub/{accountId}")
    public ResultData<Object> epubBookImport(@PathVariable("accountId") String accountId,
                                             @RequestParam("files") MultipartFile[] fileList) throws IOException {
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
        ArrayList<String> storedFileList = new ArrayList<>();
        for (MultipartFile file : fileList) {
            String path = importerService.transFile2Dest(file, FileMimeType.EPUB, accountId);
            storedFileList.add(path);
        }
        // 处理 ePub 解析
        for (String bookPath : storedFileList) {

            long bookSize = 0;
            File bookFile = new File(accountDataDirRoot + bookPath);
            if (bookFile.exists()) {
                bookSize = FileUtils.sizeOf(bookFile);
            }

            Book epubBook = bookFileParseService.loadEpub(accountDataDirRoot + bookPath);
            // 解析 ePub 文件以获取元数据
            Map<String, String> metadata = bookFileParseService.fetchMetadata(epubBook);
            // 解析 ePub 文件以获取封面并存入
            String coverFileName = bookFileParseService.fetchBookCover(epubBook, accountId);

            // 将 ePub 元数据及封面文件URL写入到数据库（GeneralBook）
            String bookId = UUIDUtil.uuid();
            GeneralBook book = new GeneralBook();
            book.setId(bookId);
            book.setBookSize(StringUtil.storageUnitConvert(bookSize));
            book.setBookFileUrl(bookPath);
            book.setBookPushedTime(StringUtil.getCurrentTime());
            if (metadata != null) {
                book.setBookTitle(metadata.get("title"));
                book.setBookAuthors(metadata.get("authors"));
                book.setBookDescription(metadata.get("description"));
            }
            if (!StringUtil.isNullOrEmpty(coverFileName)) {
                book.setBookCoverUrl(coverFileName);
            }
            generalBookService.save(book);

            // 建立 GeneralBook 信息与用户帐号的关联索引（AccountBookIndex）
            AccountBookIndex accountBookIndex = new AccountBookIndex();
            accountBookIndex.setId(UUIDUtil.uuid());
            accountBookIndex.setBookId(bookId);
            accountBookIndex.setAccountId(accountId);
            accountBookIndexService.save(accountBookIndex);
        }
        return ResultData.success();
    }
}