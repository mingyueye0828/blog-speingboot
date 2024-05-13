package com.jwz.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * @author JWZ
 * @version 1.0
 * @date 2024/5/11
 * @annotation 角色和菜单关联表
 */
@Data
@TableName(value = "sys_role_menu")
public class RoleMenu implements Serializable {
    /**
     * 角色ID
     */
    @TableId
    private Integer roleId;

    /**
     * 菜单ID
     */
    private Integer menuId;


}
