package com.heng.reading.apiservice.controller;

import com.heng.reading.apiservice.comms.data.ResultData;
import com.heng.reading.apiservice.service.AccountUserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

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
