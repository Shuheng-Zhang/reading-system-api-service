package com.heng.reading.apiservice.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.heng.reading.apiservice.entity.GeneralReadingProgress;

/**
 * @author heng
 */
public interface GeneralReadingProgressMapper extends BaseMapper<GeneralReadingProgress> {

    /**
     * 删除当前电子书所有阅读进度
     * @param bookId 电子书ID
     * @return
     */
    int deleteByBookId(String bookId);
}