package com.jwz.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jwz.domain.entity.ArticleTag;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author JWZ
 * @version 1.0
 * @date 2024/5/11
 * @annotation 数据库操作: 针对表【sg_article_tag(文章标签关联表)】
 */
@Mapper
public interface ArticleTagMapper extends BaseMapper<ArticleTag> {
}
