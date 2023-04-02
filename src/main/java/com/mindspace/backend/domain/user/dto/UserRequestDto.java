package com.mindspace.backend.domain.user.dto;

import com.sun.istack.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
public class UserRequestDto {
    @NotNull
    private String email;

    @NotNull
    private String password;

    @NotNull
    private String nickname;
}
