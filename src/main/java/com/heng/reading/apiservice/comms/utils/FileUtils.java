package com.heng.reading.apiservice.comms.utils;

import com.heng.reading.apiservice.comms.enums.FileMimeType;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * 文件操作工具类
 * @author heng
 */
public class FileUtils {

    /**
     * 检查 Multipart 文件类型
     * @param mimeType 文件类型
     * @param file 待检查文件
     * @return true-类型匹配；false-类型不匹配
     */
    public static boolean checkContentType(FileMimeType mimeType, MultipartFile file) {
        if (file == null || file.isEmpty()) {
            return false;
        }

        return mimeType.getContentType().equals(file.getContentType());
    }

    /**
     * 创建目录
     * @param dirPath 目录路径
     */
    public static void createDir(String dirPath) {
        File dir = new File(dirPath);
        if (!dir.exists()) {
            dir.mkdirs();
        }
    }

    /**
     * 将 Multipart 文件移动到目标文件
     * @param file 源文件
     * @param dest 目标文件
     * @throws IOException
     */
    public static void transFile2Dest(MultipartFile file, File dest) throws IOException {
        if (file == null || file.isEmpty()) {
            return;
        }

        file.transferTo(dest);

    }
}
