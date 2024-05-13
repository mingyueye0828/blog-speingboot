package com.jwz.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jwz.domain.entity.Article;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author JWZ
 * @version 1.0
 * @date 2024/5/10
 * @annotation 数据库操作：针对表【sg_article(文章表)】
 */
@Mapper
public interface ArticleMapper extends BaseMapper<Article> {

}
