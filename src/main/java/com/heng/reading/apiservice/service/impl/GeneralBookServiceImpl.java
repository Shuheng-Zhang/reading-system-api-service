package com.heng.reading.apiservice.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.heng.reading.apiservice.comms.data.CommCodeMsg;
import com.heng.reading.apiservice.comms.exception.BusinessException;
import com.heng.reading.apiservice.comms.utils.FileUtils;
import com.heng.reading.apiservice.comms.utils.StringUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.heng.reading.apiservice.entity.GeneralBook;
import com.heng.reading.apiservice.mapper.GeneralBookMapper;
import com.heng.reading.apiservice.service.GeneralBookService;

import java.io.File;

/**
 * @author heng
 */
@Service
public class GeneralBookServiceImpl extends ServiceImpl<GeneralBookMapper, GeneralBook> implements GeneralBookService{

    @Value("${extendStorage.accountDataDirRoot}")
    private String accountDataDirRoot;

    @Override
    public IPage<GeneralBook> findBooksByAccountId(String accountId, Page<GeneralBook> page) {
        return this.baseMapper.queryBooksByAccountId(accountId, page);
    }

    @Override
    public void removeBookByBookId(String bookId) throws BusinessException {

        // 查询电子书信息对象
        // 获取电子书文件URL
        // 获取电子书封面URL
        GeneralBook book = this.baseMapper.selectById(bookId);
        if (book != null) {
            String bookPath = bookResourcePath(book.getBookFileUrl());
            String coverPath = bookResourcePath(book.getBookCoverUrl());

            // 删除电子书文件
            if (bookPath != null) {
                FileUtils.deleteFile(bookPath);
            }
            // 删除电子书封面文件
            if (coverPath != null) {
                FileUtils.deleteFile(coverPath);
            }

            // 删除电子书数据库记录
            this.baseMapper.deleteById(bookId);
        } else {
            throw new BusinessException(CommCodeMsg.CODE_TERMINATE, CommCodeMsg.MSG_OBJ_NOT_FOUND);
        }
    }

    private String bookResourcePath(String path) {
        if (StringUtil.isNullOrEmpty(path)) {
            return null;
        }

        return accountDataDirRoot + path;
    }
}
