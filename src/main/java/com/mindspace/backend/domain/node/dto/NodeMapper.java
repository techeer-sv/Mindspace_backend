package com.mindspace.backend.domain.node.dto;

import com.mindspace.backend.domain.node.dto.NodeLinkDto;
import com.mindspace.backend.domain.node.entity.Link;
import org.springframework.stereotype.Component;

@Component
public class NodeMapper {

    public NodeLinkDto linkToDto(Link link) {
        return NodeLinkDto.builder()
                .source(link.getSource())
                .target(link.getTarget())
                .build();
    }
}
