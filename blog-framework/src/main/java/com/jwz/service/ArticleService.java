package com.jwz.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jwz.domain.dto.ArticleDto;
import com.jwz.domain.entity.Article;
import com.jwz.domain.response.ResponseResult;

/**
 * @author JWZ
 * @version 1.0
 * @date 2024/5/11
 * @annotation 针对表【sg_article(文章表)】
 */

public interface ArticleService extends IService<Article> {
    /**
     * 热门文章查询
     */
    ResponseResult hotArticleList();

    /**
     * @description: 文章列表查询
     * @param category 类别
     * @param pageNum 页数
     * @param pageSize 多少
     * @return: ResponseResult
     */
    ResponseResult articleList(Long category, Integer pageNum, Integer pageSize);

    /**
     * @description: 根据id获取文章详情
     * @param id
     * @return:
     */
    ResponseResult getArticleDetails(Integer id);

    /**
     * @description: 更新文章数量
     * @param id
     * @return:
     */
    ResponseResult updateViewCount(Long id);

    /**
     * @description: 查询文章列表
     * @param pageNum 页面num
     * @param pageSize 页面大小
     * @param articleDto 文章dto
     * @return: {@link ResponseResult}
     */
    ResponseResult getAllArticleList(Integer pageNum, Integer pageSize, ArticleDto articleDto);


}
