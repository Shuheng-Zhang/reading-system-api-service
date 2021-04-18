package com.heng.reading.apiservice.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.heng.reading.apiservice.entity.RecentReadingBookIndex;

public interface RecentReadingBookIndexMapper extends BaseMapper<RecentReadingBookIndex> {
    /**
     * 删除指定最近阅读索引
     * @param bookId 电子书ID
     * @return
     */
    int deleteByBookId(String bookId);

}
