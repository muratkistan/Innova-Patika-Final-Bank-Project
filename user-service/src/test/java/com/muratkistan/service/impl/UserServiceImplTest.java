package com.muratkistan.service.impl;

import com.muratkistan.dto.UserDto;
import com.muratkistan.model.User;
import com.muratkistan.model.mapper.UserMapper;
import com.muratkistan.repository.UserRepository;
import org.junit.Assert;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;


import java.util.ArrayList;

import java.util.List;
import java.util.Optional;


import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
class UserServiceImplTest  extends  TestSupport{

    @Mock
    private  UserRepository userRepository;

    @Mock
    private  ModelMapper modelMapper;


    @InjectMocks
    private UserServiceImpl userService;

    @BeforeEach
    void setup() {
        userService = new UserServiceImpl(userRepository, new ModelMapper());
    }


    @Test
    void addUser(){
        User user = User.builder().id(1L)
                .identityNumber("1111")
                .firstName("firstName")
                .lastName("lastName")
                .monthlySalary(2000).phoneNumber("1111").build();

//        UserDto userDto = modelMapper.map(user,UserDto.class);
        UserDto userDto = UserMapper.entityToDto(user);

        when(userRepository.save(Mockito.any(User.class))).thenReturn(user);

        UserDto userSaved = userService.addUser(userDto);

        Assert.assertEquals(userSaved.getIdentityNumber(),user.getIdentityNumber());
        Assert.assertEquals(userSaved.getId(),user.getId());

    }

    @Test
    void getAllUsers(){
        User user1 = new User(1L, "Identity1", "FirstName1", "LastName1", 2000,"123");
        User user2 = new User(2L, "Identity2", "FirstName2", "LastName2", 3000, "124");

        List<User> users= new ArrayList<>();

        users.add(user1);
        users.add(user2);

        Mockito.when(userRepository.findAll()).thenReturn(users);

        List<UserDto> allUserDtos = userService.getAllUsers();

        Assert.assertEquals(users.size(),allUserDtos.size());
        verify(userRepository).findAll();
    }


    @Test
    void deleteUser(){
        User user1 = new User(1L, "Identity1", "FirstName1", "LastName1", 2000,"123");

        userRepository.delete(user1);

        verify(userRepository,Mockito.times(1)).delete(user1);

    }
    @Test
    void getUserById(){

        User user = User.builder().id(1L)
                .identityNumber("1111")
                .firstName("firstName")
                .lastName("lastName")
                .monthlySalary(2000).phoneNumber("1111").build();



        when(userRepository.findById(1L)).thenReturn(Optional.of(user));

        UserDto userDto  = userService.getUserById(1L);

        Assert.assertEquals(userDto.getIdentityNumber(),user.getIdentityNumber());

    }













}