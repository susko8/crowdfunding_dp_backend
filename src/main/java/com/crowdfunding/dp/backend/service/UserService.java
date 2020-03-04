package com.crowdfunding.dp.backend.service;

import com.crowdfunding.dp.backend.dao.UserRepository;
import com.crowdfunding.dp.backend.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class UserService {

    @Autowired
    UserRepository userRepository;

    public User findUserByLogin(String login) {
        return userRepository.findUserByLoginEquals(login);
    }
}
