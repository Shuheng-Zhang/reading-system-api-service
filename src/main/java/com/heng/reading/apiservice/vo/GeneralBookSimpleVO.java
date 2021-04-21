package com.heng.reading.apiservice.vo;

import com.heng.reading.apiservice.comms.data.CommCodeMsg;
import com.heng.reading.apiservice.comms.exception.BusinessException;
import com.heng.reading.apiservice.entity.GeneralBook;
import lombok.Data;

@Data
public class GeneralBookSimpleVO {

    private String bookId;
    private String bookTitle;
    private String bookAuthors;
    private String bookCoverUrl;
    private String bookFileUrl;

    private GeneralBookSimpleVO() {}

    public static GeneralBookSimpleVO getInstance(GeneralBook book) {

        if (book == null) {
            throw new BusinessException(CommCodeMsg.CODE_TERMINATE, CommCodeMsg.MSG_PARAMS_ERR);
        }

        GeneralBookSimpleVO generalBookSimpleVO = new GeneralBookSimpleVO();
        generalBookSimpleVO.setBookId(book.getId());
        generalBookSimpleVO.setBookAuthors(book.getBookAuthors());
        generalBookSimpleVO.setBookTitle(book.getBookTitle());
        generalBookSimpleVO.setBookCoverUrl(book.getBookCoverUrl());
        generalBookSimpleVO.setBookFileUrl(book.getBookFileUrl());

        return generalBookSimpleVO;
    }
}
