package com.heng.reading.apiservice.controller;

import com.heng.reading.apiservice.comms.data.CommCodeMsg;
import com.heng.reading.apiservice.comms.data.ResultData;
import com.heng.reading.apiservice.comms.exception.BusinessException;
import com.heng.reading.apiservice.comms.utils.StringUtil;
import com.heng.reading.apiservice.comms.utils.UUIDUtil;
import com.heng.reading.apiservice.entity.AccountUser;
import com.heng.reading.apiservice.service.AccountUserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;

/**
 * 用户账号控制器
 * @author heng
 */
@RestController
@RequestMapping(value = "/account")
public class AccountUserController {

    @Resource
    private AccountUserService accountUserService;

    /**
     * 检查系统根用户是否存在
     * @return
     */
    @ApiOperation("检查系统根用户是否存在")
    @GetMapping("root/check")
    public ResultData<Object> checkRootAccount() {
        accountUserService.checkRootAccountExisted();
        return ResultData.success();
    }

    /**
     * 创建系统根账号
     * @param req req.password(必要) - 根账号口令
     * @return
     */
    @ApiOperation("创建根账号")
    @PostMapping("root/create")
    public ResultData<Object> createRootConfig(@RequestBody Map<String, String> req) {

        try {
            accountUserService.checkRootAccountExisted();
        } catch (BusinessException e) {
            String password = req.get("password");
            if (StringUtil.isNullOrEmpty(password)) {
                throw new BusinessException(CommCodeMsg.CODE_TERMINATE, CommCodeMsg.MSG_PARAMS_ERR);
            }

            AccountUser root = new AccountUser();
            root.setUserName("root");
            root.setUserType("root");
            root.setUserCertification(password);
            root.setId(UUIDUtil.uuid());

            accountUserService.save(root);

            return ResultData.success();
        }

        return ResultData.terminatedFail("Root Account Already Done");

    }

    /**
     * 分析用户数据目录容量
     * @param accountId 用户账号ID
     * @return
     */
    @GetMapping("analysis/usage/{accountId}")
    public ResultData<String> analysisAccountStorageUsage(@PathVariable("accountId") String accountId) {

        accountUserService.checkAccountExist(accountId);

        String totalSize = accountUserService.analysisAccountStorageUsage(accountId);

        return ResultData.success(totalSize);
    }

}
