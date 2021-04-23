package com.heng.reading.apiservice.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.heng.reading.apiservice.comms.data.CommCodeMsg;
import com.heng.reading.apiservice.comms.exception.BusinessException;
import com.heng.reading.apiservice.comms.utils.FileUtils;
import com.heng.reading.apiservice.comms.utils.StringUtil;
import com.heng.reading.apiservice.comms.utils.UUIDUtil;
import com.heng.reading.apiservice.entity.AccountUser;
import com.heng.reading.apiservice.mapper.AccountUserMapper;
import com.heng.reading.apiservice.service.AccountUserService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author heng
 */
@Service
public class AccountUserServiceImpl extends ServiceImpl<AccountUserMapper, AccountUser> implements AccountUserService {

    @Value("${extendStorage.accountDataDirRoot}")
    private String accountDataDirRoot;

    @Resource
    private AccountUserMapper accountUserMapper;

    @Override
    public boolean createRootAccount(String password) {
        AccountUser root = new AccountUser();
        root.setUserName("root");
        root.setUserType("root");
        root.setUserCertification(password);
        root.setId(UUIDUtil.uuid());

        return this.save(root);

    }

    @Override
    public AccountUser configAccountUser(AccountUser accountUser) {
        accountUser.setId(UUIDUtil.uuid());
        return accountUser;
    }

    @Override
    public void checkAccountExist(String accountId) throws BusinessException {
        Integer res = accountUserMapper.checkAccountUserExist(accountId);

        // 返回值为 0，说明帐号不存在
        if (res == 0) {
            throw new BusinessException(CommCodeMsg.CODE_TERMINATE, CommCodeMsg.MSG_OBJ_NOT_FOUND);
        }
    }

    @Override
    public void checkRootAccountExisted() {
        Integer res = accountUserMapper.checkRootAccountExisted();
        if (res == 0) {
            throw new BusinessException(CommCodeMsg.CODE_TERMINATE, CommCodeMsg.MSG_OBJ_NOT_FOUND);
        }
    }

    @Override
    public String analysisAccountStorageUsage(String accountId) {
        String targetDirPath = accountDataDirRoot + "/" + accountId;
        boolean isAccountDirExisted = FileUtils.checkDirectoryExisted(targetDirPath);
        String sizeStr = null;
        if (isAccountDirExisted) {
            long size = FileUtils.analysisDirectorySize(targetDirPath);
            sizeStr = StringUtil.storageUnitConvert(size);

        } else {
            sizeStr = "0";
        }
        return sizeStr;
    }
}
