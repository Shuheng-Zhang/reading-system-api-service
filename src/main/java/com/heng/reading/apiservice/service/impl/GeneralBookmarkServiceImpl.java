package com.heng.reading.apiservice.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.heng.reading.apiservice.comms.data.CommCodeMsg;
import com.heng.reading.apiservice.comms.exception.BusinessException;
import com.heng.reading.apiservice.comms.utils.StringUtil;
import com.heng.reading.apiservice.entity.GeneralBookmark;
import com.heng.reading.apiservice.mapper.GeneralBookmarkMapper;
import com.heng.reading.apiservice.service.GeneralBookmarkService;
import org.springframework.stereotype.Service;
/**
 * @author heng
 */
@Service
public class GeneralBookmarkServiceImpl extends ServiceImpl<GeneralBookmarkMapper, GeneralBookmark> implements GeneralBookmarkService {


    @Override
    public IPage<GeneralBookmark> findBookmarksByBookId(String bookId, Page<GeneralBookmark> page) {
        return this.baseMapper.queryBookmarksByBookId(bookId, page);
    }

    @Override
    public void deleteBookmarksByBookId(String bookId) throws BusinessException{
        if (StringUtil.isNullOrEmpty(bookId)) {
            throw new BusinessException(CommCodeMsg.CODE_TERMINATE, CommCodeMsg.MSG_PARAMS_ERR);
        }

        this.baseMapper.deleteByBookId(bookId);
    }
}
