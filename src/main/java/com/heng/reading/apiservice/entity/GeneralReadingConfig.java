package com.heng.reading.apiservice.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 通用阅读配置表
 * @author heng
 */
@Data
@TableName(value = "general_reading_config")
public class GeneralReadingConfig {
    /**
     * 主键
     */
    @TableId(value = "id")
    private String id;

    /**
     * 配置-字体
     */
    @TableField(value = "config_font_family")
    private String configFontFamily;

    /**
     * 配置-字体大小
     */
    @TableField(value = "config_font_size")
    private String configFontSize;

    /**
     * 配置-字体样式
     */
    @TableField(value = "config_font_style")
    private String configFontStyle;

    /**
     * 配置-阅读主题样式
     */
    @TableField(value = "config_theme")
    private String configTheme;
}