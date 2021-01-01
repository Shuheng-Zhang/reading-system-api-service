package com.heng.reading.apiservice.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 电子书-阅读配置关联表
 * @author heng
 */
@Data
@TableName(value = "book_config_index")
public class BookConfigIndex {
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
     * 阅读配置ID
     */
    @TableField(value = "config_id")
    private String configId;
}