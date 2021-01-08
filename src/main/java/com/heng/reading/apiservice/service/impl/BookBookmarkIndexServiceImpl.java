package com.heng.reading.apiservice.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.heng.reading.apiservice.comms.data.CommCodeMsg;
import com.heng.reading.apiservice.comms.exception.BusinessException;
import com.heng.reading.apiservice.comms.utils.StringUtil;
import com.heng.reading.apiservice.entity.BookBookmarkIndex;
import com.heng.reading.apiservice.mapper.BookBookmarkIndexMapper;
import com.heng.reading.apiservice.service.BookBookmarkIndexService;
import org.springframework.stereotype.Service;
/**
 * @author heng
 */
@Service
public class BookBookmarkIndexServiceImpl extends ServiceImpl<BookBookmarkIndexMapper, BookBookmarkIndex> implements BookBookmarkIndexService {

    @Override
    public void deleteByBookId(String bookId) throws BusinessException  {
        if (StringUtil.isNullOrEmpty(bookId)) {
            throw new BusinessException(CommCodeMsg.CODE_TERMINATE, CommCodeMsg.MSG_PARAMS_ERR);
        }
        this.baseMapper.deleteByBookId(bookId);
    }

    @Override
    public void deleteByBookmarkId(String bookmarkId) throws BusinessException {
        if (StringUtil.isNullOrEmpty(bookmarkId)) {
            throw new BusinessException(CommCodeMsg.CODE_TERMINATE, CommCodeMsg.MSG_PARAMS_ERR);
        }
        this.baseMapper.deleteByBookmarkId(bookmarkId);
    }
}
