package com.heng.reading.apiservice.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.heng.reading.apiservice.entity.GeneralBookmark;

/**
 * @author heng
 */
public interface GeneralBookmarkMapper extends BaseMapper<GeneralBookmark> {

    /**
     * 查询关联电子书ID的书签列表
     * @param bookId 电子书ID
     * @param page 分页控制
     * @return
     */
    IPage<GeneralBookmark> queryBookmarksByBookId(String bookId, Page<GeneralBookmark> page);

    /**
     * 删除当前电子书的所有书签记录
     * @param bookId 电子书ID
     * @return
     */
    int deleteByBookId(String bookId);
}