package com.heng.reading.apiservice.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.heng.reading.apiservice.mapper.BookBookmarkIndexMapper;
import com.heng.reading.apiservice.entity.BookBookmarkIndex;
import com.heng.reading.apiservice.service.BookBookmarkIndexService;
/**
 * @author heng
 */
@Service
public class BookBookmarkIndexServiceImpl extends ServiceImpl<BookBookmarkIndexMapper, BookBookmarkIndex> implements BookBookmarkIndexService{

}
