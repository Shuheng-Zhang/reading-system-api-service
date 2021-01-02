package com.heng.reading.apiservice.service;

import nl.siegmann.epublib.domain.Book;

import java.io.IOException;
import java.util.Map;

/**
 * @author heng
 */
public interface BookFileParseService {

    /**
     * 加载 ePub 文件
     * @param bookPath 电子书路径
     * @return ePub Book 对象
     * @exception IOException
     */
    Book loadEpub(String bookPath) throws IOException;

    /**
     * 获取 ePub 元数据
     * @param epubBook ePub 电子书对象
     * @return ePub 元数据
     */
    Map<String, String> fetchMetadata(Book epubBook);

    /**
     * 获取 ePub 封面图片
     * @param epubBook ePub 电子书对象
     * @param accountId 用户帐号ID
     * @return 封面图片URL
     * @exception IOException
     */
    String fetchBookCover(Book epubBook, String accountId) throws IOException;
}
