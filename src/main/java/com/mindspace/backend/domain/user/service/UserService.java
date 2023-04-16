package com.mindspace.backend.domain.user.service;

import com.mindspace.backend.domain.user.dto.UserLoginRequestDto;
import com.mindspace.backend.domain.user.dto.UserMapper;
import com.mindspace.backend.domain.user.dto.UserSignupRequestDto;
import com.mindspace.backend.domain.user.entity.User;
import com.mindspace.backend.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.hibernate.boot.model.naming.IllegalIdentifierException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository USER_REPOSITORY;
    private final UserMapper USER_MAPPER;

    @Transactional
    public User signupUser(UserSignupRequestDto userSignupRequestDto){
        return USER_REPOSITORY.save(USER_MAPPER.DtoToEntity(userSignupRequestDto));
    };

    @Transactional
    public User loginUser(UserLoginRequestDto userLoginRequestDto) {
        Optional<User> findByEmail = USER_REPOSITORY.findByEmail(userLoginRequestDto.getEmail());
        User user = findByEmail.get();
        //todo : jwt token
        return user;
    }
}
