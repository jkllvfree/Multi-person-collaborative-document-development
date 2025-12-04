package com.example.db_document.model.dto;
import lombok.Data;

@Data
public class RegisterRequest {
    private String nickname;
    private String password;
    private String phoneNum;
    private String email;
}
