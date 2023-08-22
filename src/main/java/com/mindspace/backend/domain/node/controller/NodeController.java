package com.mindspace.backend.domain.node.controller;

import com.mindspace.backend.domain.node.dto.NodeInfoResponse;
import com.mindspace.backend.domain.node.entity.Node;
import com.mindspace.backend.domain.node.service.NodeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/node")
public class NodeController {
    private final NodeService NODE_SERVICE;

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<Node> getAllNode() {
        return NODE_SERVICE.getAllNode();
    }

    @GetMapping("/check")
    @ResponseStatus(HttpStatus.OK)
    public NodeInfoResponse getNodeInfoWithLinks(@RequestHeader("Authorization") int userId) {
        return NODE_SERVICE.getNodeInfoWithLinks(userId);
    }
}
