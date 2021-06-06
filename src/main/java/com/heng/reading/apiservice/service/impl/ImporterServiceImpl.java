package com.heng.reading.apiservice.service.impl;

import com.heng.reading.apiservice.comms.data.CommCodeMsg;
import com.heng.reading.apiservice.comms.enums.FileMimeType;
import com.heng.reading.apiservice.comms.exception.BusinessException;
import com.heng.reading.apiservice.comms.utils.FileUtils;
import com.heng.reading.apiservice.comms.utils.UUIDUtil;
import com.heng.reading.apiservice.service.ImporterService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * @author heng
 */
@Slf4j
@Service
public class ImporterServiceImpl implements ImporterService {

    @Value("${extendStorage.accountDataDirRoot}")
    private String accountDataDirRoot;

    @Override
    public void checkFilesContentType(FileMimeType mimeType, MultipartFile[] files) throws BusinessException {

        if (files == null || files.length == 0) {
            throw new BusinessException(CommCodeMsg.CODE_TERMINATE, CommCodeMsg.MSG_PARAMS_ERR);
        }

        for (MultipartFile file : files) {
            if (file.isEmpty()) {
                throw new BusinessException(CommCodeMsg.CODE_TERMINATE, CommCodeMsg.MSG_PARAMS_ERR);
            }

            boolean res = FileUtils.checkContentType(mimeType, file);
            if (!res) {
                throw new BusinessException(CommCodeMsg.CODE_TERMINATE, CommCodeMsg.MSG_FILE_NOT_SUPPORT);
            }
        }
    }

    @Override
    public void checkUserDir(String accountId) {
        boolean resAccountRootDir = FileUtils.createDir(accountDataDirRoot + "/" + accountId);
        boolean resAccountEpubDir = FileUtils.createDir(accountDataDirRoot + "/" + accountId + "/epub");
        boolean resAccountCoverDir = FileUtils.createDir(accountDataDirRoot + "/" + accountId + "/covers");
        boolean resAccountUnpackedDir = FileUtils.createDir(accountDataDirRoot + "/" + accountId + "/unpack");
        if (resAccountRootDir) {
            log.warn("Created User Directory: {}", accountId);
        }
        if (resAccountEpubDir) {
            log.warn("Created User Directory: {}", accountId + "/epub");
        }
        if (resAccountCoverDir) {
            log.warn("Created User Directory: {}", accountId + "/covers");
        }
        if (resAccountUnpackedDir) {
            log.warn("Created User Directory: {}", accountId + "/unpack");
        }
    }

    @Override
    public String[] transFile2Dest(MultipartFile file, FileMimeType mimeType, String accountId) {

        if (file == null || file.isEmpty()) {
            return null;
        }

        String extName = null;
        switch (mimeType) {
            case JPG:
                extName = ".jpg";
                break;
            case PNG:
                extName = ".png";
                break;
            case PDF:
                extName = ".pdf";
                break;
            case TXT:
                extName = ".txt";
                break;
            case EPUB:
                extName = ".epub";
                break;
            default:
        }

        if (extName == null) {
            return null;
        }

        String originName = file.getOriginalFilename();
        String path = "/" + accountId + "/epub/"  + UUIDUtil.uuid() + extName;
        String destFilePath = accountDataDirRoot + path;;
        File dest = new File(destFilePath);
        try {
            FileUtils.transFile2Dest(file, dest);
        } catch (IOException e) {
            throw new BusinessException(CommCodeMsg.CODE_SYS_ERR, CommCodeMsg.MSG_SYS_ERR);
        }

        return new String[] {originName, path};
    }
}
