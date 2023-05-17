package com.lhind.internship.springbootfirstprogram.SpringBootApp.exception;

import com.lhind.internship.springbootfirstprogram.SpringBootApp.model.dto.BaseResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.List;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = AuthenticationException.class)
    public ResponseEntity<BaseResponse> handeAuthenticationException(AuthenticationException e){
        log.info("Invalid login information");
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setMessages(List.of("Username or password is incorrect"));
        return ResponseEntity.status(403).body(baseResponse);
    }
    @ExceptionHandler(value = UserNotFoundException.class)
    public ResponseEntity<BaseResponse> handleUserNotFoundException(UserNotFoundException e){
        log.warn("User not found");
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setMessages(List.of("User was not found"));
        return ResponseEntity.status(404).body(baseResponse);
    }
    @ExceptionHandler(value = RuntimeException.class)
    public ResponseEntity<BaseResponse> handleRuntimeException(RuntimeException e){
        log.error("",e);
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setMessages(List.of("Something went wrong!"));
        return ResponseEntity.status(500).body(baseResponse);
    }
}
