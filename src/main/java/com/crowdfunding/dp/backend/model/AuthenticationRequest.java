package com.crowdfunding.dp.backend.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthenticationRequest {

    private String login;

    private String password;

    public AuthenticationRequest(){
    }

    public AuthenticationRequest(String login, String password) {
        this.login = login;
        this.password = password;
    }
}
