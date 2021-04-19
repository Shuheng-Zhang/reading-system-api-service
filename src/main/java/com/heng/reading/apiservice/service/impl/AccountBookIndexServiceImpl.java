package com.heng.reading.apiservice.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.heng.reading.apiservice.comms.data.CommCodeMsg;
import com.heng.reading.apiservice.comms.exception.BusinessException;
import com.heng.reading.apiservice.comms.utils.StringUtil;
import com.heng.reading.apiservice.comms.utils.UUIDUtil;
import com.heng.reading.apiservice.entity.AccountBookIndex;
import com.heng.reading.apiservice.mapper.AccountBookIndexMapper;
import com.heng.reading.apiservice.service.AccountBookIndexService;
import org.springframework.stereotype.Service;
/**
 * @author heng
 */
@Service
public class AccountBookIndexServiceImpl extends ServiceImpl<AccountBookIndexMapper, AccountBookIndex> implements AccountBookIndexService {

    @Override
    public void deleteByBookId(String bookId) throws BusinessException {
        if (StringUtil.isNullOrEmpty(bookId)) {
            throw new BusinessException(CommCodeMsg.CODE_TERMINATE, CommCodeMsg.MSG_PARAMS_ERR);
        }
        this.baseMapper.deleteIndexByBookId(bookId);
    }

    @Override
    public AccountBookIndex config(String accountId, String bookId) {

        if (StringUtil.isNullOrEmpty(accountId) || StringUtil.isNullOrEmpty(bookId)) {
            throw new BusinessException(CommCodeMsg.CODE_TERMINATE, CommCodeMsg.MSG_PARAMS_ERR);
        }

        AccountBookIndex index = new AccountBookIndex();
        index.setId(UUIDUtil.uuid());
        index.setAccountId(accountId);
        index.setBookId(bookId);

        return index;
    }
}
