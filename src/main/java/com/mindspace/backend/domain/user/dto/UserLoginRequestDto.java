package com.mindspace.backend.domain.user.dto;

import com.sun.istack.NotNull;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UserLoginRequestDto {
    @NotNull
    private String email;

    @NotNull
    private String password;
}
