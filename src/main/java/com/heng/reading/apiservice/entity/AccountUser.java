package com.heng.reading.apiservice.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 服务用户帐号表
 * @author heng
 */
@Data
@TableName(value = "account_user")
public class AccountUser {
    /**
     * 主键
     */
    @TableId(value = "id")
    private String id;

    /**
     * 用户名
     */
    @TableField(value = "user_name")
    private String userName;

    /**
     * 用户验证凭证
     */
    @TableField(value = "user_certification")
    private String userCertification;

    /**
     * 用户类型
     */
    @TableField(value = "user_type")
    private String userType;

    /**
     * 用户安全密钥
     */
    @TableField(value = "user_security_key")
    private String userSecurityKey;
}