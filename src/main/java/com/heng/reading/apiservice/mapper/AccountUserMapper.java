package com.heng.reading.apiservice.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.heng.reading.apiservice.entity.AccountUser;

/**
 * @author heng
 */
public interface AccountUserMapper extends BaseMapper<AccountUser> {

    /**
     * 检查用户帐号是否存在
     * @param accountId 用户帐号ID
     * @return
     */
    Integer checkAccountUserExist(String accountId);

    /**
     * 检查系统根用户是否存在
     * @return
     */
    Integer checkRootAccountExisted();
}