package com.heng.reading.apiservice.service.impl;

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

}
