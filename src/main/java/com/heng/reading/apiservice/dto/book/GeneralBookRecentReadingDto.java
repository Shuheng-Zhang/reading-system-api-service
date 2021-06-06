package com.heng.reading.apiservice.dto.book;
import com.heng.reading.apiservice.comms.data.CommCodeMsg;
import com.heng.reading.apiservice.comms.exception.BusinessException;
import com.heng.reading.apiservice.dto.progress.GeneralReadingProgressSimpleDto;
import lombok.Data;

/**
 * 通用 电子书-阅读进度 数据对象
 * @author heng
 */
@Data
public class GeneralBookRecentReadingDto {
    /**
     * 电子书ID
     */
    private String bookId;
    /**
     * 书目标题
     */
    private String bookTitle;
    /**
     * 书目作者
     */
    private String bookAuthors;
    /**
     * 书目封面URL
     */
    private String bookCoverUrl;
    /**
     * 电子书 OPF 文件URL
     */
    private String bookOpfUrl;
    /**
     * 阅读进度章节标题
     */
    private String progressTitle;
    /**
     * 阅读进度百分比
     */
    private String progressPercentage;
    /**
     * 阅读进度定位索引(ePub CFI 索引)
     */
    private String progressLocationIndex;
    /**
     * 最后阅读时间
     */
    private String latestReadTime;

    private GeneralBookRecentReadingDto() {}

    /**
     * 创建 电子书-阅读进度 关联数据对象
     * @param bookInfo 电子书信息实例
     * @param readingProgressInfo 阅读进度信息实例
     * @return 关联数据对象
     */
    public static GeneralBookRecentReadingDto getInstance(GeneralBookSimpleDto bookInfo, GeneralReadingProgressSimpleDto readingProgressInfo) {
        if (bookInfo == null || readingProgressInfo == null) {
            throw new BusinessException(CommCodeMsg.CODE_TERMINATE, CommCodeMsg.MSG_PARAMS_ERR);
        }

        GeneralBookRecentReadingDto vo = new GeneralBookRecentReadingDto();
        vo.setBookId(bookInfo.getId());
        vo.setBookTitle(bookInfo.getBookTitle());
        vo.setBookAuthors(bookInfo.getBookAuthors());
        vo.setBookCoverUrl(bookInfo.getBookCoverUrl());
        vo.setBookOpfUrl(bookInfo.getBookOpfUrl());
        vo.setLatestReadTime(readingProgressInfo.getProgressUpdatedTime());
        vo.setProgressLocationIndex(readingProgressInfo.getProgressLocationIndex());
        vo.setProgressPercentage(readingProgressInfo.getProgressPercentage());
        vo.setProgressTitle(readingProgressInfo.getProgressTitle());

        return vo;
    }
}
