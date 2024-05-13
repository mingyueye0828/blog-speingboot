package com.jwz.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author JWZ
 * @version 1.0
 * @date 2024/5/10
 * @annotation  文章标签关联表
 */

@Data
//@NoArgsConstructor
@AllArgsConstructor
@TableName(value = "sg_article_tag")
public class ArticleTag implements Serializable {

    /**
     * 文章id
     */
    @TableId(type = IdType.AUTO)
    private Long articleId;

    /**
     * 标签id
     */
    private Long tagId;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

}
