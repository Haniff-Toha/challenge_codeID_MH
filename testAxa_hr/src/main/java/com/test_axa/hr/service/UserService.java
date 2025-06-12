package com.test_axa.hr.service;

import java.util.List;

import com.test_axa.hr.model.dto.UserDto;

public interface UserService {
    UserDto createUser(UserDto dto);
    UserDto getUserById(Long id);
    List<UserDto> getAllUsers();
    UserDto updateUser(Long id, UserDto dto);
    void deleteUser(Long id);
}

