package com.heng.reading.apiservice.service.impl;

import com.heng.reading.apiservice.comms.data.CommCodeMsg;
import com.heng.reading.apiservice.comms.exception.BusinessException;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.heng.reading.apiservice.mapper.AccountUserMapper;
import com.heng.reading.apiservice.entity.AccountUser;
import com.heng.reading.apiservice.service.AccountUserService;
/**
 * @author heng
 */
@Service
public class AccountUserServiceImpl extends ServiceImpl<AccountUserMapper, AccountUser> implements AccountUserService{

    @Resource
    private AccountUserMapper accountUserMapper;

    @Override
    public void checkAccountExist(String username) {
        Integer res = accountUserMapper.checkAccountUserExist(username);
        if (res == null) {
            throw new BusinessException(CommCodeMsg.CODE_TERMINATE, CommCodeMsg.MSG_OBJ_NOT_FOUND);
        }
    }
}
