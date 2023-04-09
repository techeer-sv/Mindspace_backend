package com.mindspace.backend.domain.node.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.persistence.Column;

@Getter
@Builder
@AllArgsConstructor
public class NodeResponseDto {

    private int id;

    private String nodeName;

    private String title;

    private String content;

    private int userId;
}
