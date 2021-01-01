package com.heng.reading.apiservice.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.heng.reading.apiservice.entity.GeneralReadingConfig;
import com.heng.reading.apiservice.mapper.GeneralReadingConfigMapper;
import com.heng.reading.apiservice.service.GeneralReadingConfigService;
/**
 * @author heng
 */
@Service
public class GeneralReadingConfigServiceImpl extends ServiceImpl<GeneralReadingConfigMapper, GeneralReadingConfig> implements GeneralReadingConfigService{

}
