package com.api.redis.com.redis.example.models;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User implements Serializable {

    private String userId;
    private String name;
    private String phone;
    private String email;

}
