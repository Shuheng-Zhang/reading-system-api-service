package com.heng.reading.apiservice.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.heng.reading.apiservice.entity.AccountBookIndex;

/**
 * @author heng
 */
public interface AccountBookIndexMapper extends BaseMapper<AccountBookIndex> {

    /**
     * 删除当前电子书与用户帐号的关联索引
     * （单项删除）
     * @param bookId 电子书ID
     * @return
     */
    int deleteIndexByBookId(String bookId);

    /**
     * 删除当前用户帐号与其电子书的索引
     * （多项删除）
     * @param accountId 用户帐号ID
     * @return
     */
    int deleteIndexByAccountId(String accountId);
}