package com.mindspace.backend.domain.link.repository;

import com.mindspace.backend.domain.link.entity.Link;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LinkRepository extends JpaRepository<Link, Integer> {
}
