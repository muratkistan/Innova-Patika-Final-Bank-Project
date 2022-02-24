package com.muratkistan.service.impl;

import com.muratkistan.dto.UserDto;
import com.muratkistan.exception.NotFoundException;
import com.muratkistan.model.User;
import com.muratkistan.repository.Userrepository;
import com.muratkistan.service.abstracts.UserService;
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

    private final Userrepository userRepository;
    private final ModelMapper modelMapper;

    @Override
    public UserDto addUser(UserDto userDto) {
        User user = modelMapper.map(userDto,User.class);
        log.info(user  + " adding to DB");
        return modelMapper.map(userRepository.save(user),UserDto.class);
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> users = userRepository.findAll();
        List<UserDto> userDtos = users.stream().map(user -> modelMapper.map(user,UserDto.class)).collect(Collectors.toList());
        log.info("get all users from DB");
        return userDtos;
    }

    @Override
    public UserDto getUserById(Long userId) {
        Optional<User> user = userRepository.findById(userId);
        log.info("Get one user from Db -> id: "+userId);
        return user.map(value -> modelMapper.map(value, UserDto.class)).orElseThrow(() ->new NotFoundException("User"));

    }

    @Override
    public UserDto updateUser(Long userId, UserDto userDto) {
        UserDto userDtoDB = getUserById(userId);
        userDto.setId(userId);
        log.info("Update user -> id: "+userId + " and "+ userDto);
        return modelMapper.map(userRepository.save(modelMapper.map(userDto,User.class)),UserDto.class);
    }

    @Override
    public Boolean deleteUser(Long userId) {
        userRepository.delete(modelMapper.map(getUserById(userId),User.class));
        log.info("Deleted user ->  id: "+userId );
        return true;
    }
}
