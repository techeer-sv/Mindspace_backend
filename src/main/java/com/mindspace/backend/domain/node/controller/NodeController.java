package com.mindspace.backend.domain.node.controller;

import com.mindspace.backend.domain.board.service.BoardService;
import com.mindspace.backend.domain.node.dto.NodeInfoResponse;
import com.mindspace.backend.domain.node.entity.Neo4jNode;
import com.mindspace.backend.domain.node.entity.Node;
import com.mindspace.backend.domain.node.service.NodeService;
import com.mindspace.backend.domain.user.dto.UserMapper;
import com.mindspace.backend.domain.user.entity.User;
import com.mindspace.backend.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

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
