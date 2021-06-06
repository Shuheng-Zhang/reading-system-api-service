package com.heng.reading.apiservice.dto.progress;

import lombok.Data;

@Data
public class GeneralReadingProgressSimpleDto {

    /**
     * 进度-章节名称
     */
    private String progressTitle;

    /**
     * 进度-百分比
     */
    private String progressPercentage;

    /**
     * 进度-位置索引
     */
    private String progressLocationIndex;

    /**
     * 进度-更新时间
     */
    private String progressUpdatedTime;
}
