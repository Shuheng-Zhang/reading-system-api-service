package com.heng.reading.apiservice.comms.data;

/**
 * 通用代码/信息
 * @author heng
 */
public class CommCodeMsg {

    /**
     * 代码 运行正常
     */
    final public static int CODE_OK = 200;

    /**
     * 代码 系统错误
     */
    final public static int CODE_SYS_ERR = 500;

    /**
     * 代码 验证错误
     */
    final public static int CODE_AUTH_ERR = 400;

    /**
     * 代码 操作终止
     */
    final public static int CODE_TERMINATE = -200;

    /**
     * 信息 运行正常
     */
    final public static String MSG_DONE = "DONE";

    /**
     * 信息 用户名或用户验证凭证错误
     */
    final public static String MSG_AUTH_ERR = "USERNAME OR CERTIFICATION INVALID";

    /**
     * 信息 文件类型不支持
     */
    final public static String MSG_FILE_NOT_SUPPORT = "FILE TYPE NOT SUPPORTED";

    /**
     * 信息 参数错误
     */
    final public static String MSG_PARAMS_ERR = "PARAMS INVALID";

    /**
     * 信息 数据对象不存在
     */
    final public static String MSG_OBJ_NOT_FOUND = "DATA OBJECT NOT FOUND";

    /**
     * 信息 系统错误
     */
    final public static String MSG_SYS_ERR = "SYSTEM ERROR OCCURRED";

    /**
     * 信息 不可重复数据错误
     */
    final public static String MSG_DUPLICATED_REQUEST_ERR = "DUPLICATED REQUEST ERROR";
}