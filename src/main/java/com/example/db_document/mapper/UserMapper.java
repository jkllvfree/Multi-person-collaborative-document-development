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

    /**
     * 根据邮箱查询用户（用于登录或查重）
     * @Param("email") 是为了在 XML 中能用 #{email} 引用这个参数
     */
    User selectByEmail(@Param("email") String email);

    /**
     * 根据手机号查询用户
     */
    User selectByPhone(@Param("phone") String phone);

    User selectByNickname(@Param("nickname") String nickname);
}
