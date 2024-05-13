package com.jwz.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jwz.domain.dto.ArticleDto;
import com.jwz.domain.entity.Article;
import com.jwz.domain.entity.Category;
import com.jwz.domain.response.ResponseResult;
import com.jwz.domain.vo.HotArticleVo;
import com.jwz.mapper.ArticleMapper;
import com.jwz.service.ArticleService;
import com.jwz.service.ArticleTagService;
import com.jwz.service.CategoryService;
import com.jwz.utils.BeanCopyPropertiesUtils;
import com.jwz.utils.RedisCache;
import io.swagger.models.auth.In;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import java.util.List;
import java.util.stream.Collectors;

import static com.jwz.constants.CommonConstants.*;
import static com.jwz.constants.RedisConstants.ARTICLE_VIEWCOUNT;

/**
 * @author JWZ
 * @version 1.0
 * @date 2024/5/11
 * @annotation
 */
@Service
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Article> implements ArticleService {

    @Lazy
    @Resource
    private CategoryService categoryService;

    @Resource
    private RedisCache redisCache;

    @Resource
    private ArticleTagService articleTagService;

    /**
     * 热门博客查询
     */
    @Override
    public ResponseResult hotArticleList() {
        // 1.查询热门文章
        LambdaQueryWrapper<Article> queryWrapper = new LambdaQueryWrapper<>();
        // 2.必须是发布的文章
        queryWrapper.eq(Article::getStatus, ARTICLE_STATUS_PUBLISH);
        // 3. 按照访问量进行排序
        queryWrapper.orderByDesc(Article::getViewCount);
        // 4.查询10条数据
        Page<Article> page = new Page<>(CURRENT_PAGE, SHOW_NUMBERS);
        page(page, queryWrapper);
        List<Article> articles = page.getRecords();
        // 5.根据文章id查询redis缓存获取到当前文章的viewCount并设置
        queryViewCount(articles);

        // 使用stream流进行Bean转换操作,并返回前端
        List<HotArticleVo> hotArticleVos = BeanCopyPropertiesUtils.copyBeanList(articles, HotArticleVo.class);
        return ResponseResult.okResult(hotArticleVos);

    }


    public List<Article> queryViewCount(List<Article> articles){
        articles.stream().map(article -> {
            Integer viewCount = redisCache.getCacheMapValue(ARTICLE_VIEWCOUNT, article.getId().toString());
            article.setViewCount(Long.valueOf(viewCount));
            return article;
        }).collect(Collectors.toList());
        return articles;
    }




    @Override
    public ResponseResult articleList(Long category, Integer pageNum, Integer pageSize) {
        return null;
    }

    @Override
    public ResponseResult getArticleDetails(Integer id) {
        return null;
    }

    @Override
    public ResponseResult updateViewCount(Long id) {
        return null;
    }

    @Override
    public ResponseResult getAllArticleList(Integer pageNum, Integer pageSize, ArticleDto articleDto) {
        return null;
    }
}
