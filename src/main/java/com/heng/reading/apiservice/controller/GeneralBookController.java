package com.heng.reading.apiservice.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.heng.reading.apiservice.comms.data.CommCodeMsg;
import com.heng.reading.apiservice.comms.data.PageQueryReqDto;
import com.heng.reading.apiservice.comms.data.ResultData;
import com.heng.reading.apiservice.comms.exception.BusinessException;
import com.heng.reading.apiservice.comms.utils.StringUtil;
import com.heng.reading.apiservice.dto.book.GeneralBookDto;
import com.heng.reading.apiservice.dto.book.GeneralBookRecentReadingDto;
import com.heng.reading.apiservice.dto.book.GeneralBookSimpleDto;
import com.heng.reading.apiservice.dto.progress.BookProgressIndexDto;
import com.heng.reading.apiservice.service.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 电子书数据控制器
 * @author heng
 */
@Api(tags = "电子书数据控制器")
@RestController
@RequestMapping("/book")
public class GeneralBookController {

    @Resource
    private GeneralBookService generalBookService;

    @Resource
    private GeneralBookmarkService generalBookmarkService;

    @Resource
    private GeneralReadingProgressService generalReadingProgressService;

    @Resource
    private GeneralReadingConfigService generalReadingConfigService;

    @Resource
    private AccountBookIndexService accountBookIndexService;

    @Resource
    private BookBookmarkIndexService bookBookmarkIndexService;

    @Resource
    private BookProgressIndexService bookProgressIndexService;

    @Resource
    private BookConfigIndexService bookConfigIndexService;


    @Resource
    private MessDataService messDataService;

    /**
     * 分页查询指定用户帐号的电子书信息
     * @param queryReqDto requests.accountId(必要) - 用户帐号ID, requests.title(可选) - 按标题查询, requests.authors(可选) - 按作者查询
     * @return
     */
    @ApiOperation("分页查询指定用户帐号的电子书信息")
    @PostMapping("list")
    public ResultData<IPage<GeneralBookDto>> listBooksByAccountId(@RequestBody PageQueryReqDto<String> queryReqDto) {

        String accountId = queryReqDto.getReqParam("accountId");
        if (StringUtil.isNullOrEmpty(accountId)) {
            throw new BusinessException(CommCodeMsg.CODE_TERMINATE, CommCodeMsg.MSG_PARAMS_ERR);
        }

        // 模糊查询-标题
        String titleLike = queryReqDto.getReqParam("title");
        // 模糊查询-作者
        String authorLike = queryReqDto.getReqParam("authors");

        Page<GeneralBookDto> page = new Page<>(queryReqDto.getCurrentPage(), queryReqDto.getLimit());
        IPage<GeneralBookDto> iPage = null;
        if (!StringUtil.isNullOrEmpty(titleLike) || !StringUtil.isNullOrEmpty(authorLike)) {
            iPage = generalBookService.findBooksByAccountId(accountId, titleLike, authorLike, page);
        } else {
            iPage = generalBookService.findBooksByAccountId(accountId, page);
        }

        return ResultData.success(iPage);
    }

    /**
     * 分页查询指定用户账号的电子书基本信息
     * @param queryReqDto requests.accountId(必要) - 用户账号ID, requests.title(可选) - 按标题查询, requests.authors(可选) - 按作者查询
     * @return
     */
    @ApiOperation("分页查询指定用户账号的电子书基本信息")
    @PostMapping("list_simple")
    public ResultData<IPage<GeneralBookSimpleDto>> listBooksSimpleByAccountId(@RequestBody PageQueryReqDto<String> queryReqDto) {
        String accountId = queryReqDto.getReqParam("accountId");
        if (StringUtil.isNullOrEmpty(accountId)) {
            throw new BusinessException(CommCodeMsg.CODE_TERMINATE, CommCodeMsg.MSG_PARAMS_ERR);
        }

        // 模糊查询-标题
        String titleLike = queryReqDto.getReqParam("title");
        // 模糊查询-作者
        String authorLike = queryReqDto.getReqParam("authors");

        Page<GeneralBookSimpleDto> page = new Page<>(queryReqDto.getCurrentPage(), queryReqDto.getLimit());
        IPage<GeneralBookSimpleDto> iPage = null;
        if (!StringUtil.isNullOrEmpty(titleLike) || !StringUtil.isNullOrEmpty(authorLike)) {
            iPage = generalBookService.findBookSimpleByAccountId(accountId, titleLike, authorLike, page);
        } else {
            iPage = generalBookService.findBooksSimpleByAccountId(accountId, page);
        }
        return ResultData.success(iPage);
    }

    /**
     * 查询指定用户5日内的最近阅读信息
     * @param req accountId(必要) - 用户账号ID
     * @return
     */
    @ApiOperation("查询指定用户账号的最近5日阅读电子书信息")
    @PostMapping("list/recent")
    public ResultData<List<GeneralBookRecentReadingDto>> listLatestReadingBooksByAccountId(@RequestBody Map<String, String> req) {

        String accountId = req.get("accountId");
        if (StringUtil.isNullOrEmpty(accountId)) {
            throw new BusinessException(CommCodeMsg.CODE_TERMINATE, CommCodeMsg.MSG_PARAMS_ERR);
        }

        List<BookProgressIndexDto> bookProgressIndexDtoList = bookProgressIndexService.findRecentReadingProgressIndexByAccountId(accountId);

        List<GeneralBookRecentReadingDto> recentReadingDtoList = generalBookService.findRecentReadingBooks(bookProgressIndexDtoList);

        /*List<GeneralBookLatestReadingVO> resultList = new ArrayList<>();

        // 获取 阅读进度ID对应电子书ID索引
        List<Map<String, String>> recentReadingIndexList = messDataService.findBookAndReadingProgressRelatedIndexesByAccountId(accountId);

        // 获取实体信息
        for (Map<String, String> recentReadingIndex:
             recentReadingIndexList) {
            GeneralBook book = generalBookService.getById(recentReadingIndex.get("bookId"));
            GeneralReadingProgress readingProgress = generalReadingProgressService.getById(recentReadingIndex.get("progressId"));
            GeneralBookLatestReadingVO vo = GeneralBookLatestReadingVO.getInstance(book, readingProgress);
            resultList.add(vo);
        }*/

        return ResultData.success(recentReadingDtoList);
    }


    /**
     * 批量移除电子书
     * @param bookIds 电子书ID列表
     * @return
     */
    @ApiOperation("批量移除电子书")
    @PostMapping("remove")
    public ResultData<Object> removeBooks(@RequestBody String[] bookIds) {

        if (StringUtil.isStringsBlank(bookIds)) {
            throw new BusinessException(CommCodeMsg.CODE_TERMINATE, CommCodeMsg.MSG_PARAMS_ERR);
        }

        for (String bookId : bookIds) {
            // 删除电子书信息（元数据、书签、阅读进度、阅读配置）及其文件
            generalBookService.deleteBookByBookId(bookId);
            generalBookmarkService.deleteBookmarksByBookId(bookId);
            generalReadingProgressService.deleteReadingProgressesByBookId(bookId);
            generalReadingConfigService.deleteReadingConfigByBookId(bookId);

            // 删除电子书关联索引信息（关联的用户帐号、书签ID、阅读进度ID、阅读配置ID）
            accountBookIndexService.deleteByBookId(bookId);
            bookBookmarkIndexService.deleteByBookId(bookId);
            bookProgressIndexService.deleteByBookId(bookId);
            bookConfigIndexService.deleteByBookId(bookId);
//            recentReadingBookIndexService.deleteByBookId(bookId);
        }

        return ResultData.success();
    }
}
