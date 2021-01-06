package com.heng.reading.apiservice.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 通用电子书表
 * @author heng
 */
@Data
@TableName(value = "general_book")
public class GeneralBook {
    /**
     * 主键
     */
    @TableId(value = "id")
    private String id;

    /**
     * 电子书标题
     */
    @TableField(value = "book_title")
    private String bookTitle;

    /**
     * 电子书作者
     */
    @TableField(value = "book_authors")
    private String bookAuthors;

    /**
     * 电子书简介
     */
    @TableField(value = "book_description")
    private String bookDescription;

    /**
     * 电子书封面URL
     */
    @TableField(value = "book_cover_url")
    private String bookCoverUrl;

    /**
     * 电子书容量
     */
    @TableField(value = "book_size")
    private String bookSize;

    /**
     * 电子书收录时间
     */
    @TableField(value = "book_pushed_time")
    private String bookPushedTime;

    /**
     * 电子书文件URL
     */
    @TableField(value = "book_file_url")
    private String bookFileUrl;
}