package com.example.db_document.pojo;

import java.time.LocalDateTime;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public Integer getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }
}
