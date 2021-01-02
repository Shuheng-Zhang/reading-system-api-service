package com.heng.reading.apiservice.service;

import com.heng.reading.apiservice.entity.AccountBookIndex;
import com.baomidou.mybatisplus.extension.service.IService;
/**
 * @author heng
 */
public interface AccountBookIndexService extends IService<AccountBookIndex> {

    /**
     * 删除当前电子书与用户帐号的关联索引
     * @param bookId 电子书ID
     */
    void deleteByBookId(String bookId);
}
