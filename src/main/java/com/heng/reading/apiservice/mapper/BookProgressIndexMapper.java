package com.heng.reading.apiservice.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.heng.reading.apiservice.dto.progress.BookProgressIndexDto;
import com.heng.reading.apiservice.entity.BookProgressIndex;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author heng
 */
public interface BookProgressIndexMapper extends BaseMapper<BookProgressIndex> {

    /**
     * 查询指定用户账号近5日阅读进度索引
     * @param accountId 用户账号ID
     * @return
     */
    List<BookProgressIndexDto> queryRecentReadingProgressIndex(String accountId);

    /**
     * 删除当前阅读进度与电子书的关联索引
     * （单项删除）
     * @param progressId 阅读进度ID
     * @return
     */
    int deleteByProgressId(String progressId);

    /**
     * 删除当前电子书与阅读进度的关联索引
     * （多项删除）
     * @param bookId 电子书ID
     * @return
     */
    int deleteByBookId(String bookId);
}