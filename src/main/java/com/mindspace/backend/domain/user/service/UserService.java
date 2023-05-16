package com.mindspace.backend.domain.user.service;

import com.mindspace.backend.domain.user.dto.UserLoginRequestDto;
import com.mindspace.backend.domain.user.dto.UserMapper;
import com.mindspace.backend.domain.user.dto.UserSignupRequestDto;
import com.mindspace.backend.domain.user.entity.User;
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
        return USER_REPOSITORY.save(USER_MAPPER.DtoToEntity(userSignupRequestDto));
    };

    @Transactional
    public User loginUser(UserLoginRequestDto userLoginRequestDto) {
        Optional<User> findByEmail = USER_REPOSITORY.findByEmail(userLoginRequestDto.getEmail());

        if (findByEmail.isEmpty()) {
            throw new NullPointerException("해당 이메일로 가입한 사용자 없음");
        }

        User user = findByEmail.get();
        if (!user.getPassword().equals(userLoginRequestDto.getPassword())) {
            throw new NullPointerException("비밀번호 오류");
        }

        //todo : jwt token
        return user;
    }

    public List<User> getAllUser() {
        return USER_REPOSITORY.findAll();
    }

    public String getUserNickname(int id) {
        Optional<User> findById = USER_REPOSITORY.findById(id);
        User user = findById.get();
        return user.getNickname();
    }
}
