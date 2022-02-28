package com.muratkistan.service.impl;


import com.muratkistan.dto.UserDto;
import com.muratkistan.model.User;
import com.muratkistan.repository.UserRepository;
import com.muratkistan.service.abstracts.UserService;
import com.muratkistan.util.NotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
@Log4j2
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    // ADD USER
    @Override
    public UserDto addUser(UserDto userDto) {
        User user = modelMapper.map(userDto,User.class);
        log.info(user  + " adding to DB");
        return modelMapper.map(userRepository.save(user),UserDto.class);
    }

    //LIST ALL USERS
    @Override
    public List<UserDto> getAllUsers() {
        log.info("get all users from DB");
        List<User> users = userRepository.findAll();
        return users.stream()
                .map(user -> modelMapper.map(user,UserDto.class))
                .collect(Collectors.toList());
    }

    // GET ONE USER BY ID
    @Override
    public UserDto getUserById(Long userId) {
        log.info("Get one user from Db -> id: "+userId);
        Optional<User> user = userRepository.findById(userId);
        return user.map(value -> modelMapper.map(value, UserDto.class))
                .orElseThrow(() ->new NotFoundException("User"));

    }

    //UPDATE USER
    @Override
    public UserDto updateUser(Long userId, UserDto userDto) {
        getUserById(userId);
        userDto.setId(userId);
        log.info("Update user -> id: "+userId + " and "+ userDto);
        return modelMapper.map(userRepository.save(modelMapper.map(userDto,User.class)),UserDto.class);
    }

    // DELETE USER
    @Override
    public UserDto deleteUser(Long userId) {
        log.info("Deleted user ->  id: "+userId );
        Optional<User> user = userRepository.findById(userId);
        userRepository.delete(user.get());
        return modelMapper.map(user.get(),UserDto.class);

    }

    //IS USER EXISTS
    @Override
    public Boolean isUserExistsByIdentityNumber(String identityNumber) {
        return userRepository.existsByIdentityNumber(identityNumber);
    }
}
