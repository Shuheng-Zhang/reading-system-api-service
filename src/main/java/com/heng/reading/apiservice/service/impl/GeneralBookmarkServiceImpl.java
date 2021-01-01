package com.heng.reading.apiservice.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.heng.reading.apiservice.mapper.GeneralBookmarkMapper;
import com.heng.reading.apiservice.entity.GeneralBookmark;
import com.heng.reading.apiservice.service.GeneralBookmarkService;
/**
 * @author heng
 */
@Service
public class GeneralBookmarkServiceImpl extends ServiceImpl<GeneralBookmarkMapper, GeneralBookmark> implements GeneralBookmarkService{

}
