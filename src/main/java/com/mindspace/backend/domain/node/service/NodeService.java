package com.mindspace.backend.domain.node.service;

import com.mindspace.backend.domain.board.repository.BoardRepository;
import com.mindspace.backend.domain.node.entity.Node;
import com.mindspace.backend.domain.node.repository.NodeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class NodeService {
    private final NodeRepository NODE_REPOSITORY;
    private final BoardRepository BOARD_REPOSITORY;
    public List<Node> getAllNode(){
        return NODE_REPOSITORY.findAll();
    }

    @Transactional
    public List<Map<String, Object>> hasUserWrittenBoard(int userId) {
        return BOARD_REPOSITORY.getNodeListWithWriteStatus(userId);
    }
}
