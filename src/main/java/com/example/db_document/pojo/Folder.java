package com.example.db_document.pojo;
import java.time.LocalDateTime;
import lombok.Data;

@Data
public class Folder {
    private Long id;
    private String name;
    private Long creatorId;
    private Long parentId;
    private Integer isDeleted;
    private LocalDateTime createTime;
    private  LocalDateTime updateTime;

    public Folder(){
    }

    public Folder(Long id, String name,Long craetorId, Long parentId, Integer isDeleted,LocalDateTime createTime,LocalDateTime updateTime) {
        this.id = id;
        this.name = name;
        this.creatorId = craetorId;
        this.parentId = parentId;
        this.isDeleted = isDeleted;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

}
