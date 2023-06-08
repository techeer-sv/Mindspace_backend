package com.mindspace.backend.domain.user.service;

import com.mindspace.backend.domain.user.dto.UserLoginRequestDto;
import com.mindspace.backend.domain.user.dto.UserMapper;
import com.mindspace.backend.domain.user.dto.UserSignupRequestDto;
import com.mindspace.backend.domain.user.entity.User;
import com.mindspace.backend.domain.user.exception.*;
import com.mindspace.backend.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository USER_REPOSITORY;
    private final UserMapper USER_MAPPER;

    @Transactional
    public User signupUser(UserSignupRequestDto userSignupRequestDto){
        if (USER_REPOSITORY.existsByEmail(userSignupRequestDto.getEmail())) {
            throw new EmailDuplicateException();
        }

        if (USER_REPOSITORY.existsByNickname(userSignupRequestDto.getNickname())) {
            throw new NickNameDuplicateException();
        }

        return USER_REPOSITORY.save(USER_MAPPER.DtoToEntity(userSignupRequestDto));
    };

    @Transactional
    public User loginUser(UserLoginRequestDto userLoginRequestDto) {
        Optional<User> findByEmail = USER_REPOSITORY.findByEmail(userLoginRequestDto.getEmail());

        if (findByEmail.isEmpty()) {
            throw new UserNotFoundException();
        }

        User user = findByEmail.get();
        if (!user.getPassword().equals(userLoginRequestDto.getPassword())) {
            throw new InvalidPasswordException();
        }

        //todo : jwt token
        return user;
    }

    public List<User> getAllUser() {
        return USER_REPOSITORY.findAll();
    }

}
