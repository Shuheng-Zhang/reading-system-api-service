package com.heng.reading.apiservice.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 最近阅读索引
 * @author heng
 */
@Data
@TableName(value = "recent_reading_book_index")
public class RecentReadingBookIndex {
    /**
     * 主键
     */
    @TableId(value = "id")
    private String id;

    /**
     * 用户账号ID
     */
    @TableField(value = "account_id")
    private String accountId;

    /**
     * 电子书ID
     */
    @TableField(value = "book_id")
    private String bookId;

    /**
     * 最后阅读时间
     */
    @TableField(value = "latest_read_time")
    private String latestReadTime;
}
