package com.heng.reading.apiservice.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.heng.reading.apiservice.comms.data.CommCodeMsg;
import com.heng.reading.apiservice.comms.exception.BusinessException;
import com.heng.reading.apiservice.comms.utils.StringUtil;
import com.heng.reading.apiservice.entity.BookConfigIndex;
import com.heng.reading.apiservice.mapper.BookConfigIndexMapper;
import com.heng.reading.apiservice.service.BookConfigIndexService;
import org.springframework.stereotype.Service;
/**
 * @author heng
 */
@Service
public class BookConfigIndexServiceImpl extends ServiceImpl<BookConfigIndexMapper, BookConfigIndex> implements BookConfigIndexService {

    @Override
    public void deleteByBookId(String bookId) {
        if (StringUtil.isNullOrEmpty(bookId)) {
            throw new BusinessException(CommCodeMsg.CODE_TERMINATE, CommCodeMsg.MSG_PARAMS_ERR);
        }

        this.baseMapper.deleteByBookId(bookId);
    }

    @Override
    public void checkReadingConfigExisted(String bookId) {
        Integer res = this.baseMapper.checkConfigExisted(bookId);

        if (res == 1) {
            throw new BusinessException(CommCodeMsg.CODE_TERMINATE, CommCodeMsg.MSG_DUPLICATED_REQUEST_ERR);
        }
    }
}
