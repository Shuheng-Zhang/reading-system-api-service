package com.heng.reading.apiservice.service;

import com.heng.reading.apiservice.entity.BookProgressIndex;
import com.baomidou.mybatisplus.extension.service.IService;
/**
 * @author heng
 */
public interface BookProgressIndexService extends IService<BookProgressIndex> {

    /**
     * 删除当前电子书关联的所有阅读进度索引
     * @param bookId 电子书ID
     */
    void deleteByBookId(String bookId);
}
