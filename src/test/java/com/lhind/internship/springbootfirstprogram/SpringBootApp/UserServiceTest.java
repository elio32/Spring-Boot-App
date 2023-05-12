package com.lhind.internship.springbootfirstprogram.SpringBootApp;

import com.lhind.internship.springbootfirstprogram.SpringBootApp.mapper.UserMapper;
import com.lhind.internship.springbootfirstprogram.SpringBootApp.model.dto.UserDTO;
import com.lhind.internship.springbootfirstprogram.SpringBootApp.model.entity.User;
import com.lhind.internship.springbootfirstprogram.SpringBootApp.model.enums.UserRoleEnum;
import com.lhind.internship.springbootfirstprogram.SpringBootApp.repository.UserRepository;
import com.lhind.internship.springbootfirstprogram.SpringBootApp.service.UserService;
import com.lhind.internship.springbootfirstprogram.SpringBootApp.service.impl.UserServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

    public class UserServiceTest {

        private UserService userService;

        @Mock
        private UserRepository userRepository;
        @Mock
        private BCryptPasswordEncoder bCryptPasswordEncoder;


        @Mock
        private UserMapper userMapper;

        @BeforeEach
        public void setup() {
            MockitoAnnotations.initMocks(this);
            userService = new UserServiceImpl(userRepository, userMapper, bCryptPasswordEncoder);
        }

        @Test
        public void testLoadAllUsers() {
            List<User> userList = new ArrayList<>();
            User user1 = new User(null,"John", "MANAGER", UserRoleEnum.MANAGER,"Do","johndoe@example.com","576576567",null,"asdas");
            User user2 = new User(null,"John", "USER", UserRoleEnum.USER,"Do","johndoe@example.com","576576567",null,"asdas");
            userList.add(user1);
            userList.add(user2);

            when(userRepository.findAll()).thenReturn(userList);

            UserDTO userDto1 = new UserDTO(null,"John", UserRoleEnum.MANAGER, "Jo","Do","johndoe@example.com","576576567");
            UserDTO userDto2 = new UserDTO(null,"John", UserRoleEnum.USER, "Jo","Do","johndoe@example.com","576576567");
            List<UserDTO> expectedUserDtoList = new ArrayList<>();
            expectedUserDtoList.add(userDto1);
            expectedUserDtoList.add(userDto2);

            when(userMapper.toDto(user1)).thenReturn(userDto1);
            when(userMapper.toDto(user2)).thenReturn(userDto2);

            List<UserDTO> actualUserDtoList = userService.loadAllUsers();
            assertEquals(expectedUserDtoList, actualUserDtoList);
        }
}
