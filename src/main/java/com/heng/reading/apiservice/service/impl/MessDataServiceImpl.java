package com.heng.reading.apiservice.service.impl;

import com.heng.reading.apiservice.comms.data.CommCodeMsg;
import com.heng.reading.apiservice.comms.exception.BusinessException;
import com.heng.reading.apiservice.comms.utils.StringUtil;
import com.heng.reading.apiservice.mapper.MessDataMapper;
import com.heng.reading.apiservice.service.MessDataService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class MessDataServiceImpl implements MessDataService {

    @Resource
    private MessDataMapper messDataMapper;

    @Override
    public List<Map<String, String>> findBookAndReadingProgressRelatedIndexesByAccountId(String accountId) {

        if (StringUtil.isNullOrEmpty(accountId)) {
            throw new BusinessException(CommCodeMsg.CODE_TERMINATE, CommCodeMsg.MSG_PARAMS_ERR);
        }

        return messDataMapper.queryBookAndReadingProgressRelatedIndexesByAccountId(accountId);
    }
}
