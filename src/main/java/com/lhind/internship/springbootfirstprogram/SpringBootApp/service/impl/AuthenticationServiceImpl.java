package com.lhind.internship.springbootfirstprogram.SpringBootApp.service.impl;

import com.lhind.internship.springbootfirstprogram.SpringBootApp.model.dto.AuthenticationRequest;
import com.lhind.internship.springbootfirstprogram.SpringBootApp.model.dto.AuthenticationResponse;
import com.lhind.internship.springbootfirstprogram.SpringBootApp.model.dto.RegisterRequest;
import com.lhind.internship.springbootfirstprogram.SpringBootApp.model.entity.User;
import com.lhind.internship.springbootfirstprogram.SpringBootApp.repository.UserRepository;
import com.lhind.internship.springbootfirstprogram.SpringBootApp.service.AuthenticationService;
import com.lhind.internship.springbootfirstprogram.SpringBootApp.service.TokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {
    private final UserDetailsService userDetailsService;
    private final TokenService tokenService;
    private final PasswordEncoder passwordEncoder;
    private final UserRepository repository;
    private final TokenService jwtService;
    private final AuthenticationManager authenticationManager;



    @Override
    public AuthenticationResponse authenticate(AuthenticationRequest authenticationRequest) throws AuthenticationException{
        final AuthenticationResponse authenticationResponse = new AuthenticationResponse();
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword()));
        authenticationResponse.setToken(tokenService.generateToken(userDetailsService.loadUserByUsername(authenticationRequest.getUsername())));
        return authenticationResponse;
    }
    public AuthenticationResponse register(RegisterRequest request) {

        User user1 = new User();
        BeanUtils.copyProperties(request, user1);

        user1.setFirstName(request.getFirstName());
        user1.setLastName(request.getLastName());
        user1.setEmail(request.getEmail());
        user1.setPhoneNumber(request.getPhoneNumber());

        user1.setPassword(passwordEncoder.encode(request.getPassword()));

        repository.save(user1);


        var jwtToken =  jwtService.generateToken(user1);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }
}
