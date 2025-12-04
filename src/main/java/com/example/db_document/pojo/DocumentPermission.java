package com.example.db_document.pojo;
import lombok.Data;

@Data
public class DocumentPermission {
    private Long id;
    private Long documentId;
    private Long userId;
    private String permissionType;         //需要修改，看看用枚举还是hashMap

    public DocumentPermission() {
    }

    public DocumentPermission(Long id, Long documentId, Long userId, String permissionType) {
        this.id = id;
        this.documentId = documentId;
        this.userId = userId;
        this.permissionType = permissionType;
    }

}
