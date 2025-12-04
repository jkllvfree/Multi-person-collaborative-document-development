package com.example.db_document.pojo;
import java.time.LocalDateTime;
import lombok.Data;

@Data
public class User {
    private Long id;
    private String nickname;
    private String password;
    private String phoneNum;
    private String email;
    private String avatarUrl;          //头像，储存URL地址
    private Integer isDeleted;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;

    //其他参数在注册的时候会传入
    public User() {
        isDeleted = 0;
        createTime = LocalDateTime.now();
        updateTime = LocalDateTime.now();
    }

    public User(Long id, String nickname, String password, String phoneNum, String email, String avatar, Integer isDeleted, LocalDateTime createTime, LocalDateTime updateTime) {
        this.id = id;
        this.nickname = nickname;
        this.password = password;
        this.phoneNum = phoneNum;
        this.email = email;
        this.avatarUrl = avatar;
        this.isDeleted = isDeleted;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }
}
