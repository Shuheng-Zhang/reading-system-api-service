package com.heng.reading.apiservice.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.heng.reading.apiservice.mapper.BookProgressIndexMapper;
import com.heng.reading.apiservice.entity.BookProgressIndex;
import com.heng.reading.apiservice.service.BookProgressIndexService;
/**
 * @author heng
 */
@Service
public class BookProgressIndexServiceImpl extends ServiceImpl<BookProgressIndexMapper, BookProgressIndex> implements BookProgressIndexService{

}
