package com.heng.reading.apiservice.controller;

import com.heng.reading.apiservice.comms.data.CommCodeMsg;
import com.heng.reading.apiservice.comms.data.ResultData;
import com.heng.reading.apiservice.comms.exception.BusinessException;
import com.heng.reading.apiservice.comms.utils.StringUtil;
import com.heng.reading.apiservice.comms.utils.UUIDUtil;
import com.heng.reading.apiservice.entity.BookConfigIndex;
import com.heng.reading.apiservice.entity.GeneralReadingConfig;
import com.heng.reading.apiservice.service.BookConfigIndexService;
import com.heng.reading.apiservice.service.GeneralBookService;
import com.heng.reading.apiservice.service.GeneralReadingConfigService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;

/**
 * 电子书阅读配置数据控制器
 * @author heng
 */
@Api(tags = "电子书阅读配置数据控制器")
@RequestMapping("/readingConfig")
@RestController
public class GeneralReadingConfigController {

    @Resource
    private GeneralBookService generalBookService;
    @Resource
    private GeneralReadingConfigService generalReadingConfigService;
    @Resource
    private BookConfigIndexService bookConfigIndexService;

    /**
     * 创建电子书阅读配置
     * @param bookId 电子书ID
     * @param readingConfig 阅读配置
     * @return
     */
    @ApiOperation("创建电子书阅读配置")
    @PostMapping("create/{bookId}")
    public ResultData<Object> createReadingConfig(@PathVariable("bookId") String bookId, @RequestBody GeneralReadingConfig readingConfig) {

        // 检查当前电子书是否已创建阅读配置
        bookConfigIndexService.checkReadingConfigExisted(bookId);

        // 检查电子书是否存在
        generalBookService.checkBookExisted(bookId);

        GeneralReadingConfig targetConfig = generalReadingConfigService.config(readingConfig);

        BookConfigIndex targetIndex = bookConfigIndexService.config(bookId, targetConfig.getId());

        /*BookConfigIndex bookConfigIndex = new BookConfigIndex();
        bookConfigIndex.setId(UUIDUtil.uuid());
        bookConfigIndex.setConfigId(configId);
        bookConfigIndex.setBookId(bookId);*/

        // 保存阅读配置
        generalReadingConfigService.save(readingConfig);
        // 保存当前阅读配置与电子书关联索引
        bookConfigIndexService.save(targetIndex);

        return ResultData.success();
    }

    /**
     * 更新电子书阅读配置
     * @param readingConfig 电子书阅读配置
     * @return
     */
    @ApiOperation("更新电子书阅读配置")
    @PostMapping("update")
    public ResultData<Object> updateReadingConfig(@RequestBody GeneralReadingConfig readingConfig) {
        if (StringUtil.isNullOrEmpty(readingConfig.getId())) {
            throw new BusinessException(CommCodeMsg.CODE_TERMINATE, CommCodeMsg.MSG_PARAMS_ERR);
        }

        generalReadingConfigService.updateById(readingConfig);

        return ResultData.success();
    }

    /**
     * 获取当前电子书阅读配置
     * @param bookId 电子书ID
     * @return
     */
    @ApiOperation("获取当前电子书阅读配置")
    @GetMapping("fetch")
    public ResultData<GeneralReadingConfig> getReadingConfigByBookId(@RequestParam("bookId") String bookId) {
        GeneralReadingConfig readingConfig = generalReadingConfigService.findByBookId(bookId);

        return ResultData.success(readingConfig);
    }

    /**
     * 移除当前电子书阅读配置
     * @param reqMap bookId - 电子书ID
     * @return
     */
    @ApiOperation("移除当前电子书阅读配置")
    @PostMapping("remove")
    public ResultData<Object> removeReadingConfigById(@RequestBody Map<String, String> reqMap) {
        String id = reqMap.get("bookId");

        if (StringUtil.isNullOrEmpty(id)) {
            throw new BusinessException(CommCodeMsg.CODE_TERMINATE, CommCodeMsg.MSG_PARAMS_ERR);
        }

        generalReadingConfigService.deleteReadingConfigByBookId(id);
        bookConfigIndexService.deleteByBookId(id);

        return ResultData.success();
    }
}
