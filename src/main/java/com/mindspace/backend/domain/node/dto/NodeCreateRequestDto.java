package com.mindspace.backend.domain.node.dto;

import com.sun.istack.NotNull;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class NodeCreateRequestDto {
    @NotNull
    private String name;
}