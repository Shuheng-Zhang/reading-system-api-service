package com.heng.reading.apiservice.service;

import com.heng.reading.apiservice.entity.GeneralReadingProgress;
import com.baomidou.mybatisplus.extension.service.IService;
/**
 * @author heng
 */
public interface GeneralReadingProgressService extends IService<GeneralReadingProgress>{

    /**
     * 删除当前电子书所有阅读进度
     * @param bookId 电子书ID
     */
    void deleteReadingProgressesByBookId(String bookId);
}
