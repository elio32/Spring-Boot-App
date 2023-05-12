package com.lhind.internship.springbootfirstprogram.SpringBootApp;

import com.lhind.internship.springbootfirstprogram.SpringBootApp.model.entity.User;
import com.lhind.internship.springbootfirstprogram.SpringBootApp.model.enums.UserRoleEnum;
import com.lhind.internship.springbootfirstprogram.SpringBootApp.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringBootAppApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootAppApplication.class, args);
	}

//	@Bean
//	CommandLineRunner run(UserService userService) {
//		return args -> {
//			User userTest = new User();
//			userTest.setUsername("testUser1");
//			userTest.setPassword("Test");
//			userTest.setRole(UserRoleEnum.USER);
//			UserDetails userDetails = new UserDetails(null, "First", "Last", "Email", "1234", userTest);
////			userTest.setUserDetails(userDetails);
//			userService.saveNewUser(userTest);
//		};
//	}


}
