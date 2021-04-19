package com.heng.reading.apiservice.service;

import com.heng.reading.apiservice.entity.BookConfigIndex;
import com.baomidou.mybatisplus.extension.service.IService;
/**
 * @author heng
 */
public interface BookConfigIndexService extends IService<BookConfigIndex> {

    /**
     * 删除当前电子书关联的所有阅读配置索引
     * @param bookId 电子书ID
     */
    void deleteByBookId(String bookId);

    /**
     * 检查电子书阅读配置是否存在
     * @param bookId 电子书ID
     */
    void checkReadingConfigExisted(String bookId);

    /**
     * 配置 电子书-阅读配置索引
     * 配置 索引主键
     * 配置 电子书ID
     * 配置 阅读配置ID
     * @param bookId 源电子书ID
     * @param configId 源阅读配置ID
     * @return
     */
    BookConfigIndex config(String bookId, String configId);
}
