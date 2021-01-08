package com.heng.reading.apiservice.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 通用书签表
 * @author heng
 */
@Data
@TableName(value = "general_bookmark")
public class GeneralBookmark {
    /**
     * 主键
     */
    @TableId(value = "id")
    private String id;

    /**
     * 书签-章节标题
     */
    @TableField(value = "bookmark_title")
    private String bookmarkTitle;

    /**
     * 书签-创建时间
     */
    @TableField(value = "bookmark_created_time")
    private String bookmarkCreatedTime;

    /**
     * 书签-位置索引
     */
    @TableField(value = "bookmark_location_index")
    private String bookmarkLocationIndex;

    /**
     * 书签-位置内容简录
     */
    @TableField(value = "bookmark_location_content")
    private String bookmarkLocationContent;
}