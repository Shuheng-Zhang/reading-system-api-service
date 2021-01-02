package com.heng.reading.apiservice.service;

import com.heng.reading.apiservice.entity.GeneralReadingConfig;
import com.baomidou.mybatisplus.extension.service.IService;
/**
 * @author heng
 */
public interface GeneralReadingConfigService extends IService<GeneralReadingConfig> {

    /**
     * 删除当前电子书所有阅读配置
     * @param bookId 电子书ID
     */
    void deleteReadingConfigsByBookId(String bookId);
}
