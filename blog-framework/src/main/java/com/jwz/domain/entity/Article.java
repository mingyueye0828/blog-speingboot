package com.jwz.domain.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author JWZ
 * @version 1.0
 * @date 2024/5/10
 * @annotation  文章表
 */

@Data
@AllArgsConstructor
//@NoArgsConstructor  会自动生成的
@Accessors(chain = true)   //可以使用链式调用 .setAge.setName
@TableName(value = "sg_article")
public class Article implements Serializable {

    /**
     * id 自增
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 标题
     */
    private String title;

    /**
     * 文章内容
     */
    private String content;

    /**
     * 文章摘要
     */
    private String summary;

    /**
     * 所属类别id
     */
    private Long categoryId;


    /**
     * 所属分类id的categoryName
     */
    @TableField(exist = false)
    private String categoryName;

    /**
     * 缩略图，二进制
     */
    private String thumbnail;

    /**
     * 是否置顶（0否，1是）
     */
    private String isTop;

    /**
     * 文章状态，0已发布，1草稿，
     */
    private String status;

    /**
     * 访问量
     */
    private Long viewCount;

    /**
     * 是否允许评论，1是，0否
     */
    private String isComment;

    @TableField(exist = false)
    private List<Long> tag;

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

    //构造器，根据id和viewCount
    public Article(Long id, Long viewCount) {
        this.id = id;
        this.viewCount = viewCount;
    }
}
