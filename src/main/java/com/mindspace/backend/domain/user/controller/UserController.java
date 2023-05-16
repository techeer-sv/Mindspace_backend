package com.mindspace.backend.domain.user.controller;

import com.mindspace.backend.domain.user.dto.UserLoginRequestDto;
import com.mindspace.backend.domain.user.dto.UserMapper;
import com.mindspace.backend.domain.user.dto.UserResponseDto;
import com.mindspace.backend.domain.user.dto.UserSignupRequestDto;
import com.mindspace.backend.domain.user.entity.User;
import com.mindspace.backend.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/user")
public class UserController {
    private final UserService USER_SERVICE;
    private final UserMapper USER_MAPPER;

    @PostMapping("/signup")
    @ResponseStatus(HttpStatus.CREATED)
    public UserResponseDto signupUser(
            @RequestBody UserSignupRequestDto userSignupRequestDto) {
        User signupResult = USER_SERVICE.signupUser(userSignupRequestDto);
        return USER_MAPPER.DtoFromEntity(signupResult);
    }

    @PostMapping("/login")
    @ResponseStatus(HttpStatus.OK)
    public UserResponseDto loginUser(
            @RequestBody UserLoginRequestDto userLoginRequestDto) {
        User loginResult = USER_SERVICE.loginUser(userLoginRequestDto);
        return USER_MAPPER.DtoFromEntity(loginResult);
    }

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<User> getAllUser(){
        return USER_SERVICE.getAllUser();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public String getUserNickname(@PathVariable int id){
        return USER_SERVICE.getUserNickname(id);
    }

}
