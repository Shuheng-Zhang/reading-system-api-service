package com.heng.reading.apiservice.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 通用阅读进度表
 * @author heng
 */
@Data
@TableName(value = "general_reading_progress")
public class GeneralReadingProgress {
    /**
     * 主键
     */
    @TableId(value = "id")
    private String id;

    /**
     * 进度-章节名称
     */
    @TableField(value = "progress_title")
    private String progressTitle;

    /**
     * 进度-百分比
     */
    @TableField(value = "progress_percentage")
    private String progressPercentage;

    /**
     * 进度-位置索引
     */
    @TableField(value = "progress_location_index")
    private String progressLocationIndex;

    /**
     * 进度-位置内容简录
     */
    @TableField(value = "progress_location_content")
    private String progressLocationContent;

    /**
     * 进度-更新时间
     */
    @TableField(value = "progress_updated_time")
    private String progressUpdatedTime;
}