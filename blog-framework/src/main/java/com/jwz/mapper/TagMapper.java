package com.jwz.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jwz.domain.entity.Role;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author JWZ
 * @version 1.0
 * @date 2024/5/11
 * @annotation
 */
@Mapper
public interface TagMapper extends BaseMapper<Role> {
}
