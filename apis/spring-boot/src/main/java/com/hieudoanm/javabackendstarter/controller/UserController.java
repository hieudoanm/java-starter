package com.hieudoanm.javabackendstarter.controller;

import com.hieudoanm.javabackendstarter.dto.user.UserDto;
import com.hieudoanm.javabackendstarter.dto.user.UserRequestDto;
import com.hieudoanm.javabackendstarter.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/users", produces = APPLICATION_JSON_VALUE)
public class UserController {
    private final UserService userService;

    @GetMapping
    public List<UserDto> getUsers() {
        return userService.getUsers();
    }

    @PostMapping
    public UserDto createUser(@Validated @RequestBody UserRequestDto userRequest) {
        return userService.createUser(userRequest);
    }

    @GetMapping("/{id}")
    public UserDto getUser(
            @PathVariable(value = "id") String id
    ) {
        return userService.getUser(id);
    }

    @PutMapping("/{id}")
    public UserDto updateUser(
            @PathVariable(value = "id") String id,
            @Validated @RequestBody UserRequestDto userRequest
    ) throws Exception {
        return userService.updateUser(id, userRequest);
    }

    @PatchMapping("/{id}")
    public UserDto patchUser(
            @PathVariable(value = "id") String id,
            @Validated @RequestBody UserRequestDto userRequest
    ) throws Exception {
        return userService.updateUser(id, userRequest);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(
            @PathVariable(value = "id") String id
    ) {
        userService.deleteUser(id);
    }
}
