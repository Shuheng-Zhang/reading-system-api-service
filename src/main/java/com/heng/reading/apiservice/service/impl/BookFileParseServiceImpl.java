package com.heng.reading.apiservice.service.impl;

import com.heng.reading.apiservice.comms.utils.EpubParseUtils;
import com.heng.reading.apiservice.service.BookFileParseService;
import nl.siegmann.epublib.domain.Book;
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
    public Map<String, String> fetchMetadata(Book epubBook) {
        if (epubBook == null) {
            return null;
        }

        return EpubParseUtils.getMetadata(epubBook);
    }

    @Override
    public String fetchBookCover(Book epubBook, String accountId) throws IOException {

        String coverStoredPath = accountDataDirRoot + accountId + "/covers/";

        String coverFileName = EpubParseUtils.getBookCover(epubBook, coverStoredPath);

        return accountId + "/covers/" + coverFileName;
    }
}
