package com.mindspace.backend.domain.node.service;

import com.mindspace.backend.domain.node.entity.Node;
import com.mindspace.backend.domain.node.repository.NodeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NodeService {
    private final NodeRepository NODE_REPOSITORY;
    public List<Node> getAllNode(){
        return NODE_REPOSITORY.findAll();
    }
}
