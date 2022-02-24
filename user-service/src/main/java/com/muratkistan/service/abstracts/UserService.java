package com.muratkistan.service.abstracts;

import com.muratkistan.dto.UserDto;
import com.muratkistan.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    UserDto addUser(UserDto userDto);
    List<UserDto> getAllUsers();
    UserDto getUserById(Long userId);
    UserDto updateUser(Long userId,UserDto userDto);
    Boolean deleteUser(Long id);
}
