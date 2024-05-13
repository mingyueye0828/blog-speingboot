package com.jwz.domain;

import com.jwz.domain.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

/**
 * @author JWZ
 * @version 1.0
 * @date 2024/5/11
 * @annotation 用来获取用户、密码
 * Spring Security 框架中表示用户的核心接口
 * 涉及用户，密码，权限 用户账户是有效的，不过期、未锁定、凭证未过期且已启用
 */
@Data
@AllArgsConstructor
public class LoginUser implements UserDetails {

    private User user;

    private List<String> permissions;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUserName();
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
