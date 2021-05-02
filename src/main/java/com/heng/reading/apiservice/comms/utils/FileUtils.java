package com.heng.reading.apiservice.comms.utils;

import com.heng.reading.apiservice.comms.data.CommCodeMsg;
import com.heng.reading.apiservice.comms.enums.FileMimeType;
import com.heng.reading.apiservice.comms.exception.BusinessException;
import net.lingala.zip4j.ZipFile;
import net.lingala.zip4j.exception.ZipException;
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
     * 检查指定文件是否存在
     * @param filePath 文件路径
     * @return true-文件存在, false-文件不存在
     */
    public static boolean checkFileExisted(String filePath) {
        File file = new File(filePath);
        return file.isFile() && file.exists();
    }

    /**
     * 检查指定目录是否存在
     * @param dirPath 目录路径
     * @return true-目录存在, false-目录不存在
     */
    public static boolean checkDirectoryExisted(String dirPath) {
        File dir = new File(dirPath);
        return dir.isDirectory() && dir.exists();
    }

    /**
     * Zip 解压缩
     * @param src 源压缩文件
     * @param outputDestDirPath 解压缩存储目录路径
     * @throws ZipException
     */
    public static void unzip(String src, String outputDestDirPath) throws ZipException {

        // 检查并创建解压存储目录
        File dest = new File(outputDestDirPath);
        if (!dest.exists()) {
            dest.mkdirs();
        }
        new ZipFile(src).extractAll(outputDestDirPath);
    }

    /**
     * 获取目录总容量
     * @param dirPath 目标目录路径
     * @return 目录容量
     */
    public static long analysisDirectorySize(String dirPath) throws BusinessException {
        boolean isDirExisted = checkDirectoryExisted(dirPath);
        if (!isDirExisted) {
            throw new BusinessException(CommCodeMsg.CODE_TERMINATE, CommCodeMsg.MSG_OBJ_NOT_FOUND);
        }

        long totalSize = 0;
        File rootDir = new File(dirPath);
        File[] fileList = rootDir.listFiles();
        if (fileList != null) {
            for (File f : fileList) {
                if (f.isDirectory()) {
                    totalSize +=  analysisDirectorySize(f.getAbsolutePath());
                } else {
                    totalSize += f.length();
                }
            }
        }

        return totalSize;
    }

    /**
     * 创建目录
     * @param dirPath 目录路径
     */
    public static boolean createDir(String dirPath) {
        boolean res = false;
        File dir = new File(dirPath);
        if (!dir.exists()) {
            res = dir.mkdirs();
        }

        return res;
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

    /**
     * 删除指定路径文件
     * @param filePath 文件路径
     */
    public static boolean deleteFile(String filePath) {
        File file = new File(filePath);
        boolean isDeleted = false;
        if (file.exists()) {
            isDeleted = file.delete();
        }

        return isDeleted;
    }

    /**
     * 删除指定路径目录
     * @param dirPath 目录路径
     */
    public static boolean deleteDirectory(String dirPath) {
        File dir = new File(dirPath);
        if (!dir.exists()) {
            return false;
        }
        if (!dir.isDirectory()) {
            return false;
        }

        File[] subList = dir.listFiles();
        if (subList != null) {
            for (File f : subList) {
                if (f.isDirectory()) {
                    deleteDirectory(f.getAbsolutePath());
                } else {
                    f.delete();
                }
            }
        }

        dir.delete();

        return true;
    }
}
