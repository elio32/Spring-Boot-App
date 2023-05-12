package com.lhind.internship.springbootfirstprogram.SpringBootApp.controller;

import com.lhind.internship.springbootfirstprogram.SpringBootApp.model.dto.AuthenticationRequest;
import com.lhind.internship.springbootfirstprogram.SpringBootApp.model.dto.AuthenticationResponse;
import com.lhind.internship.springbootfirstprogram.SpringBootApp.model.dto.RegisterRequest;
import com.lhind.internship.springbootfirstprogram.SpringBootApp.service.impl.AuthenticationServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class AuthenticateController {

    private final AuthenticationServiceImpl authenticationService;

    public AuthenticateController(AuthenticationServiceImpl authenticationService) {
        this.authenticationService = authenticationService;
    }

    @RequestMapping(method = RequestMethod.POST,path = "/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest authenticationRequest){
        return ResponseEntity.ok(authenticationService.authenticate(authenticationRequest));
    }
    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register( @RequestBody RegisterRequest request) {
        return ResponseEntity.ok(authenticationService.register(request));
    }
}
