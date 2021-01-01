package com.heng.reading.apiservice.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.heng.reading.apiservice.entity.GeneralBook;
import com.heng.reading.apiservice.mapper.GeneralBookMapper;
import com.heng.reading.apiservice.service.GeneralBookService;
/**
 * @author heng
 */
@Service
public class GeneralBookServiceImpl extends ServiceImpl<GeneralBookMapper, GeneralBook> implements GeneralBookService{

}
