package com.heng.reading.apiservice.service;

import com.heng.reading.apiservice.entity.AccountUser;
import com.baomidou.mybatisplus.extension.service.IService;
/**
 * @author heng
 */
public interface AccountUserService extends IService<AccountUser> {


    /**
     * 配置 用户账号
     * @param accountUser 用户账号对象
     * @return
     */
    AccountUser configAccountUser(AccountUser accountUser);

    /**
     * 检查用户帐号是否存在
     * @param accountId 用户帐号ID
     * @exception com.heng.reading.apiservice.comms.exception.BusinessException 用户帐号不存在
     */
    void checkAccountExist(String accountId);

    /**
     * 分析用户账号存储空间使用情况
     * @param accountId 用户账号ID
     * @return 用户目录占用空间容量
     */
    String analysisAccountStorageUsage(String accountId);

    /**
     * 检查系统根用户是否存在
     */
    void checkRootAccountExisted();
}
