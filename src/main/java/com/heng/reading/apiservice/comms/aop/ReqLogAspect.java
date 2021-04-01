package com.heng.reading.apiservice.comms.aop;

import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.HandlerMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Aspect
@Component
@Slf4j
public class ReqLogAspect {

    @Pointcut(value = "execution(* com.heng.reading.apiservice.controller.*.*(..))")
    public void exec() {}

    @Around(value = "exec()")
    public Object execBefore(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        RequestAttributes ra = RequestContextHolder.getRequestAttributes();
        ServletRequestAttributes sra = (ServletRequestAttributes) ra;
        HttpServletRequest request = sra.getRequest();

/*
        String reqUrl = request.getRequestURL().toString();
*/
        String reqMethod = request.getMethod();
        String reqUri = request.getRequestURI();
        String queryString = request.getQueryString();
        String params = "";

        if ("POST".equals(reqMethod)) {
            Object[] paramsArray = proceedingJoinPoint.getArgs();
            params = argsArrayToString(paramsArray);
        } else {
            Map<?, ?> paramsMap = (Map<?, ?>) request.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);
            params = paramsMap.toString();
        }

        log.info(CommPrefix.PREFIX_REQ + "{} {}", reqMethod, reqUri);
        log.info(CommPrefix.PREFIX_QUERY_PARAMS + "{}", queryString);
        log.info(CommPrefix.PREFIX_REQ_BODY + "{}", params);

        Object res = proceedingJoinPoint.proceed();
        Gson gson = new Gson();
        String ab = gson.toJson(res);
        if (ab.length() > 200){
            ab = ab.substring(0,200);
            ab += "...";
        }
        log.info(CommPrefix.PREFIX_RES + "{}", ab);

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
