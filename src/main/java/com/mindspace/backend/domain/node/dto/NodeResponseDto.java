package com.mindspace.backend.domain.node.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class NodeResponseDto {
    private Integer id;
    private String name;
}