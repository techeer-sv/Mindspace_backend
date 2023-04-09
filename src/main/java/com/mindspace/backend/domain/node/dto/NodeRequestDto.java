package com.mindspace.backend.domain.node.dto;

import com.sun.istack.NotNull;
import lombok.Builder;
import lombok.Getter;

import javax.persistence.Column;

@Getter
@Builder
public class NodeRequestDto {

    @NotNull
    private String nodeName;

    @NotNull
    private String title;

    @NotNull
    private String content;

    @NotNull
    private int userId;
}
