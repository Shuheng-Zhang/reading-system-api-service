package com.heng.reading.apiservice.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.heng.reading.apiservice.comms.data.CommCodeMsg;
import com.heng.reading.apiservice.comms.data.PageQueryReqDto;
import com.heng.reading.apiservice.comms.data.ResultData;
import com.heng.reading.apiservice.comms.exception.BusinessException;
import com.heng.reading.apiservice.comms.utils.StringUtil;
import com.heng.reading.apiservice.comms.utils.UUIDUtil;
import com.heng.reading.apiservice.entity.BookBookmarkIndex;
import com.heng.reading.apiservice.entity.GeneralBookmark;
import com.heng.reading.apiservice.service.BookBookmarkIndexService;
import com.heng.reading.apiservice.service.GeneralBookService;
import com.heng.reading.apiservice.service.GeneralBookmarkService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 书签数据控制器
 * @author heng
 */
@RestController
@RequestMapping("/bookmark")
public class GeneralBookmarkController {

    @Resource
    private GeneralBookService generalBookService;

    @Resource
    private GeneralBookmarkService generalBookmarkService;

    @Resource
    private BookBookmarkIndexService bookBookmarkIndexService;

    /**
     * 创建电子书书签
     * @param bookId 电子书ID
     * @param bookmark 书签信息
     * @return
     */
    @PostMapping("{bookId}/create")
    public ResultData<Object> createBookmark(@PathVariable("bookId") String bookId, @RequestBody GeneralBookmark bookmark) {

        // 检查电子书信息是否存在
        generalBookService.checkBookExisted(bookId);

        if (bookmark == null) {
            throw new BusinessException(CommCodeMsg.CODE_TERMINATE, CommCodeMsg.MSG_PARAMS_ERR);
        }

        String bookmarkId = UUIDUtil.uuid();
        bookmark.setId(bookmarkId);
        bookmark.setBookmarkCreatedTime(StringUtil.getCurrentTime());

        // 创建电子书与书签索引
        BookBookmarkIndex bookBookmarkIndex = new BookBookmarkIndex();
        bookBookmarkIndex.setBookmarkId(bookmarkId);
        bookBookmarkIndex.setBookId(bookId);
        bookBookmarkIndex.setId(UUIDUtil.uuid());

        // 保存书签信息
        generalBookmarkService.save(bookmark);
        // 保存电子书-书签索引信息
        bookBookmarkIndexService.save(bookBookmarkIndex);

        return ResultData.success();
    }

    /**
     * 分页查询电子书书签列表
     * @param queryReqDto requests.bookId - 电子书ID
     * @return
     */
    @PostMapping("list")
    public ResultData<IPage<GeneralBookmark>> listBookmarksByBookId(@RequestBody PageQueryReqDto<String> queryReqDto) {
        String bookId = queryReqDto.getReqParam("bookId");

        if (StringUtil.isNullOrEmpty(bookId)) {
            throw new BusinessException(CommCodeMsg.CODE_TERMINATE, CommCodeMsg.MSG_PARAMS_ERR);
        }

        Integer currentPage = queryReqDto.getCurrentPage();;
        Integer limit = queryReqDto.getLimit();

        Page<GeneralBookmark> page = new Page<>(currentPage, limit);

        IPage<GeneralBookmark> iPage = generalBookmarkService.findBookmarksByBookId(bookId, page);

        return ResultData.success(iPage);
    }

    /**
     * 批量删除电子书书签
     * @param bookmarkIds 书签ID列表
     * @return
     */
    @PostMapping("remove")
    public ResultData<Object> removeBookmarks(@RequestBody String[] bookmarkIds) {
        if (StringUtil.isStringsBlank(bookmarkIds)) {
            throw new BusinessException(CommCodeMsg.CODE_TERMINATE, CommCodeMsg.MSG_PARAMS_ERR);
        }

        for (String bookmarkId : bookmarkIds) {
            // 删除当前书签信息
            generalBookmarkService.removeById(bookmarkId);
            // 删除当前书签与电子书的关联索引信息
            bookBookmarkIndexService.deleteByBookmarkId(bookmarkId);
        }

        return ResultData.success();
    }
}
