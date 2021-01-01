package com.heng.reading.apiservice.comms.data;

/**
 * 通用请求返回数据结构
 * @author heng
 */
public class ResultData<T> {

    /**
     * 响应代码
     */
    private int code;

    /**
     * 响应信息
     */
    private String msg;

    /**
     * 响应数据
     */
    private T data;

    private ResultData() {
    }

    private ResultData(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    /**
     * 无数据 成功返回
     * @return 空数据返回
     */
    public static ResultData<Object> success() {
        return new ResultData<>(CommCodeMsg.CODE_OK, CommCodeMsg.MSG_DONE, null);
    }

    /**
     * 字符串 成功返回
     * @param data 字符串数据
     * @return 字符串数据返回
     */
    public static ResultData<String> success(String data) {
        return new ResultData<>(CommCodeMsg.CODE_OK, CommCodeMsg.MSG_DONE, data);
    }

    /**
     * 通用 成功返回
     * @param data 通用数据
     * @param <T> 数据类型
     * @return 可序列化数据返回
     */
    public static <T>ResultData<T> success(T data) {
        return new ResultData<>(CommCodeMsg.CODE_OK, CommCodeMsg.MSG_DONE, data);
    }

    /**
     * 系统错误
     * @param data 系统错误数据
     * @return 系统错误数据返回
     */
    public static ResultData<String> sysFail(String data) {
        return new ResultData<>(CommCodeMsg.CODE_SYS_ERR, CommCodeMsg.MSG_SYS_ERR, data);
    }

    /**
     * 用户帐号验证错误
     * @return 无数据 验证错误返回
     */
    public static ResultData<Object> authFail() {
        return new ResultData<>(CommCodeMsg.CODE_AUTH_ERR, CommCodeMsg.MSG_AUTH_ERR, null);
    }

    /**
     * 操作终止
     * @param msg 终止信息
     * @return 终止信息返回
     */
    public static ResultData<Object> terminatedFail(String msg) {
        return new ResultData<>(CommCodeMsg.CODE_TERMINATE, msg, null);
    }
}
