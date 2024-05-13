package com.jwz.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author JWZ
 * @version 1.0
 * @date 2024/5/11
 * @annotation 用户和角色关联表
 */
@Data
@TableName(value = "sys_user_role")
public class UserRole {

    @TableId
    private Long userId;

    private Long roleId;

    @TableField(exist = false)
    private static final Long serialVersionUID = 1L;



}
