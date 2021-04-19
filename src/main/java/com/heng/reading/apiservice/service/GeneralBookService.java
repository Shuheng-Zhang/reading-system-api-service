package com.heng.reading.apiservice.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.heng.reading.apiservice.entity.GeneralBook;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
 * @author heng
 */
public interface GeneralBookService extends IService<GeneralBook> {

    /**
     * 查询指定用户帐号下的所有电子书信息
     * @param accountId 用户帐号ID
     * @param page 分页控制
     * @return
     */
    IPage<GeneralBook> findBooksByAccountId(String accountId, Page<GeneralBook> page);

    /**
     * 查询指定用户帐号下的所有电子书信息
     * @param accountId 用户账号ID
     * @param bookTitleLike 模糊查询-标题
     * @param bookAuthorsLike 模糊查询-作者
     * @param page 分页控制
     * @return
     */
    IPage<GeneralBook> findBooksByAccountId(String accountId, String bookTitleLike, String bookAuthorsLike, Page<GeneralBook> page);

    /**
     * 删除当前电子书信息及其文件数据
     * @param bookId 电子书ID
     */
    void removeBookByBookId(String bookId);

    /**
     * 检查电子书信息是否存在
     * @param bookId 电子书ID
     */
    void checkBookExisted(String bookId);

    /**
     * 配置 电子书信息
     * @param bookTitle 电子书标题
     * @param bookAuthors 电子书作者
     * @param bookDescription 电子书简介
     * @param bookCoverUrl 封面 URL
     * @param bookFileUrl 电子书文件 URL
     * @param bookSize 电子书文件容量
     * @param bookPushedTime 电子书收录时间
     * @return
     */
    GeneralBook config(String bookTitle, String bookAuthors, String bookDescription, String bookCoverUrl, String bookFileUrl, String bookSize, String bookPushedTime);

    /**
     * 配置 电子书信息
     * @param metadata 电子书元数据(标题、作者、简介)
     * @param bookCoverUrl 封面 URL
     * @param bookFileUrl 电子书文件 URL
     * @param bookSize 电子书文件容量
     * @param bookPushedTime 电子书收录时间
     * @return
     */
    GeneralBook config(Map<String, String> metadata, String bookCoverUrl, String bookFileUrl, String bookSize, String bookPushedTime);
}
