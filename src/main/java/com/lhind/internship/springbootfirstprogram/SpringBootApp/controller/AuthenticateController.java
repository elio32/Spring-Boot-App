package com.lhind.internship.springbootfirstprogram.SpringBootApp.controller;

import com.lhind.internship.springbootfirstprogram.SpringBootApp.model.dto.AuthenticationRequest;
import com.lhind.internship.springbootfirstprogram.SpringBootApp.model.dto.AuthenticationResponse;
import com.lhind.internship.springbootfirstprogram.SpringBootApp.service.AuthenticationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class AuthenticateController {

    private final AuthenticationService authenticationService;

    public AuthenticateController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @RequestMapping(method = RequestMethod.POST,path = "/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest authenticationRequest){
        return ResponseEntity.ok(authenticationService.authenticate(authenticationRequest));
    }
}
