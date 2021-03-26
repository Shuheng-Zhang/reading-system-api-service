package com.heng.reading.apiservice.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.heng.reading.apiservice.comms.data.CommCodeMsg;
import com.heng.reading.apiservice.comms.data.PageQueryReqDto;
import com.heng.reading.apiservice.comms.data.ResultData;
import com.heng.reading.apiservice.comms.exception.BusinessException;
import com.heng.reading.apiservice.comms.utils.StringUtil;
import com.heng.reading.apiservice.entity.GeneralBook;
import com.heng.reading.apiservice.service.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

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

    /**
     * 分页查询指定用户帐号的电子书信息
     * @param queryReqDto requests.accountId - 用户帐号ID
     * @return
     */
    @ApiOperation("分页查询指定用户帐号的电子书信息")
    @PostMapping("list")
    public ResultData<IPage<GeneralBook>> listBooksByAccountId(@RequestBody PageQueryReqDto<String> queryReqDto) {

        String accountId = queryReqDto.getReqParam("accountId");

        if (StringUtil.isNullOrEmpty(accountId)) {
            throw new BusinessException(CommCodeMsg.CODE_TERMINATE, CommCodeMsg.MSG_PARAMS_ERR);
        }

        Page<GeneralBook> page = new Page<>(queryReqDto.getCurrentPage(), queryReqDto.getLimit());
        IPage<GeneralBook> iPage = generalBookService.findBooksByAccountId(accountId, page);

        return ResultData.success(iPage);
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
            generalBookService.removeBookByBookId(bookId);
            generalBookmarkService.deleteBookmarksByBookId(bookId);
            generalReadingProgressService.deleteReadingProgressesByBookId(bookId);
            generalReadingConfigService.deleteReadingConfigByBookId(bookId);

            // 删除电子书关联索引信息（关联的用户帐号、书签ID、阅读进度ID、阅读配置ID）
            accountBookIndexService.deleteByBookId(bookId);
            bookBookmarkIndexService.deleteByBookId(bookId);
            bookProgressIndexService.deleteByBookId(bookId);
            bookConfigIndexService.deleteByBookId(bookId);
        }

        return ResultData.success();
    }
}
