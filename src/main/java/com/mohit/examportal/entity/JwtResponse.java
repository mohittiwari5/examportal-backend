package com.mohit.examportal.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JwtResponse {
    String token;

    public JwtResponse() {
    }

    public JwtResponse(String token) {
        this.token = token;
    }
}
