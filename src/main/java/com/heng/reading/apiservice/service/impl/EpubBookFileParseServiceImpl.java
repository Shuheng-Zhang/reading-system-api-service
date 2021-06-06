package com.heng.reading.apiservice.service.impl;

import com.heng.reading.apiservice.comms.data.CommCodeMsg;
import com.heng.reading.apiservice.comms.exception.BusinessException;
import com.heng.reading.apiservice.comms.utils.EpubParseUtils;
import com.heng.reading.apiservice.comms.utils.FileUtils;
import com.heng.reading.apiservice.service.EpubBookFileParseService;
import net.lingala.zip4j.exception.ZipException;
import nl.siegmann.epublib.domain.Book;
import nl.siegmann.epublib.domain.Resource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Map;

/**
 * @author heng
 */
@Service
public class EpubBookFileParseServiceImpl implements EpubBookFileParseService {

    @Value("${extendStorage.accountDataDirRoot}")
    private String accountDataDirRoot;

    @Override
    public Book loadEpub(String bookPath) {
        Book book = null;

        try {
            book = EpubParseUtils.loadEpub(bookPath);
        } catch (IOException e) {
            throw new BusinessException(CommCodeMsg.CODE_SYS_ERR, CommCodeMsg.MSG_SYS_ERR);
        }

        return book;
    }

    @Override
    public String fetchOpfUrl(Book epubBook, String accountId, String unzipDirName) {

        if (epubBook == null) {
            return null;
        }

        Resource opfResource = epubBook.getOpfResource();
        if (opfResource == null) {
            return null;
        }

        return "/" + accountId + "/unpack/" + unzipDirName + "/" + opfResource.getHref();
    }

    @Override
    public Map<String, String> fetchMetadata(Book epubBook) {
        if (epubBook == null) {
            return null;
        }

        return EpubParseUtils.getMetadata(epubBook);
    }

    @Override
    public String fetchBookCover(Book epubBook, String accountId) {

        String coverStoredPath = accountDataDirRoot + "/" + accountId + "/covers/";

        String coverFileName = null;
        try {
            coverFileName = EpubParseUtils.getBookCover(epubBook, coverStoredPath);
        } catch (IOException e) {
            e.printStackTrace();
            throw new BusinessException(CommCodeMsg.CODE_SYS_ERR, CommCodeMsg.MSG_SYS_ERR);
        }
        if (coverFileName == null) {
            return null;
        }
        return "/" + accountId + "/covers/" + coverFileName;
    }

    @Override
    public void ePubUnzip(String epubFilePath, String destPath) throws BusinessException {
        boolean fileExisted = FileUtils.checkFileExisted(epubFilePath);
        if (!fileExisted) {
            throw new BusinessException(CommCodeMsg.CODE_TERMINATE, CommCodeMsg.MSG_OBJ_NOT_FOUND);
        }

        try {
            FileUtils.unzip(epubFilePath, destPath);
        } catch (ZipException e) {
            throw new BusinessException(CommCodeMsg.CODE_SYS_ERR, CommCodeMsg.MSG_SYS_ERR);
        }
    }
}
