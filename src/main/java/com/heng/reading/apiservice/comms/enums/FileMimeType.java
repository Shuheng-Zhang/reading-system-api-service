package com.heng.reading.apiservice.comms.enums;

/**
 * 文件类型枚举
 * @author heng
 */

public enum FileMimeType {

    /**
     * EPUB
     */
    EPUB("application/epub+zip"),

    /**
     * PDF
     */
    PDF("application/pdf"),

    /**
     * TXT
     */
    TXT("text/plain"),

    /**
     * JPG
     */
    JPG("image/jpeg"),

    /**
     * PNG
     */
    PNG("image/png")
    ;

    /**
     * 文件类型
     */
    final private String contentType;

    FileMimeType(String contentType) {
        this.contentType = contentType;
    }

    public String getContentType() {
        return contentType;
    }

}
