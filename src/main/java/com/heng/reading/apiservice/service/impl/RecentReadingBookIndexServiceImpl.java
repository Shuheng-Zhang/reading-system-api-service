package com.heng.reading.apiservice.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.heng.reading.apiservice.comms.data.CommCodeMsg;
import com.heng.reading.apiservice.comms.exception.BusinessException;
import com.heng.reading.apiservice.comms.utils.StringUtil;
import com.heng.reading.apiservice.entity.RecentReadingBookIndex;
import com.heng.reading.apiservice.mapper.RecentReadingBookIndexMapper;
import com.heng.reading.apiservice.service.RecentReadingBookIndexService;
import org.springframework.stereotype.Service;

@Service
public class RecentReadingBookIndexServiceImpl extends ServiceImpl<RecentReadingBookIndexMapper, RecentReadingBookIndex> implements RecentReadingBookIndexService {

    @Override
    public void deleteByBookId(String bookId) {
        if (StringUtil.isNullOrEmpty(bookId)) {
            throw new BusinessException(CommCodeMsg.CODE_TERMINATE, CommCodeMsg.MSG_PARAMS_ERR);
        }
        this.baseMapper.deleteByBookId(bookId);
    }
}
