package com.heng.reading.apiservice.service.impl;

import com.heng.reading.apiservice.comms.data.CommCodeMsg;
import com.heng.reading.apiservice.comms.exception.BusinessException;
import com.heng.reading.apiservice.comms.utils.StringUtil;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.heng.reading.apiservice.entity.GeneralReadingConfig;
import com.heng.reading.apiservice.mapper.GeneralReadingConfigMapper;
import com.heng.reading.apiservice.service.GeneralReadingConfigService;
/**
 * @author heng
 */
@Service
public class GeneralReadingConfigServiceImpl extends ServiceImpl<GeneralReadingConfigMapper, GeneralReadingConfig> implements GeneralReadingConfigService {

    @Override
    public void deleteReadingConfigsByBookId(String bookId) throws BusinessException {
        if (StringUtil.isNullOrEmpty(bookId)) {
            throw new BusinessException(CommCodeMsg.CODE_TERMINATE, CommCodeMsg.MSG_PARAMS_ERR);
        }

        this.baseMapper.deleteByBookId(bookId);
    }
}