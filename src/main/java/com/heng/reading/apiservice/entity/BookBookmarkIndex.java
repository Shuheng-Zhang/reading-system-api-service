package com.heng.reading.apiservice.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 电子书-书签关联表
 * @author heng
 */
@Data
@TableName(value = "book_bookmark_index")
public class BookBookmarkIndex {
    /**
     * 主键
     */
    @TableId(value = "id")
    private String id;

    /**
     * 电子书ID
     */
    @TableField(value = "book_id")
    private String bookId;

    /**
     * 书签ID
     */
    @TableField(value = "bookmark_id")
    private String bookmarkId;
}