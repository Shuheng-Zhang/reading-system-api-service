package com.heng.reading.apiservice.comms.aop;

/**
 * AOP 日志前缀
 */
public class LogPrefix {

    /**
     * 请求源URL 前缀
     */
    final public static String PREFIX_REQ_FROM = "REQ_FROM: ";

    /**
     * URI 前缀
     */
    final public static String PREFIX_REQ = "REQ_API: ";
    /**
     * 查询参数前缀
     */
    final public static String PREFIX_QUERY_PARAMS = "QUERY_PARAMS: ";
    /**
     * 请求体前缀
     */
    final public static String PREFIX_REQ_BODY = "REQ_BODY: ";
    /**
     * 相应成功前缀
     */
    final public static String PREFIX_RES_OK = "RES_INFO: ";

    /**
     * 相应错误前缀
     */
    final public static String PREFIX_RES_ERR = "RES_ERROR: ";
}
