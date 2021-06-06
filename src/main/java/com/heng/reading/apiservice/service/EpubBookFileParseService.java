package com.heng.reading.apiservice.service;

import nl.siegmann.epublib.domain.Book;

import java.io.IOException;
import java.util.Map;

/**
 * @author heng
 */
public interface EpubBookFileParseService {

    /**
     * 加载 ePub 文件
     * @param bookPath 电子书路径
     * @return ePub Book 对象
     * @exception IOException
     */
    Book loadEpub(String bookPath);

    /**
     * 获取 ePub OPF 索引文件相对地址
     * @param epubBook ePub Book 对象
     * @param accountId 用户账号ID
     * @param unzipDirName 解压缩目录名
     * @return ePub OPF 相对路径
     */
    String fetchOpfUrl(Book epubBook, String accountId, String unzipDirName);

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
    String fetchBookCover(Book epubBook, String accountId);

    /**
     * 解压缩 ePub 到指定路径
     * @param epubFilePath ePub 源文件路径
     * @param destPath 解压缩目标存储路径
     */
    void ePubUnzip(String epubFilePath, String destPath);
}
