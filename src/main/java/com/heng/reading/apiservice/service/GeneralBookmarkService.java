package com.heng.reading.apiservice.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.heng.reading.apiservice.entity.GeneralBookmark;
import com.baomidou.mybatisplus.extension.service.IService;
/**
 * @author heng
 */
public interface GeneralBookmarkService extends IService<GeneralBookmark> {

    /**
     * 查找关联电子书ID的书签列表
     * @param bookId 电子书ID
     * @param page 分页控制
     * @return
     */
    IPage<GeneralBookmark> findBookmarksByBookId(String bookId, Page<GeneralBookmark> page);

    /**
     * 删除当前电子书所有书签
     * @param bookId 电子书ID
     */
    void deleteBookmarksByBookId(String bookId);
}
