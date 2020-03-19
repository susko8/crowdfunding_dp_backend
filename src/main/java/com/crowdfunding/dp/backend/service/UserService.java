package com.crowdfunding.dp.backend.service;

import com.crowdfunding.dp.backend.dao.UserRepository;
import com.crowdfunding.dp.backend.model.User;
import com.crowdfunding.dp.backend.rest.security.JwtUtil;
import com.crowdfunding.dp.backend.types.UserRoleEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    JwtUtil jwtUtil;

    public User findUserByLogin(String login) {
        return userRepository.findUserByLoginEquals(login);
    }

    public User getLoggedInUser(String token) {
        final String login = jwtUtil.extractUsername(token);
        return userRepository.findUserByLoginEquals(login);
    }

    public void registerUser(User user) {
        user.setUserRoleEnum(UserRoleEnum.USER);
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String hashedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(hashedPassword);
        userRepository.save(user);
    }
}
