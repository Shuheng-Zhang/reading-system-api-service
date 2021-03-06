package com.heng.reading.apiservice.comms.aop;

import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.json.JSONObject;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.HandlerMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * API 接口调用日志输出切面
 */
@Aspect
@Component
@Slf4j
public class ReqLogAspect {

    /**
     * 切面应用包配置
     */
    @Pointcut(value = "execution(* com.heng.reading.apiservice.controller.*.*(..))")
    public void exec() {}

    /**
     * 执行切面
     * @param proceedingJoinPoint 切入点
     * @return
     * @throws Throwable
     */
    @Around(value = "exec()")
    public Object execBefore(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        RequestAttributes ra = RequestContextHolder.getRequestAttributes();
        ServletRequestAttributes sra = (ServletRequestAttributes) ra;
        HttpServletRequest request = sra.getRequest();

        String reqMethod = request.getMethod();
        String reqUri = request.getRequestURI();
        String queryString = request.getQueryString();
        String params = "";

        Map<?, ?> paramsMap = (Map<?, ?>) request.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);
        params = paramsMap.toString();

        if ("POST".equals(reqMethod) || "DELETE".equals(reqMethod) || "UPDATE".equals(reqMethod)) {
            Object[] paramsArray = proceedingJoinPoint.getArgs();
            params = argsArrayToString(paramsArray);
        }

        log.info(LogPrefix.PREFIX_REQ + "{} {}", reqMethod, reqUri);
        log.info(LogPrefix.PREFIX_QUERY_PARAMS + "{}", queryString);
        log.info(LogPrefix.PREFIX_REQ_BODY + "{}", params);

        Object res = proceedingJoinPoint.proceed();
        JSONObject resJson = new JSONObject(res);
        log.info(LogPrefix.PREFIX_RES_OK + "{}", resJson.getString("msg"));

        return res;
    }

    /**
     * 请求参数转字符串
     * @param paramsArray 请求体列表
     * @return
     */
    private String argsArrayToString(Object[] paramsArray) {
        String params = "";
        if (paramsArray != null && paramsArray.length > 0) {
            for (int i = 0; i < paramsArray.length; i++) {
                Gson gson = new Gson();
                Object jsonObj = gson.toJson(paramsArray[i]);
                params += jsonObj.toString() + " ";
            }
        }
        return params.trim();
    }
}
