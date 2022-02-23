package com.muratkistan.service.impl;

import com.muratkistan.exception.NotFoundException;
import com.muratkistan.model.User;
import com.muratkistan.repository.Userrepository;
import com.muratkistan.service.abstracts.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final Userrepository userRepository;

    @Override
    public void addUser(User user) {
        userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> getUserById(Long userId) {
        return Optional.ofNullable(userRepository.findById(userId).orElseThrow(()->new NotFoundException("User ")));
    }

    @Override
    public User updateUser(Long userId, User user) {
        getUserById(userId);
        user.setId(userId);
        return userRepository.save(user);
    }

    @Override
    public boolean deleteUser(Long userId) {
        userRepository.delete(getUserById(userId).get());
        return true;
    }
}
