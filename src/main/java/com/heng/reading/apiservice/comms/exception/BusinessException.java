package com.heng.reading.apiservice.comms.exception;


/**
 * 业务异常类
 * @author heng
 */
public class BusinessException extends RuntimeException {

    protected Integer errCode;
    protected String errMsg;


    public BusinessException() {}

    public BusinessException(Integer errCode, String errMsg) {
        this.errCode = errCode;
        this.errMsg = errMsg;
    }

    public Integer getErrCode() {
        return errCode;
    }

    public void setErrCode(Integer errCode) {
        this.errCode = errCode;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    @Override
    public String toString() {
        return "BusinessException{" +
                "errCode=" + errCode +
                ", errMsg='" + errMsg + '\'' +
                '}';
    }
}
