package com.heng.reading.apiservice.service;

import com.heng.reading.apiservice.entity.BookBookmarkIndex;
import com.baomidou.mybatisplus.extension.service.IService;
/**
 * @author heng
 */
public interface BookBookmarkIndexService extends IService<BookBookmarkIndex> {

    /**
     * 删除当前电子书关联的所有书签索引
     * @param bookId 电子书ID
     */
    void deleteByBookId(String bookId);

    /**
     * 删除当前书签关联的电子书索引
     * @param bookmarkId 书签ID
     */
    void deleteByBookmarkId(String bookmarkId);

    /**
     * 配置 电子书-书签索引
     * 创建 索引主键
     * @param bookId 源电子书ID
     * @param bookmarkId 源书签ID
     * @return
     */
    BookBookmarkIndex configIndex(String bookId, String bookmarkId);
}
