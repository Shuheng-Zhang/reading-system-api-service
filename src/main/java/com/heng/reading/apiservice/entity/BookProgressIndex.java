package com.heng.reading.apiservice.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 电子书-阅读进度关联表
 * @author heng
 */
@Data
@TableName(value = "book_progress_index")
public class BookProgressIndex {
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
     * 阅读进度ID
     */
    @TableField(value = "progress_id")
    private String progressId;
}