package com.heng.reading.apiservice.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.heng.reading.apiservice.entity.BookConfigIndex;

/**
 * @author heng
 */
public interface BookConfigIndexMapper extends BaseMapper<BookConfigIndex> {

    /**
     * 删除当前阅读配置与电子书的关联索引
     * @param configId 阅读配置ID
     * @return
     */
    int deleteByConfigId(String configId);

    /**
     * 删除当前电子书与阅读配置的关联索引
     * @param bookId 电子书ID
     * @return
     */
    int deleteByBookId(String bookId);
}