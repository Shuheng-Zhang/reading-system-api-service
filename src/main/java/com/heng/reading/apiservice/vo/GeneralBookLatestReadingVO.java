package com.heng.reading.apiservice.vo;
import com.heng.reading.apiservice.comms.data.CommCodeMsg;
import com.heng.reading.apiservice.comms.exception.BusinessException;
import com.heng.reading.apiservice.entity.GeneralBook;
import com.heng.reading.apiservice.entity.GeneralReadingProgress;
import lombok.Data;

/**
 * 通用 电子书-阅读进度 数据对象
 * @author heng
 */
@Data
public class GeneralBookLatestReadingVO {
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
     * 书目文件URL
     */
    private String bookFileUrl;
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

    private GeneralBookLatestReadingVO() {}

    /**
     * 创建 电子书-阅读进度 关联数据对象
     * @param bookInfo 电子书信息实例
     * @param readingProgressInfo 阅读进度信息实例
     * @return 关联数据对象
     */
    public static GeneralBookLatestReadingVO getInstance(GeneralBook bookInfo, GeneralReadingProgress readingProgressInfo) {
        if (bookInfo == null || readingProgressInfo == null) {
            throw new BusinessException(CommCodeMsg.CODE_TERMINATE, CommCodeMsg.MSG_PARAMS_ERR);
        }

        GeneralBookLatestReadingVO vo = new GeneralBookLatestReadingVO();
        vo.setBookId(bookInfo.getId());
        vo.setBookTitle(bookInfo.getBookTitle());
        vo.setBookAuthors(bookInfo.getBookAuthors());
        vo.setBookCoverUrl(bookInfo.getBookCoverUrl());
        vo.setBookFileUrl(bookInfo.getBookFileUrl());
        vo.setLatestReadTime(readingProgressInfo.getProgressCreatedTime());
        vo.setProgressLocationIndex(readingProgressInfo.getProgressLocationIndex());
        vo.setProgressPercentage(readingProgressInfo.getProgressPercentage());
        vo.setProgressTitle(readingProgressInfo.getProgressTitle());

        return vo;
    }
}
