package com.jwz.utils;

import com.jwz.domain.LoginUser;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * @author JWZ
 * @version 1.0
 * @date 2024/5/11
 * @annotation 从SecurityContextHolder中获得到用户信息
 */
public class SecurityUtils {

    /**
     * 获取Authentication, SecurityContext获得用户相关信息
     */
    public static Authentication getAuthentication(){
        return SecurityContextHolder.getContext().getAuthentication();
    }

    /**
     * 获取用户
     */
    public static LoginUser getLoginUser(){
        return (LoginUser) getAuthentication().getPrincipal();
    }

    /**
     * 获取用户id
     */
    public static Long getUserId(){
        return getLoginUser().getUser().getId();
    }

    /**
     * 判断是不是管理员
     */
    public static Boolean isAdmin(){
        Long id = getLoginUser().getUser().getId();
        return id != null && id.equals(1L);
    }


}
