package com.heng.reading.apiservice.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.heng.reading.apiservice.entity.GeneralBook;
import org.apache.ibatis.annotations.Param;


/**
 * @author heng
 */
public interface GeneralBookMapper extends BaseMapper<GeneralBook> {

    /**
     * 查询关联帐号ID的所有电子书信息
     * @param accountId 用户帐号ID
     * @param page 分页控制
     * @return
     */
    IPage<GeneralBook> queryBooksByAccountId(String accountId, Page<GeneralBook> page);

    /**
     * 模糊查询关联账号ID的电子书信息
     * @param accountId 用户账号ID
     * @param titleLike 查询标题
     * @param authorsLike 查询作者
     * @param page 分页控制
     * @return
     */
    IPage<GeneralBook> queryBookByAccountIdWithTitleLikeOrAuthorsLike(@Param("accountId") String accountId,
                                                                      @Param("titleLike") String titleLike,
                                                                      @Param("authorLike") String authorsLike, Page<GeneralBook> page);

    /**
     * 检查指定电子书信息是否存在
     * @param bookId 电子书ID
     * @return
     */
    Integer checkBookExistedByBookId(String bookId);
}