package com.heng.reading.apiservice.service;

import com.heng.reading.apiservice.entity.AccountUser;
import com.baomidou.mybatisplus.extension.service.IService;
/**
 * @author heng
 */
public interface AccountUserService extends IService<AccountUser> {


    /**
     * 检查用户帐号是否存在
     * @param accountId 用户帐号ID
     * @exception com.heng.reading.apiservice.comms.exception.BusinessException 用户帐号不存在
     */
    void checkAccountExist(String accountId);
}
