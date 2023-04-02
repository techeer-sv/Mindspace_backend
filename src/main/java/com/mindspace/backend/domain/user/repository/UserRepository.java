package com.mindspace.backend.domain.user.repository;

import com.mindspace.backend.domain.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}