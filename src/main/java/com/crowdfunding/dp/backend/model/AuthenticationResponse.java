package com.crowdfunding.dp.backend.model;

import lombok.Getter;

@Getter
public class AuthenticationResponse {

    private final String jwt;

    private final User user;

    public AuthenticationResponse(String jwt, User user) {
        this.jwt = jwt;
        this.user = user;
    }
}
