package com.jwz.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jwz.domain.entity.Category;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author JWZ
 * @version 1.0
 * @date 2024/5/11
 * @annotation 数据库操作: 针对表【sg_category(分类表)】
 */
@Mapper
public interface CategoryMapper extends BaseMapper<Category> {

}
