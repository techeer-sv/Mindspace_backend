package com.mindspace.backend.domain.user.entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserEntityTest {
    @Test
    public void testGetters() {
        User user = User.builder()
                .id(1)
                .email("test@test.com")
                .password("password")
                .nickname("Test")
                .build();

        assertEquals(1, user.getId());
        assertEquals("test@test.com", user.getEmail());
        assertEquals("password", user.getPassword());
        assertEquals("Test", user.getNickname());
    }

}