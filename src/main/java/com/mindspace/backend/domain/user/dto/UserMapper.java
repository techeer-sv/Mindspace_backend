package com.mindspace.backend.domain.user.dto;

import com.mindspace.backend.domain.user.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public User DtoToEntity(UserSignupRequestDto userRequestDto) {
        return User.builder()
                .email(userRequestDto.getEmail())
                .password(userRequestDto.getPassword())
                .nickname(userRequestDto.getNickname())
                .build();
    }

    public UserResponseDto DtoFromEntity(User user) {
        return UserResponseDto.builder()
                .id(user.getId())
                .email(user.getEmail())
                .password(user.getPassword())
                .nickname(user.getNickname())
                .build();
    }

    public static UserNicknameResponseDto nicknameDtoFromEntity(User user) {
        return UserNicknameResponseDto.builder()
                .nickname(user.getNickname())
                .build();
    }
}
