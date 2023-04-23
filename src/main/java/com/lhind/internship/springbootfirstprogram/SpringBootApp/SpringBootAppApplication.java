package com.lhind.internship.springbootfirstprogram.SpringBootApp;

import com.lhind.internship.springbootfirstprogram.SpringBootApp.service.UserService;
import com.lhind.internship.springbootfirstprogram.SpringBootApp.service.impl.UserServiceImpl;
import jakarta.annotation.PostConstruct;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootAppApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootAppApplication.class, args);
	}


}
