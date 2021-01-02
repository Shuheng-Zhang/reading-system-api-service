package com.heng.reading.apiservice.comms.utils;


import com.heng.reading.apiservice.comms.data.CommCodeMsg;
import com.heng.reading.apiservice.comms.exception.BusinessException;
import nl.siegmann.epublib.domain.Author;
import nl.siegmann.epublib.domain.Book;
import nl.siegmann.epublib.domain.Metadata;
import nl.siegmann.epublib.domain.Resource;
import nl.siegmann.epublib.epub.EpubReader;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

/**
 * ePub 文件解析工具
 * @author heng
 */
public class EpubParseUtils {


    final private static String JPG = ".jpg";
    final private static String PNG = ".png";

    /**
     * 获取 ePub 元数据
     * @param epubBook ePub Book 对象
     * @return ePub 元数据
     * @throws NullPointerException
     */
    public static Map<String, String> getMetadata(Book epubBook) throws NullPointerException {

        // 获取 metadata
        Metadata epubMetadata = epubBook.getMetadata();

        // 获取 标题
        String bookTitle = epubMetadata.getFirstTitle();

        // 获取 作者列表
//        List<String> authors = new ArrayList<>();
        StringBuilder authors = new StringBuilder();
        if (epubMetadata.getAuthors() != null) {
            for (Author author : epubMetadata.getAuthors()) {
                authors.append(author.toString());
            }
        }

        // 获取 内容简介
        StringBuilder epubDescription = new StringBuilder();
        if (epubMetadata.getDescriptions() != null) {
            for (String s : Objects.requireNonNull(epubMetadata.getDescriptions())) {
                epubDescription.append(s);
            }
        }

        Map<String, String> resMap = new HashMap<>(3);
        resMap.put("title", bookTitle);
        resMap.put("authors", authors.toString());
        resMap.put("description", epubDescription.toString());

        return resMap;
    }


    /**
     * 获取 ePub 封面并另存为
     * @param epubBook ePub Book 对象
     * @param storedFileDirPath 封面存储目录路径
     * @return 封面另存为文件名
     * @throws IOException
     */
    public static String getBookCover(Book epubBook, String storedFileDirPath) throws IOException {

        // 获取封面资源
        Resource coverImgResource = epubBook.getCoverImage();

        // 获取封面文件后缀名
        String type = coverImgResource.getMediaType().getDefaultExtension();

        // 依照不同扩展名对封面进行另存为
        File coverFile;
        String fileName = UUIDUtil.uuid();

        if (JPG.equals(type)) {
            coverFile = new File(storedFileDirPath + fileName + JPG);
        } else if (PNG.equals(type)) {
            coverFile = new File(storedFileDirPath + fileName + PNG);
        } else {
            throw new BusinessException(CommCodeMsg.CODE_TERMINATE, CommCodeMsg.MSG_FILE_NOT_SUPPORT);
        }
        FileUtils.writeByteArrayToFile(coverFile, coverImgResource.getData());

        return coverFile.getName();
    }

    /**
     * 加载 ePub 文件
     * @param epubFilePath ePub 文件路径
     * @return ePub Book 对象
     * @throws IOException
     */
    public static Book loadEpub(String epubFilePath) throws IOException {
        // 读取 ePub 文件
        EpubReader epubReader = new EpubReader();
        return epubReader.readEpub(new FileInputStream(epubFilePath));
    }
}
