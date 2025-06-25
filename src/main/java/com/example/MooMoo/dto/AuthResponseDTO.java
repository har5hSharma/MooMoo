package com.example.MooMoo.dto;

import com.example.MooMoo.model.User;
import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class AuthResponseDTO {
    private String email_id;
    private String auth_token;

    public AuthResponseDTO(User user) {
        this.email_id = user.getEmail_id();
        this.auth_token = user.getAuth_token();
    }
}
