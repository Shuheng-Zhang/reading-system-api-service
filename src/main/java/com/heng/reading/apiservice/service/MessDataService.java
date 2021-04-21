package com.heng.reading.apiservice.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.heng.reading.apiservice.vo.GeneralBookSimpleVO;

import java.util.List;
import java.util.Map;

public interface MessDataService {

    /**
     * 查询 指定用户账号最近5日的电子书与阅读进度关联索引
     * @param accountId 用户账号ID
     * @return
     */
    List<Map<String, String>> findBookAndReadingProgressRelatedIndexesByAccountId(String accountId);

    /**
     * 查询 指定用户账号已添加书签的电子书ID列表
     * @param accountId 用户账号ID
     * @param page
     * @return
     */
    IPage<GeneralBookSimpleVO> findBookmarkContainedBookIdByAccountId(String accountId, Page<GeneralBookSimpleVO> page);
}
