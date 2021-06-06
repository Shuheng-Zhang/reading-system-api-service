package com.heng.reading.apiservice.service;

import com.heng.reading.apiservice.dto.progress.BookProgressIndexDto;
import com.heng.reading.apiservice.entity.BookProgressIndex;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * @author heng
 */
public interface BookProgressIndexService extends IService<BookProgressIndex> {

    /**
     * 删除当前电子书关联的所有阅读进度索引
     * @param bookId 电子书ID
     */
    void deleteByBookId(String bookId);

    /**
     * 删除当前阅读进度与电子书的索引
     * @param progressId 阅读进度ID
     */
    void deleteByProgressId(String progressId);

    /**
     * 查询指定用户账号近5日阅读进度索引
     * @param accountId 用户账号ID
     * @return
     */
    List<BookProgressIndexDto> findRecentReadingProgressIndexByAccountId(String accountId);

    /**
     * 配置 电子书-阅读进度索引
     * @param bookId 电子书ID
     * @param progressId 阅读进度ID
     * @return
     */
    BookProgressIndex config(String bookId, String progressId);
}
