package com.crowdfunding.dp.backend.rest.controllers;

import com.crowdfunding.dp.backend.model.User;
import com.crowdfunding.dp.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("rest/api/users")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/register")
    public ResponseEntity<Boolean> registerUser(@RequestBody User user) {
        //TODO double check
        userService.registerUser(user);
        return new ResponseEntity<>(true, HttpStatus.OK);
    }
}
