package com.muratkistan.service.abstracts;

import com.muratkistan.dto.UserDto;

import java.util.List;

public interface UserService {

    UserDto addUser(UserDto userDto);
    List<UserDto> getAllUsers();
    UserDto getUserById(Long userId);
    UserDto updateUser(Long userId,UserDto userDto);
    Boolean deleteUser(Long id);
}
