package com.heng.reading.apiservice.service.impl;

import com.heng.reading.apiservice.comms.data.CommCodeMsg;
import com.heng.reading.apiservice.comms.exception.BusinessException;
import com.heng.reading.apiservice.comms.utils.EpubParseUtils;
import com.heng.reading.apiservice.comms.utils.FileUtils;
import com.heng.reading.apiservice.service.BookFileParseService;
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
public class BookFileParseServiceImpl implements BookFileParseService {

    @Value("${extendStorage.accountDataDirRoot}")
    private String accountDataDirRoot;

    @Override
    public Book loadEpub(String bookPath) throws IOException {
        return EpubParseUtils.loadEpub(bookPath);
    }

    @Override
    public String fetchOpfHref(Book epubBook, String accountId, String unzipDirName) {

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
    public String fetchBookCover(Book epubBook, String accountId) throws IOException {

        String coverStoredPath = accountDataDirRoot + "/" + accountId + "/covers/";

        String coverFileName = EpubParseUtils.getBookCover(epubBook, coverStoredPath);
        if (coverFileName == null) {
            return null;
        }
        return "/" + accountId + "/covers/" + coverFileName;
    }

    @Override
    public void ePubUnzip(String epubFilePath, String destPath) throws ZipException, BusinessException {
        boolean fileExisted = FileUtils.checkFileExisted(epubFilePath);
        if (!fileExisted) {
            throw new BusinessException(CommCodeMsg.CODE_TERMINATE, CommCodeMsg.MSG_OBJ_NOT_FOUND);
        }
        FileUtils.unzip(epubFilePath, destPath);
    }
}
