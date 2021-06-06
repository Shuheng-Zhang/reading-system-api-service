package com.heng.reading.apiservice.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.heng.reading.apiservice.dto.progress.GeneralReadingProgressSimpleDto;
import com.heng.reading.apiservice.entity.GeneralReadingProgress;

/**
 * @author heng
 */
public interface GeneralReadingProgressMapper extends BaseMapper<GeneralReadingProgress> {

    /**
     * 查询指定ID的阅读进度数据对象
     * @param progressId 阅读进度ID
     * @return
     */
    GeneralReadingProgressSimpleDto queryReadingProgressById(String progressId);

    /**
     * 删除当前电子书所有阅读进度
     * @param bookId 电子书ID
     * @return
     */
    int deleteByBookId(String bookId);

    /**
     * 查询当前电子书阅读进度列表
     * @param bookId 电子书ID
     * @param page 分页控制
     * @return
     */
    IPage<GeneralReadingProgress> queryReadingProgressesByBookId(String bookId, Page<GeneralReadingProgress> page);
}