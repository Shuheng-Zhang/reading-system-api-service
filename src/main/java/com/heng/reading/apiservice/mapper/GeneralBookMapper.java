package com.heng.reading.apiservice.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.heng.reading.apiservice.entity.GeneralBook;


/**
 * @author heng
 */
public interface GeneralBookMapper extends BaseMapper<GeneralBook> {

    /**
     * 查询关联帐号ID的所有电子书信息
     * @param accountId 用户帐号ID
     * @param page 分页控制
     * @return
     */
    IPage<GeneralBook> queryBooksByAccountId(String accountId, Page<GeneralBook> page);

    /**
     * 检查指定电子书信息是否存在
     * @param bookId 电子书ID
     * @return
     */
    Integer checkBookExistedByBookId(String bookId);
}