package com.example.db_document.pojo;
import java.time.LocalDateTime;


public class Document {
    private Long id;
    private String name;
    private Long folderId;
    private String title;
    private String content;
    private String creatorId;
    private Integer isDeleted;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;


    public Document(){
    }

    public Document(Long id, String name,String title, String content, String creatorId,Long folderId, Integer isDeleted, LocalDateTime createTime, LocalDateTime updateTime) {
        this.id = id;
        this.name = name;
        this.title = title;
        this.content = content;
        this.creatorId = creatorId;
        this.folderId = folderId;
        this.isDeleted = isDeleted;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public String getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(String creatorId) {
        this.creatorId = creatorId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getFolderId() {
        return folderId;
    }

    public void setFolderId(Long folderId) {
        this.folderId = folderId;
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

