package com.hieudoanm.javabackendstarter.service;

import com.hieudoanm.javabackendstarter.dto.user.UserDto;
import com.hieudoanm.javabackendstarter.dto.user.UserRequestDto;
import com.hieudoanm.javabackendstarter.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<UserDto> getUsers() {
        return userRepository.findAll();
    }

    public UserDto createUser(UserRequestDto userRequest) {
        UserDto user = new UserDto();
        String uuid = UUID.randomUUID().toString();
        user.setId(uuid);
        user.setUsername(userRequest.getUsername());
        user.setPassword(userRequest.getPassword());
        return userRepository.save(user);
    }

    public UserDto getUser(String id) {
        return userRepository.findById(id).orElse(null);
    }

    public UserDto updateUser(String id, UserRequestDto userRequest) throws Exception {
        UserDto userDto = userRepository.findById(id).orElse(null);
        if (userDto == null) {
            throw new Exception("Error Message");
        }
        userDto.setUsername(userRequest.getUsername());
        userDto.setPassword(userRequest.getPassword());
        userRepository.save(userDto);
        return userDto;
    }

    public void deleteUser(String id) {
        userRepository.deleteById(id);
    }
}
