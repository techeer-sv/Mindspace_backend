package com.mindspace.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;

@SpringBootApplication
@EnableJpaAuditing
// Spring Boot 어플리케이션에서 Neo4j 데이터베이스에 대한 Spring Data repository support를 활성화
// 어노테이션
@EnableNeo4jRepositories(basePackages = "com.mindspace.backend.domain.node.repository")

public class MindspaceBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(MindspaceBackendApplication.class, args);
	}

}
