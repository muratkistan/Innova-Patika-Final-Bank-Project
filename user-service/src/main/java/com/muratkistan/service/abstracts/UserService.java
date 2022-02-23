package com.muratkistan.service.abstracts;

import com.muratkistan.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    void addUser(User user);
    List<User> getAllUsers();
    Optional<User> getUserById(Long userId);
    User updateUser(Long userId,User user);
    boolean deleteUser(Long id);
}
