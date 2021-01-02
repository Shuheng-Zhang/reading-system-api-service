package com.heng.reading.apiservice.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.heng.reading.apiservice.entity.BookBookmarkIndex;

/**
 * @author heng
 */
public interface BookBookmarkIndexMapper extends BaseMapper<BookBookmarkIndex> {

    /**
     * 删除当前书签与电子书的关联索引
     * @param bookmarkId 书签ID
     * @return
     */
    int deleteByBookmarkId(String bookmarkId);

    /**
     * 删除当前电子书的所有书签关联索引
     * @param bookId
     * @return
     */
    int deleteByBookId(String bookId);
}