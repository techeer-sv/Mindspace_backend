package com.mindspace.backend.domain.node.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class NodeLinkDto {
    private Long source;
    private Long target;
}
