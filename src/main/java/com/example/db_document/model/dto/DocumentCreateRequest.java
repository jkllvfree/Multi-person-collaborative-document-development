package com.example.db_document.model.dto;

import lombok.Data;

@Data
public class DocumentCreateRequest {
    private String name;
    private Long folderId;
    private String content;
}
