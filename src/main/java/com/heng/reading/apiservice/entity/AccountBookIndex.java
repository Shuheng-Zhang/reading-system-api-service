package com.heng.reading.apiservice.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 用户帐号-电子书关联表
 * @author heng
 */
@Data
@TableName(value = "account_book_index")
public class AccountBookIndex {
    /**
     * 主键
     */
    @TableId(value = "id")
    private String id;

    /**
     * 用户帐号ID
     */
    @TableField(value = "account_id")
    private String accountId;

    /**
     * 电子书ID
     */
    @TableField(value = "book_id")
    private String bookId;
}