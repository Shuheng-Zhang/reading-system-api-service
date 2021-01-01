package com.heng.reading.apiservice.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.heng.reading.apiservice.entity.BookConfigIndex;
import com.heng.reading.apiservice.mapper.BookConfigIndexMapper;
import com.heng.reading.apiservice.service.BookConfigIndexService;
/**
 * @author heng
 */
@Service
public class BookConfigIndexServiceImpl extends ServiceImpl<BookConfigIndexMapper, BookConfigIndex> implements BookConfigIndexService{

}
