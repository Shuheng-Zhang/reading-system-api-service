package com.heng.reading.apiservice.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.heng.reading.apiservice.comms.data.CommCodeMsg;
import com.heng.reading.apiservice.comms.exception.BusinessException;
import com.heng.reading.apiservice.entity.AccountUser;
import com.heng.reading.apiservice.mapper.AccountUserMapper;
import com.heng.reading.apiservice.service.AccountUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author heng
 */
@Service
public class AccountUserServiceImpl extends ServiceImpl<AccountUserMapper, AccountUser> implements AccountUserService {

    @Resource
    private AccountUserMapper accountUserMapper;

    @Override
    public void checkAccountExist(String accountId) throws BusinessException {
        Integer res = accountUserMapper.checkAccountUserExist(accountId);

        // 返回值为 0，说明帐号不存在
        if (res == 0) {
            throw new BusinessException(CommCodeMsg.CODE_TERMINATE, CommCodeMsg.MSG_OBJ_NOT_FOUND);
        }
    }
}
