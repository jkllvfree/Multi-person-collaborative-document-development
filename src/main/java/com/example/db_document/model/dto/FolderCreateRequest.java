package com.example.db_document.model.dto;
import lombok.Data;

@Data
public class FolderCreateRequest {
    private String name;
    //private Long creatorId;             后面要改成拦截器
    private Long parentId;
}
