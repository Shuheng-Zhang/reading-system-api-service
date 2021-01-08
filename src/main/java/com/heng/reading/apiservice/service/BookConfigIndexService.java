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
}
