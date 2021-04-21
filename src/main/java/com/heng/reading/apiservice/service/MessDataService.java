package com.heng.reading.apiservice.service;

import java.util.List;
import java.util.Map;

public interface MessDataService {

    /**
     * 查询 指定用户账号最近5日的电子书与阅读进度关联索引
     * @param accountId 用户账号ID
     * @return
     */
    List<Map<String, String>> findBookAndReadingProgressRelatedIndexesByAccountId(String accountId);
}
