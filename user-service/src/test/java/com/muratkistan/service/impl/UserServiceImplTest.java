package com.muratkistan.service.impl;

import com.muratkistan.dto.UserDto;
import com.muratkistan.model.User;
import com.muratkistan.repository.UserRepository;
import org.junit.Assert;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;


import java.util.ArrayList;

import java.util.List;



import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
class UserServiceImplTest  extends  TestSupport{

    @Mock
    private  UserRepository userRepository;

    @Mock
    private  ModelMapper modelMapper;


    @InjectMocks
    private UserServiceImpl userService;



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











}