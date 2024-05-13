package com.jwz.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author JWZ
 * @version 1.0
 * @date 2024/5/13
 * @annotation  热门文章VO
 */

@AllArgsConstructor
@Data
public class HotArticleVo {

    private Long id;
    private String title;
    private Long viewCount;
}
