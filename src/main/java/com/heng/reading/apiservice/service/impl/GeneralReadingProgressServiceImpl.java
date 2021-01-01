package com.heng.reading.apiservice.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.heng.reading.apiservice.entity.GeneralReadingProgress;
import com.heng.reading.apiservice.mapper.GeneralReadingProgressMapper;
import com.heng.reading.apiservice.service.GeneralReadingProgressService;
/**
 * @author heng
 */
@Service
public class GeneralReadingProgressServiceImpl extends ServiceImpl<GeneralReadingProgressMapper, GeneralReadingProgress> implements GeneralReadingProgressService{

}
