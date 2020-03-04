package com.crowdfunding.dp.backend.service;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class MyUserDetailsService implements UserDetailsService {

    private final UserService userService;

    public MyUserDetailsService(UserService userService) {
        this.userService = userService;
    }


    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {

        com.crowdfunding.dp.backend.model.User user = userService.findUserByLogin(login);

        return new User(user.getLogin(), user.getPassword(), new ArrayList<>());
    }
}
