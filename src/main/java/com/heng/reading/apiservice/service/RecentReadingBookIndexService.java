package com.heng.reading.apiservice.service;

import com.baomidou.mybatisplus.extension.service.IService;

public interface RecentReadingBookIndexService extends IService<com.heng.reading.apiservice.entity.RecentReadingBookIndex> {

    void deleteByBookId(String bookId);
}
