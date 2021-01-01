package com.heng.reading.apiservice.comms.utils;

import java.util.UUID;

/**
 * UUID 工具类
 * @author heng
 */
public class UUIDUtil {

    /**
     * 生成无短划线 UUID
     * @return UUID 字符串
     */
    public static String uuid() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }
}
