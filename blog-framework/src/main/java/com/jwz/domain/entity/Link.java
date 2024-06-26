package com.jwz.domain.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author JWZ
 * @version 1.0
 * @date 2024/5/11
 * @annotation 友情连接 sg_link
 */
@TableName(value = "sg_link")
@Data
public class Link implements Serializable {
    /**
     *
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 友链名
     */
    private String name;

    /**
     * 友链logo
     */
    private String logo;

    /**
     * 描述
     */
    private String description;

    /**
     * 地址
     */
    private  String address;

    /**
     * 审核状态，0代表审核通过，1代表审核未通过，2代表尚未审核
     */
    private String status;

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


    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

}
