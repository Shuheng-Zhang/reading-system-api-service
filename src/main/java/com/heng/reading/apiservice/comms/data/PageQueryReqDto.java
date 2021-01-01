package com.heng.reading.apiservice.comms.data;

import java.util.Map;

/**
 * 通用 HTTP 分页查询请求参数结构
 * @author heng
 */
public class PageQueryReqDto<T> {

    /**
     * 数据集当前页码
     */
    private Integer currentPage;

    /**
     * 数据集单次容量上限
     */
    private Integer limit;

    /**
     * 请求参数键值对
     */
    private Map<String, T> requests;


    /**
     * 无请求参数
     * 默认 当前页码为 1
     * 默认 数据容量上限为 10 项
     */
    public PageQueryReqDto() {
        this.currentPage = 1;
        this.limit = 10;
    }

    /**
     * 带请求参数
     * 默认 当前页码为 1
     * 默认 数据容量上限为 10 项
     * @param requests 请求参数
     */
    public PageQueryReqDto(Map<String, T> requests) {
        this.currentPage = 1;
        this.limit = 10;
        this.requests = requests;
    }

    /**
     * 无请求参数
     * 自定义当前页码
     * 默认数据容量上限为 10
     * @param currentPage 当前页码
     */
    public PageQueryReqDto(Integer currentPage) {
        this.currentPage = currentPage;
        this.limit = 10;
    }

    /**
     * 无请求参数
     * 自定义 页码及容量上限
     * @param currentPage 当前页码
     * @param limit 数据容量上限
     */
    public PageQueryReqDto(Integer currentPage, Integer limit) {
        this.currentPage = currentPage;
        this.limit = limit;
    }

    /**
     * 带请求参数
     * 自定义 页码及容量上限
     * @param currentPage 当前页码
     * @param limit 数据容量上限
     * @param requests 请求参数
     */
    public PageQueryReqDto(Integer currentPage, Integer limit, Map<String, T> requests) {
        this.currentPage = currentPage;
        this.limit = limit;
        this.requests = requests;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Map<String, T> getRequests() {
        return requests;
    }

    public void setRequests(Map<String, T> requests) {
        this.requests = requests;
    }

    /**
     * 获取请求参数的值
     * @param key 请求参数的键
     * @return 请求参数不存在返回 null
     */
    public T getReqParam(String key) {
        if (this.requests == null) {
            return null;
        }

        return this.requests.get(key);
    }

    @Override
    public String toString() {
        return "ReqDto{" +
                "currentPage=" + currentPage +
                ", limit=" + limit +
                ", reqMap=" + requests +
                '}';
    }
}
