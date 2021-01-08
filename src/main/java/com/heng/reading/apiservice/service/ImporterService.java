package com.heng.reading.apiservice.service;

import com.heng.reading.apiservice.comms.enums.FileMimeType;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @author heng
 */
public interface ImporterService {

    /**
     * 检查文件类型
     * @param mimeType 文件类型
     * @param files 待检查文件列表
     * @exception com.heng.reading.apiservice.comms.exception.BusinessException
     */
    void checkFilesContentType(FileMimeType mimeType, MultipartFile[] files);

    /**
     * 检查用户数据目录
     * 若用户数据目录未建立则创建该目录
     * @param accountId 用户帐号ID
     */
    void checkUserDir(String accountId);

    /**
     * 将文件转存至用户数据目录
     * @param file 源文件
     * @param mimeType 文件类型
     * @param accountId 用户帐号ID
     * @return 文件存储相对路径
     * @exception IOException
     */
    String transFile2Dest(MultipartFile file, FileMimeType mimeType, String accountId) throws IOException;

}
