package com.heng.reading.apiservice.service;

import com.heng.reading.apiservice.entity.GeneralReadingConfig;
import com.baomidou.mybatisplus.extension.service.IService;
/**
 * @author heng
 */
public interface GeneralReadingConfigService extends IService<GeneralReadingConfig> {

    /**
     * 删除当前电子书阅读配置
     * @param bookId 电子书ID
     */
    void deleteReadingConfigByBookId(String bookId);

    /**
     * 查询当前电子书阅读配置
     * @param bookId 电子书ID
     * @return
     */
    GeneralReadingConfig findByBookId(String bookId);

    /**
     * 配置 电子书阅读配置信息
     * 配置 配置实例主键
     * @param config 源配置信息
     * @return
     */
    GeneralReadingConfig config(GeneralReadingConfig config);
}
