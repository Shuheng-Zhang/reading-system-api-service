package com.heng.reading.apiservice.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.heng.reading.apiservice.comms.data.CommCodeMsg;
import com.heng.reading.apiservice.comms.exception.BusinessException;
import com.heng.reading.apiservice.comms.utils.FileUtils;
import com.heng.reading.apiservice.comms.utils.StringUtil;
import com.heng.reading.apiservice.comms.utils.UUIDUtil;
import com.heng.reading.apiservice.dto.book.GeneralBookDto;
import com.heng.reading.apiservice.dto.book.GeneralBookRecentReadingDto;
import com.heng.reading.apiservice.dto.book.GeneralBookSimpleDto;
import com.heng.reading.apiservice.dto.progress.BookProgressIndexDto;
import com.heng.reading.apiservice.dto.progress.GeneralReadingProgressSimpleDto;
import com.heng.reading.apiservice.entity.GeneralBook;
import com.heng.reading.apiservice.mapper.GeneralBookMapper;
import com.heng.reading.apiservice.mapper.GeneralReadingProgressMapper;
import com.heng.reading.apiservice.service.GeneralBookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author heng
 */
@Slf4j
@Service
public class GeneralBookServiceImpl extends ServiceImpl<GeneralBookMapper, GeneralBook> implements GeneralBookService {

    @Value("${extendStorage.accountDataDirRoot}")
    private String accountDataDirRoot;

    @Resource
    private GeneralReadingProgressMapper generalReadingProgressMapper;

    @Override
    public IPage<GeneralBookDto> findBooksByAccountId(String accountId, Page<GeneralBookDto> page) {
        return this.baseMapper.queryBooksByAccountId(accountId, page);
    }

    @Override
    public IPage<GeneralBookSimpleDto> findBooksSimpleByAccountId(String accountId, Page<GeneralBookSimpleDto> page) {
        return this.baseMapper.queryBooksSimpleByAccountId(accountId, page);
    }

    @Override
    public IPage<GeneralBookDto> findBooksByAccountId(String accountId, String bookTitleLike, String bookAuthorsLike, Page<GeneralBookDto> page) {
        return this.baseMapper.queryBookByAccountIdWithTitleLikeOrAuthorsLike(accountId, bookTitleLike, bookAuthorsLike, page);
    }

    @Override
    public IPage<GeneralBookSimpleDto> findBookSimpleByAccountId(String accountId, String bookTitleLike, String bookAuthorsLike, Page<GeneralBookSimpleDto> page) {
        return this.baseMapper.queryBooksSimpleByAccountIdWithTitleLikeOrAuthorsLike(accountId, bookTitleLike, bookAuthorsLike, page);
    }

    @Override
    public List<GeneralBookRecentReadingDto> findRecentReadingBooks(List<BookProgressIndexDto> indexDtoList) {

        if (indexDtoList == null || indexDtoList.isEmpty()) {
            throw new BusinessException(CommCodeMsg.CODE_TERMINATE, CommCodeMsg.MSG_PARAMS_ERR);
        }

        List<GeneralBookRecentReadingDto> recentReadingDtoList = new ArrayList<>();
        for (BookProgressIndexDto dto : indexDtoList) {
            GeneralBookSimpleDto generalBookSimpleDto = this.baseMapper.queryBookSimpleById(dto.getBookId());
            GeneralReadingProgressSimpleDto generalReadingProgressSimpleDto = generalReadingProgressMapper.queryReadingProgressById(dto.getProgressId());
            GeneralBookRecentReadingDto recentReadingDto = GeneralBookRecentReadingDto.getInstance(generalBookSimpleDto, generalReadingProgressSimpleDto);

            recentReadingDtoList.add(recentReadingDto);
        }

        return recentReadingDtoList;
    }

    @Override
    public void deleteBookByBookId(String bookId) throws BusinessException {

        // 查询电子书信息对象
        // 获取电子书文件URL
        // 获取电子书封面URL
        GeneralBook book = this.baseMapper.selectById(bookId);
        if (book != null) {
            String bookPath = bookResourcePath(book.getBookFileUrl());
            String coverPath = bookResourcePath(book.getBookCoverUrl());
            String unpackDirPath = bookResourcePath(book.getBookUnpackedDirUrl());

            // 删除电子书文件
            if (bookPath != null) {
                boolean res = FileUtils.deleteFile(bookPath);
                if (res) {
                    log.warn("Deleted eBook File: {}", bookPath);
                }
            }
            // 删除电子书封面文件
            if (coverPath != null) {
                boolean res = FileUtils.deleteFile(coverPath);
                if (res) {
                    log.warn("Deleted eBook Cover: {}", coverPath);
                }
            }
            // 删除解压缩目录
            if (unpackDirPath != null) {
                boolean res = FileUtils.deleteDirectory(unpackDirPath);
                if (res) {
                    log.warn("Deleted eBook Unpacked: {}", unpackDirPath);
                }
            }

            // 删除电子书数据库记录
            this.baseMapper.deleteById(bookId);
        } else {
            throw new BusinessException(CommCodeMsg.CODE_TERMINATE, CommCodeMsg.MSG_OBJ_NOT_FOUND);
        }
    }

    @Override
    public void checkBookExisted(String bookId) throws BusinessException {
        Integer res = this.baseMapper.checkBookExistedById(bookId);
        if (res == 0) {
            throw new BusinessException(CommCodeMsg.CODE_TERMINATE, CommCodeMsg.MSG_OBJ_NOT_FOUND);
        }
    }

    @Override
    public GeneralBook config(String bookTitle, String bookAuthors, String bookDescription,
                              String bookCoverUrl, String bookFileUrl, String bookOpfUrl, String unpackedDirPath,
                              String bookSize, String bookPushedTime) {

        GeneralBook book = new GeneralBook();
        book.setId(UUIDUtil.uuid());
        book.setBookTitle(bookTitle);
        book.setBookAuthors(bookAuthors);
        book.setBookDescription(bookDescription);
        book.setBookSize(bookSize);
        book.setBookCoverUrl(bookCoverUrl);
        book.setBookFileUrl(bookFileUrl);
        book.setBookOpfUrl(bookOpfUrl);
        book.setBookUnpackedDirUrl(unpackedDirPath);
        book.setBookPushedTime(bookPushedTime);

        return book;
    }

    @Override
    public GeneralBook config(Map<String, String> metadata, String bookCoverUrl, String bookFileUrl, String bookOpfUrl, String unpackedDirPath, String bookSize, String bookPushedTime) {

        GeneralBook book = new GeneralBook();
        book.setId(UUIDUtil.uuid());

        if (metadata != null) {
            book.setBookTitle(metadata.get("title"));
            book.setBookAuthors(metadata.get("authors"));
            book.setBookDescription(metadata.get("description"));
        }
        book.setBookSize(bookSize);
        book.setBookCoverUrl(bookCoverUrl);
        book.setBookFileUrl(bookFileUrl);
        book.setBookOpfUrl(bookOpfUrl);
        book.setBookUnpackedDirUrl(unpackedDirPath);
        book.setBookPushedTime(bookPushedTime);
        return book;
    }

    /**
     * 构建完整的电子书文件地址
     * @param path 电子书相对地址
     * @return 电子书完整文件路径
     */
    private String bookResourcePath(String path) {
        if (StringUtil.isNullOrEmpty(path)) {
            return null;
        }

        return accountDataDirRoot + path;
    }
}
