package com.crowdfunding.dp.backend.rest.controllers;

import com.crowdfunding.dp.backend.model.AuthenticationRequest;
import com.crowdfunding.dp.backend.model.AuthenticationResponse;
import com.crowdfunding.dp.backend.model.User;
import com.crowdfunding.dp.backend.rest.security.JwtUtil;
import com.crowdfunding.dp.backend.service.MyUserDetailsService;
import com.crowdfunding.dp.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/api/authenticate")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private MyUserDetailsService userDetailsService;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private UserService userService;


    @PostMapping
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                authenticationRequest.getLogin(),
                authenticationRequest.getPassword()
            ));
        } catch (BadCredentialsException e) {
            throw new Exception("Incorrect username or password");
        }

        final UserDetails userDetails = userDetailsService
            .loadUserByUsername(authenticationRequest.getLogin());

        final String jwt = jwtUtil.generateToken(userDetails);

        final User user = userService.getLoggedInUser(jwt);

        return new ResponseEntity<>(new AuthenticationResponse(jwt, user), HttpStatus.OK);
    }
}
