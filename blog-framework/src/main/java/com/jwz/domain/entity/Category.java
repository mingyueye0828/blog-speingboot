package com.jwz.domain.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author JWZ
 * @version 1.0
 * @date 2024/5/10
 * @annotation 分类表 category
 */
@Data
@TableName(value = "sg_category")
public class Category implements Serializable {
    /**
     * id随机
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 分类名
     */
    private String name;

    /**
     * 父分类id,没有父分类为-1
     */
    private Long pid;

    /**
     * 描述
     */
    private String description;

    /**
     * 状态 0：正常，1禁用
     */
    private String status;

    /**
     * 创建人id,由框架自动填充
     */
    @TableField(fill = FieldFill.INSERT)
    private Long createBy;

    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Long updateBy;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

    /**
     * 删除标志（0代表未删除，1代表已删除）
     */
    private Integer delFlag;

    /**
     * 序列化版本化，用来标记对应版本
     */
    @TableField(exist = false)
    private static final long serialVersionUID = 1L;




}
