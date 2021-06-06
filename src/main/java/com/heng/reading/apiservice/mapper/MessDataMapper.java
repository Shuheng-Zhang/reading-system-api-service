package com.heng.reading.apiservice.mapper;

import java.util.List;
import java.util.Map;

public interface MessDataMapper {

    /**
     * 查询 指定用户账号的电子书与阅读进度关联索引
     * @param accountId 用户账号ID
     * @return
     */
    List<Map<String, String>> queryBookAndReadingProgressRelatedIndexesByAccountId(String accountId);

}
