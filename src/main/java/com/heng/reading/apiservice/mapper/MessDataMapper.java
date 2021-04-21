package com.heng.reading.apiservice.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.heng.reading.apiservice.vo.GeneralBookSimpleVO;

import java.util.List;
import java.util.Map;

public interface MessDataMapper {

    /**
     * 查询 指定用户账号的电子书与阅读进度关联索引
     * @param accountId 用户账号ID
     * @return
     */
    List<Map<String, String>> queryBookAndReadingProgressRelatedIndexesByAccountId(String accountId);

    /**
     * 查询 指定用户账号已添加书签的电子书ID列表
     * @param accountId 用户账号ID
     * @return
     */
    IPage<GeneralBookSimpleVO> queryBookmarkContainedBookInfoByAccountId(String accountId, Page<GeneralBookSimpleVO> page);
}
