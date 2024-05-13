package com.jwz.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jwz.domain.entity.Menu;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author JWZ
 * @version 1.0
 * @date 2024/5/11
 * @annotation 数据库操作: 针对表【sys_menu(菜单权限表)】
 */
//@Mapper注解，目的就是为了不再写mapper映射文件
//1.使用@Mapper将NewsDAO接口交给Spring进行管理
//2.不用写Mapper映射文件（XML）
//3.为这个NewsDAO接口生成一个实现类，让别的类进行引用

@Mapper
public interface MenuMapper extends BaseMapper<Menu> {

    /**
     * @description: 通过用户id查询对应的权限信息
     * @param userId
     * @return:  List<String>
     */
    List<String> selectPermsByUserId(Long userId);


    /**
     * @description: 为管理员用户查询所有menu
     * @param
     * @return:  List<Menu>
     */
    List<Menu> selectAllRouterMenu();


    List<Menu> selectRouterMenuByUserId(Long userId);

    List<Long> selectMenuListByRole(Long roleId);

}
