package com.base.service;

import com.base.dto.request.UserCreationRequest;
import com.base.dto.response.UserResponse;
import com.base.entity.User;
import com.base.exception.AppException;
import com.base.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.TestPropertySource;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;

@SpringBootTest
@Slf4j
@TestPropertySource("/test.properties")
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @MockBean
    private UserRepository userRepository;

    private UserCreationRequest request;
    private UserResponse userResponse;
    private User user;
    private LocalDate dob;

    // this method will be called before each test method
    @BeforeEach
    void initData() {
        dob = LocalDate.of(1990, 1, 1);
        request = UserCreationRequest.builder()
                .username("james1")
                .password("12345678")
                .lastName("test")
                .firstName("test")
                .dob(dob)
                .build();

        userResponse = UserResponse.builder()
                .id("123423sdf")
                .username("james1")
                .lastName("test")
                .firstName("test")
                .dob(dob)
                .build();

        user = User.builder()
                .id("123423sdf")
                .username("james1")
                .lastName("test")
                .firstName("test")
                .dob(dob)
                .build();

    }

    // 1 unit test included 3 part GIVEN, WHEN, THEN
    @Test
    void createUser_validRequest_success() throws Exception {

        // GIVEN
        Mockito.when(userRepository.existsByUsername(anyString())).thenReturn(false);
        Mockito.when(userRepository.save(any())).thenReturn(user);
        // WHEN
        var response = userService.createUser(request);

        // THEN
        Assertions.assertThat(response.getId()).isEqualTo(user.getId());
        Assertions.assertThat(response.getUsername()).isEqualTo(user.getUsername());

    }

    @Test
    void createUser_userExisted_fail() throws Exception {

        // GIVEN
        Mockito.when(userRepository.existsByUsername(anyString())).thenReturn(true);

        // WHEN, THEN
        var exception = assertThrows(AppException.class, () -> userService.createUser(request));

        Assertions.assertThat(exception.getErrorCode().getCode())
                .isEqualTo(1002);

    }


}
