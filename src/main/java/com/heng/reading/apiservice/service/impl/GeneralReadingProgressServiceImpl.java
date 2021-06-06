package com.heng.reading.apiservice.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.heng.reading.apiservice.comms.data.CommCodeMsg;
import com.heng.reading.apiservice.comms.exception.BusinessException;
import com.heng.reading.apiservice.comms.utils.StringUtil;
import com.heng.reading.apiservice.comms.utils.UUIDUtil;
import com.heng.reading.apiservice.entity.GeneralReadingProgress;
import com.heng.reading.apiservice.mapper.GeneralReadingProgressMapper;
import com.heng.reading.apiservice.service.GeneralReadingProgressService;
import org.springframework.stereotype.Service;
/**
 * @author heng
 */
@Service
public class GeneralReadingProgressServiceImpl extends ServiceImpl<GeneralReadingProgressMapper, GeneralReadingProgress> implements GeneralReadingProgressService {

    @Override
    public void deleteReadingProgressesByBookId(String bookId) throws BusinessException{
        if (StringUtil.isNullOrEmpty(bookId)) {
            throw new BusinessException(CommCodeMsg.CODE_TERMINATE, CommCodeMsg.MSG_PARAMS_ERR);
        }

        this.baseMapper.deleteByBookId(bookId);
    }

    @Override
    public IPage<GeneralReadingProgress> findReadingProgressesByBookId(String bookId, Page<GeneralReadingProgress> page) {
        return this.baseMapper.queryReadingProgressesByBookId(bookId, page);
    }

    @Override
    public GeneralReadingProgress config(GeneralReadingProgress readingProgress) {

        readingProgress.setId(UUIDUtil.uuid());
        readingProgress.setProgressUpdatedTime(StringUtil.getCurrentTime());

        return readingProgress;
    }
}
