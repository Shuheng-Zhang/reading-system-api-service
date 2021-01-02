package com.heng.reading.apiservice.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.heng.reading.apiservice.entity.GeneralReadingConfig;

/**
 * @author heng
 */
public interface GeneralReadingConfigMapper extends BaseMapper<GeneralReadingConfig> {

    /**
     * 删除当前电子书所有阅读配置
     * @param bookId 电子书ID
     * @return
     */
    int deleteByBookId(String bookId);
}