package com.heng.reading.apiservice.service;

import com.heng.reading.apiservice.entity.AccountUser;
import com.baomidou.mybatisplus.extension.service.IService;
/**
 * @author heng
 */
public interface AccountUserService extends IService<AccountUser> {


    /**
     * 检查用户帐号是否存在
     * @param username 用户名
     */
    void checkAccountExist(String username);
}
