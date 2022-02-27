package com.muratkistan.service.impl;

import com.muratkistan.dto.UserDto;
import com.muratkistan.model.User;
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
import org.reactivestreams.Publisher;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static reactor.core.publisher.Mono.when;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest  extends  TestSupport{

    @Mock
    private  UserRepository userRepository;

    @Mock
    private  ModelMapper modelMapper;


    @InjectMocks
    private UserServiceImpl userService;

    @Test
    void getAllPassengers() {
        // init step
        UserDto user1 = new UserDto(1L, "Identity1", "FirstName1", "LastName1", 2000,"123");
        UserDto user2 = new UserDto(2L, "Identity2", "FirstName2", "LastName2", 3000, "124");
        List<UserDto> userDtos = new ArrayList<>();
        userDtos.add(user1);
        userDtos.add(user2);

        // stub - when
        when((Publisher<?>) userRepository.findAll().stream().map(user -> modelMapper.map(user,UserDto.class)).collect(Collectors.toList())).thenReturn(userDtos);

        // then
        List<UserDto> allUsers = userService.getAllUsers();

        Assert.assertEquals(userDtos.size(), allUsers.size());
    }

//    @BeforeEach
//    public void setUp(){
//        repository = mock(UserRepository.class);
//        modelMapper = mock(ModelMapper.class);
//
//        userService = new UserServiceImpl(repository,modelMapper);
//    }
//
//    @Test
//    public void testGetAllUsers_itShouldReturnUserDtoList(){
//        List<User>  userList = generateUsers();
//        Mockito.when(repository.findAll()).thenReturn(userList);
//        Mockito.when()
//
//    }


//    @Test
//    void getAllUsers(){
//        List<UserDto> expectedUsers = Arrays.asList(
//                UserDto.builder().id(1L).identityNumber("11111111111").firstName("Mehmet").lastName("Yesil").phoneNumber("11111111111").build(),
//                UserDto.builder().id(2L).identityNumber("22222222222").firstName("Ahmet").lastName("Yalcin").phoneNumber("22222222222").build(),
//                UserDto.builder().id(3L).identityNumber("33333333333").firstName("Osman").lastName("Yaman").phoneNumber("33333333333").build()
//        );
//
////        stub - when
//        when((Publisher<User>) userRepository.findAll()).thenReturn(expectedUsers);
//
////        then
//        List<UserDto> allUsers = userService.getAllUsers();
//
//        assertEquals(expectedUsers.size(), allUsers.size());
//        for(UserDto expected : expectedUsers){
//            Optional<UserDto> actual = allUsers.stream()
//                    .filter(userDto -> userDto.getId() == expected.getId()).findFirst();
//            assertEquals(expected.getFirstName(), actual.get().getFirstName());
//            assertEquals(expected.getIdentityNumber(), actual.get().getIdentityNumber());
//        }
//    }



}