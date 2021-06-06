package com.heng.reading.apiservice.dto.book;

import lombok.Data;

/**
 * 数据传输对象 电子书对象简易信息
 */
@Data
public class GeneralBookSimpleDto {

    /**
     * ID
     */
    private String id;
    /**
     * 电子书标题
     */
    private String bookTitle;
    /**
     * 电子书作者
     */
    private String bookAuthors;
    /**
     * 电子书封面URL
     */
    private String bookCoverUrl;
    /**
     * 电子书 OPF 文件URL
     */
    private String bookOpfUrl;
}
