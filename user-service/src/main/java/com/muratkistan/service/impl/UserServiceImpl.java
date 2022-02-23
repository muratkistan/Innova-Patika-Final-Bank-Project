package com.muratkistan.service.impl;

import com.muratkistan.exception.NotFoundException;
import com.muratkistan.model.User;
import com.muratkistan.repository.Userrepository;
import com.muratkistan.service.abstracts.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
@Log4j2
public class UserServiceImpl implements UserService {

    private final Userrepository userRepository;

    @Override
    public void addUser(User user) {
        log.info(user  + " adding to DB");
        userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        log.info("get all users from DB");
        return userRepository.findAll();
    }

    @Override
    public Optional<User> getUserById(Long userId) {
        log.info("Get one user from Db -> id: "+userId);
        return Optional.ofNullable(userRepository.findById(userId).orElseThrow(()->new NotFoundException("User ")));
    }

    @Override
    public User updateUser(Long userId, User user) {
        getUserById(userId);
        user.setId(userId);
        log.info("Update user -> id: "+userId + " and "+ user);
        return userRepository.save(user);
    }

    @Override
    public boolean deleteUser(Long userId) {
        userRepository.delete(getUserById(userId).get());
        log.info("Deleted user ->  id: "+userId );

        return true;
    }
}
