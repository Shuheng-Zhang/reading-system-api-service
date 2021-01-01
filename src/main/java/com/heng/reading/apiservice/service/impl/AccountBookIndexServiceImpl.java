package com.heng.reading.apiservice.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.heng.reading.apiservice.entity.AccountBookIndex;
import com.heng.reading.apiservice.mapper.AccountBookIndexMapper;
import com.heng.reading.apiservice.service.AccountBookIndexService;
/**
 * @author heng
 */
@Service
public class AccountBookIndexServiceImpl extends ServiceImpl<AccountBookIndexMapper, AccountBookIndex> implements AccountBookIndexService{

}
