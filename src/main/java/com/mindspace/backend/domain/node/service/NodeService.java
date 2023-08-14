package com.mindspace.backend.domain.node.service;

import com.mindspace.backend.domain.board.repository.BoardRepository;
import com.mindspace.backend.domain.node.dto.NodeInfoResponse;
import com.mindspace.backend.domain.node.dto.NodeLinkDto;
import com.mindspace.backend.domain.node.dto.NodeMapper;
import com.mindspace.backend.domain.node.entity.Link;
import com.mindspace.backend.domain.node.entity.Neo4jNode;
import com.mindspace.backend.domain.node.entity.Node;
import com.mindspace.backend.domain.node.repository.Neo4jNodeRepository;
import com.mindspace.backend.domain.node.repository.NodeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.mindspace.backend.domain.node.dto.NodeInfoResponse;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class NodeService {
    private final NodeRepository NODE_REPOSITORY;
    private final BoardRepository BOARD_REPOSITORY;
    private final Neo4jNodeRepository NEO4J_NODE_REPOSITORY;
    private final NodeMapper NODE_MAPPER;

    public List<Node> getAllNode() {
        return NODE_REPOSITORY.findAll();
    }

    public NodeInfoResponse getNodeInfoWithLinks(int userId) {
        List<Map<String, Object>> nodes = BOARD_REPOSITORY.getNodeListWithWriteStatus(userId);
        List<Link> linksFromNeo4j = NEO4J_NODE_REPOSITORY.findAllLinks();

        List<NodeLinkDto> linkDTOs = linksFromNeo4j.stream()
                .map(NODE_MAPPER::linkToDto)
                .collect(Collectors.toList());

        return NodeInfoResponse.builder()
                .nodes(nodes)
                .links(linkDTOs)
                .build();
    }

}
