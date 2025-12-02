package com.example.db_document.pojo;

import java.time.LocalDateTime;

public class Folder {
    private Long id;
    private String name;
    private Long craetorId;
    private Long parentId;
    private Integer isDeleted;
    private LocalDateTime createTime;

    public Folder(){
    }

    public Folder(Long id, String name,Long craetorId, Long parentId, Integer isDeleted,LocalDateTime createTime) {
        this.id = id;
        this.name = name;
        this.craetorId = craetorId;
        this.parentId = parentId;
        this.isDeleted = isDeleted;
        this.createTime = createTime;
    }

    public Long getCraetorId() {
        return craetorId;
    }

    public void setCraetorId(Long craetorId) {
        this.craetorId = craetorId;
    }

    public Integer getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }
}
