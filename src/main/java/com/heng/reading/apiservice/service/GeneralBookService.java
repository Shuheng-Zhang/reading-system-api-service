package com.heng.reading.apiservice.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.heng.reading.apiservice.entity.GeneralBook;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @author heng
 */
public interface GeneralBookService extends IService<GeneralBook> {

    /**
     * 查询指定用户帐号下的所有电子书信息
     * @param accountId 用户帐号ID
     * @param page 分页控制
     * @return
     */
    IPage<GeneralBook> findBooksByAccountId(String accountId, Page<GeneralBook> page);

    /**
     * 删除当前电子书信息及其文件数据
     * @param bookId 电子书ID
     */
    void removeBookByBookId(String bookId);
}
