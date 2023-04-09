package com.mindspace.backend.domain.node.dto;

import com.mindspace.backend.domain.node.entity.Node;
import org.springframework.stereotype.Component;

@Component
public class NodeMapper {
    public Node DtoToEntity(NodeRequestDto nodeRequestDto) {
        return Node.builder()
                .nodeName(nodeRequestDto.getNodeName())
                .title(nodeRequestDto.getTitle())
                .content(nodeRequestDto.getContent())
                .userId(nodeRequestDto.getUserId())
                .build();
    }

    public NodeResponseDto DtoFromEntity(Node node) {
        return NodeResponseDto.builder()
                .id(node.getId())
                .nodeName(node.getNodeName())
                .title(node.getTitle())
                .content(node.getContent())
                .userId(node.getUserId())
                .build();
    }
}
