package com.lhind.internship.springbootfirstprogram.SpringBootApp.service.impl;

import com.lhind.internship.springbootfirstprogram.SpringBootApp.model.dto.AuthenticationRequest;
import com.lhind.internship.springbootfirstprogram.SpringBootApp.model.dto.AuthenticationResponse;
import com.lhind.internship.springbootfirstprogram.SpringBootApp.service.AuthenticationService;
import com.lhind.internship.springbootfirstprogram.SpringBootApp.service.TokenService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    private final AuthenticationManager authenticationManager;
    private final UserDetailsService userDetailsService;
    private final TokenService tokenService;

    public AuthenticationServiceImpl(AuthenticationManager authenticationManager, UserDetailsService userDetailsService, TokenService tokenService) {
        this.authenticationManager = authenticationManager;
        this.userDetailsService = userDetailsService;
        this.tokenService = tokenService;
    }
    @Override
    public AuthenticationResponse authenticate(AuthenticationRequest authenticationRequest) {
        final AuthenticationResponse authenticationResponse = new AuthenticationResponse();
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(),authenticationRequest.getPassword()));
            authenticationResponse.setToken(tokenService.generateToken(userDetailsService.loadUserByUsername(authenticationRequest.getUsername())));
        }catch (AuthenticationException e){
            //here we have to use the logs
        }
        return authenticationResponse;
    }
}
