package com.heng.reading.apiservice.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.heng.reading.apiservice.comms.data.CommCodeMsg;
import com.heng.reading.apiservice.comms.data.PageQueryReqDto;
import com.heng.reading.apiservice.comms.data.ResultData;
import com.heng.reading.apiservice.comms.exception.BusinessException;
import com.heng.reading.apiservice.comms.utils.StringUtil;
import com.heng.reading.apiservice.comms.utils.UUIDUtil;
import com.heng.reading.apiservice.entity.BookProgressIndex;
import com.heng.reading.apiservice.entity.GeneralReadingProgress;
import com.heng.reading.apiservice.service.BookProgressIndexService;
import com.heng.reading.apiservice.service.GeneralBookService;
import com.heng.reading.apiservice.service.GeneralReadingProgressService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 电子书阅读进度数据控制器
 * @author heng
 */
@Api(tags = "电子书阅读进度数据控制器")
@RestController
@RequestMapping("/readingProgress")
public class GeneralReadingProgressController {

    @Resource
    private GeneralBookService generalBookService;

    @Resource
    private GeneralReadingProgressService generalReadingProgressService;

    @Resource
    private BookProgressIndexService bookProgressIndexService;

    /**
     * 创建电子书阅读进度
     * @param bookId 电子书ID
     * @param readingProgress 阅读进度数据
     * @return
     */
    @ApiOperation("创建电子书阅读进度")
    @PostMapping("create/{bookId}")
    public ResultData<Object> createReadingProgress(@PathVariable("bookId") String bookId, @RequestBody GeneralReadingProgress readingProgress) {

        // 检查当前电子书信息是否存在
        generalBookService.checkBookExisted(bookId);

        GeneralReadingProgress targetReadingProgress = generalReadingProgressService.config(readingProgress);

        BookProgressIndex targetIndex = bookProgressIndexService.config(bookId, targetReadingProgress.getId());

        // 保存阅读进度数据
        generalReadingProgressService.save(targetReadingProgress);
        // 创建阅读进度与电子书关联索引
        bookProgressIndexService.save(targetIndex);

        return ResultData.success();
    }

    /**
     * 查询电子书阅读进度列表
     * @param queryReqDto requests.bookId - 电子书ID
     * @return
     */
    @ApiOperation("查询电子书阅读进度列表")
    @PostMapping("/list")
    public ResultData<IPage<GeneralReadingProgress>> listReadingProgressesByBookId(@RequestBody PageQueryReqDto<String> queryReqDto) {
        Integer currentPage = queryReqDto.getCurrentPage();
        Integer limit = queryReqDto.getLimit();

        String bookId = queryReqDto.getReqParam("bookId");
        if (StringUtil.isNullOrEmpty(bookId)) {
            throw new BusinessException(CommCodeMsg.CODE_TERMINATE, CommCodeMsg.MSG_PARAMS_ERR);
        }

        Page<GeneralReadingProgress> page = new Page<>(currentPage, limit);
        IPage<GeneralReadingProgress> iPage = generalReadingProgressService.findReadingProgressesByBookId(bookId, page);

        return ResultData.success(iPage);
    }

    /**
     * 批量删除阅读进度信息
     * @param progressIds 阅读进度ID列表
     * @return
     */
    @ApiOperation("批量删除阅读进度信息")
    @PostMapping("remove")
    public ResultData<Object> removeReadingProgresses(@RequestBody String[] progressIds) {
        if (StringUtil.isStringsBlank(progressIds)) {
            throw new BusinessException(CommCodeMsg.CODE_TERMINATE, CommCodeMsg.MSG_PARAMS_ERR);
        }

        for (String progressId : progressIds) {
            // 删除当前阅读进度数据
            generalReadingProgressService.removeById(progressId);
            // 删除当前阅读进度与电子书关联索引
            bookProgressIndexService.deleteByProgressId(progressId);
        }

        return ResultData.success();
    }
}
