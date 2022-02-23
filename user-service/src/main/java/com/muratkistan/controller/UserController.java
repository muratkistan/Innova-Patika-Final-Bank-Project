package com.muratkistan.controller;

import com.muratkistan.dto.UserDto;
import com.muratkistan.model.User;
import com.muratkistan.model.mapper.UserMapper;
import com.muratkistan.service.abstracts.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
@Log4j2
public class UserController {

    private final UserService userService;


    //GET ALL
    @GetMapping("getAll")
    public ResponseEntity<List<UserDto>> getAllUsers(){
        return ResponseEntity.ok(userService.getAllUsers()
                .stream().map(UserMapper::entityToDto).collect(Collectors.toList()));
    }

    //ADD
    @PostMapping("/add")
    public void addUser(@Valid @RequestBody UserDto userdto){
        userService.addUser(UserMapper.dtoToEntity(userdto));
    }

    //GET By ID
    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable(name = "id") Long id){
        User user = userService.getUserById(id).get();
        return ResponseEntity.ok(UserMapper.entityToDto(user));
    }

    //UPDATE
    @PutMapping("/update/{id}")
    public UserDto updateUser(@PathVariable Long id,@Valid @RequestBody UserDto userDto){
        return UserMapper.entityToDto(userService.updateUser(id,UserMapper.dtoToEntity(userDto)));
    }

    //DELETE
    @DeleteMapping("/delete/{id}")
    public boolean deleteUser(@PathVariable Long id){
        return userService.deleteUser(id);
    }

}
