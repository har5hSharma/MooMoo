package com.example.MooMoo.model;


import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Getter
@Setter
@Document(collection = "Users")
public class User {

    @Id@NonNull
    private String email_id;
    private String user_name;
    private String user_pass;
    private GeoJsonPoint location;
    private List<String> profile_images;
    private String auth_token;

}
