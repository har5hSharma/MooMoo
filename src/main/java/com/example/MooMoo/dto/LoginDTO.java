package com.example.MooMoo.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;

import java.util.List;

@Getter@Setter
public class LoginDTO {
    private String email_id;
    private String user_pass;
    private GeoJsonPoint location;
    private String auth_token;
}
