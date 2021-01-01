package com.heng.reading.apiservice.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.heng.reading.apiservice.entity.AccountUser;

/**
 * @author heng
 */
public interface AccountUserMapper extends BaseMapper<AccountUser> {

    /**
     * 检查用户帐号是否存在
     * @param username 用户名
     * @return
     */
    Integer checkAccountUserExist(String username);
}