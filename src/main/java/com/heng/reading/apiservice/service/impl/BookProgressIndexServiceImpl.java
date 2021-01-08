package com.heng.reading.apiservice.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.heng.reading.apiservice.comms.data.CommCodeMsg;
import com.heng.reading.apiservice.comms.exception.BusinessException;
import com.heng.reading.apiservice.comms.utils.StringUtil;
import com.heng.reading.apiservice.entity.BookProgressIndex;
import com.heng.reading.apiservice.mapper.BookProgressIndexMapper;
import com.heng.reading.apiservice.service.BookProgressIndexService;
import org.springframework.stereotype.Service;
/**
 * @author heng
 */
@Service
public class BookProgressIndexServiceImpl extends ServiceImpl<BookProgressIndexMapper, BookProgressIndex> implements BookProgressIndexService {

    @Override
    public void deleteByBookId(String bookId) throws BusinessException {
        if (StringUtil.isNullOrEmpty(bookId)) {
            throw new BusinessException(CommCodeMsg.CODE_TERMINATE, CommCodeMsg.MSG_PARAMS_ERR);
        }
        this.baseMapper.deleteByBookId(bookId);
    }

    @Override
    public void deleteByProgressId(String progressId) throws BusinessException {
        if (StringUtil.isNullOrEmpty(progressId)) {
            throw new BusinessException(CommCodeMsg.CODE_TERMINATE, CommCodeMsg.MSG_PARAMS_ERR);
        }

        this.baseMapper.deleteByProgressId(progressId);
    }
}
