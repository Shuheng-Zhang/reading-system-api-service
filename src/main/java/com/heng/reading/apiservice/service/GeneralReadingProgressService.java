package com.heng.reading.apiservice.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
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

    /**
     * 查询当前电子书阅读进度信息
     * @param bookId 电子书ID
     * @param page 分页控制
     * @return
     */
    IPage<GeneralReadingProgress> findReadingProgressesByBookId(String bookId, Page<GeneralReadingProgress> page);

    /**
     * 配置 电子书阅读进度
     * 配置 实例主键
     * 配置 实例创建时间
     * @param readingProgress 源阅读进度数据实例
     * @return
     */
    GeneralReadingProgress config(GeneralReadingProgress readingProgress);
}
