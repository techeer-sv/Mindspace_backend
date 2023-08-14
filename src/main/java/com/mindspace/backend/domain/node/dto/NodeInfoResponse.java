package com.mindspace.backend.domain.node.dto;

import com.mindspace.backend.domain.node.entity.Node;
import com.mindspace.backend.domain.node.entity.Link;

import java.util.List;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class NodeInfoResponse {
    private List<Map<String, Object>> nodes;
    private List<Link> links;
}
