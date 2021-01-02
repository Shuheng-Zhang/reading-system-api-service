package com.heng.reading.apiservice.comms.utils;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 字符串工具类
 * @author heng
 */
public class StringUtil {

    final private static long BYTE = 1024;
    final private static long KB = 1048576;
    final private static long MB = 1073741824;

    final private static DateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    /**
     * 检查字符串是否为空
     * @param str 字符串
     * @return true - 空，false - 不为空
     */
    public static boolean isNullOrEmpty(String str) {
        return str == null || "".equals(str);
    }

    /**
     * 检查字符串数组是否为空
     * @param strList 字符串数组
     * @return true-字符串数组为空, false-不为空
     */
    public static boolean isStringsBlank(String[] strList) {
        return strList == null || strList.length == 0;
    }

    /**
     * 转换文件容量数值使其易于阅读
     * @param value 文件容量（Byte）
     * @return Byte/kB/MB/GB
     */
    public static String storageUnitConvert(long value) {
        DecimalFormat df = new DecimalFormat("#.00");
        String fileSizeString = "";
        if (value < BYTE) {
            fileSizeString = df.format((double) value) + "B";
        } else if (value < KB) {
            fileSizeString = df.format((double) value / BYTE) + "K";
        } else if (value < MB) {
            fileSizeString = df.format((double) value / KB) + "M";
        } else {
            fileSizeString = df.format((double) value / MB) + "G";
        }
        return fileSizeString;
    }

    /**
     * 获取当前时间
     * @return 返回当前时间（yyyy-MM-dd HH:mm:ss）
     */
    public static String getCurrentTime() {
        return DATE_FORMAT.format(new Date());
    }
}
