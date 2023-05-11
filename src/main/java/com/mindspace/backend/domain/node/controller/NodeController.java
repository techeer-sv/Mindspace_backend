package com.mindspace.backend.domain.node.controller;

import com.mindspace.backend.domain.node.entity.Node;
import com.mindspace.backend.domain.node.service.NodeService;
import com.mindspace.backend.domain.user.dto.UserMapper;
import com.mindspace.backend.domain.user.entity.User;
import com.mindspace.backend.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/node")
public class NodeController {
    private final NodeService NODE_SERVICE;

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<Node> getAllNode(){
        return NODE_SERVICE.getAllNode();
    }
}
