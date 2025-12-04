package com.example.db_document.mapper;

import com.example.db_document.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {
    /**
     * 新增用户
     * 返回 int 表示受影响的行数（成功通常返回 1）
     */
    int insert(User user);

    int updateName(Long userId, String newName);
    /**
     * 根据邮箱查询用户（用于登录或查重）
     */
    User selectByEmail(@Param("email") String email);

    /**
     * 根据手机号查询用户
     */
    User selectByPhone(@Param("phone") String phone);

    //判断是否重名
    User selectByNickname(@Param("nickname") String nickname);

    //用来登录时查询用户
    User selectByAccount(@Param("account") String account);
}
