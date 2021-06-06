package com.heng.reading.apiservice.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.heng.reading.apiservice.dto.book.GeneralBookDto;
import com.heng.reading.apiservice.dto.book.GeneralBookSimpleDto;
import com.heng.reading.apiservice.entity.GeneralBook;
import org.apache.ibatis.annotations.Param;


/**
 * @author heng
 */
public interface GeneralBookMapper extends BaseMapper<GeneralBook> {

    /**
     * 查询指定ID的简易电子书数据对象
     * @param bookId 电子书ID
     * @return
     */
    GeneralBookSimpleDto queryBookSimpleById(String bookId);

    /**
     * 查询关联帐号ID的所有电子书信息
     * @param accountId 用户帐号ID
     * @param page 分页控制
     * @return
     */
    IPage<GeneralBookDto> queryBooksByAccountId(String accountId, Page<GeneralBookDto> page);

    /**
     * 查询关联账号ID的所有电子书基本信息
     * @param accountId 用户账号ID
     * @param page 分页控制
     * @return
     */
    IPage<GeneralBookSimpleDto> queryBooksSimpleByAccountId(String accountId, Page<GeneralBookSimpleDto> page);

    /**
     * 模糊查询关联账号ID的电子书信息
     * @param accountId 用户账号ID
     * @param titleLike 查询标题
     * @param authorsLike 查询作者
     * @param page 分页控制
     * @return
     */
    IPage<GeneralBookDto> queryBookByAccountIdWithTitleLikeOrAuthorsLike(@Param("accountId") String accountId,
                                                                      @Param("titleLike") String titleLike,
                                                                      @Param("authorLike") String authorsLike, Page<GeneralBookDto> page);

    /**
     * 模糊查询关联账号ID的电子书基本信息
     * @param accountId 用户账号ID
     * @param titleLike 查询标题
     * @param authorsLike 查询作者
     * @param page 分页控制
     * @return
     */
    IPage<GeneralBookSimpleDto> queryBooksSimpleByAccountIdWithTitleLikeOrAuthorsLike(@Param("accountId") String accountId,
                                                                                      @Param("titleLike") String titleLike,
                                                                                      @Param("authorLike") String authorsLike, Page<GeneralBookSimpleDto> page);

    /**
     * 检查指定电子书信息是否存在
     * @param bookId 电子书ID
     * @return
     */
    Integer checkBookExistedById(String bookId);
}