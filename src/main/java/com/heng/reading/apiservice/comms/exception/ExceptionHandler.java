package com.heng.reading.apiservice.comms.exception;


import com.heng.reading.apiservice.comms.data.ResultData;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局统一异常处理器
 * @author heng
 */
@RestControllerAdvice
public class ExceptionHandler {

    /**
     * 处理业务异常
     * @param e 业务异常
     * @return
     */
    @org.springframework.web.bind.annotation.ExceptionHandler(value = BusinessException.class)
    public ResultData<Object> businessExceptionHandler(BusinessException e) {
        return ResultData.terminatedFail(e.getErrMsg());
    }

    /**
     * 处理其他异常
     * @param e 缺省处理异常
     * @return
     */
    @org.springframework.web.bind.annotation.ExceptionHandler(value = Exception.class)
    public ResultData<String> generateExceptionHandler(Exception e) {
        return ResultData.sysFail(e.getMessage());
    }
}
