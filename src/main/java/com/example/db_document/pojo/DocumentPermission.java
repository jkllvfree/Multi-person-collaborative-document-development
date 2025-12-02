package com.example.db_document.pojo;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getDocumentId() {
        return documentId;
    }

    public void setDocumentId(Long documentId) {
        this.documentId = documentId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getPermissionType() {
        return permissionType;
    }

    public void setPermissionType(String permissionType) {
        this.permissionType = permissionType;
    }
}
