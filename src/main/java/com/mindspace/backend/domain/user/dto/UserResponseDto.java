package com.mindspace.backend.domain.user.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;


@Getter
@Builder
@AllArgsConstructor
public class UserResponseDto {

    private int id;

    private String email;

    private String password;

    private String nickname;
}
