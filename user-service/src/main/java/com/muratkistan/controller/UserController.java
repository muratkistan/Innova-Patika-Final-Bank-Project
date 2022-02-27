package com.muratkistan.controller;

import com.muratkistan.dto.UserDto;
import com.muratkistan.service.abstracts.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
@Log4j2
public class UserController {

    private final UserService userService;


    //GET ALL
    @GetMapping("getAll")
    public ResponseEntity<List<UserDto>> getAllUsers(){
        return ResponseEntity.ok(userService.getAllUsers());

    }

    //ADD
    @PostMapping("/add")
    public ResponseEntity<UserDto> addUser(@Valid @RequestBody UserDto userdto){
        return ResponseEntity.ok(userService.addUser(userdto));
    }

    //GET By ID
    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable(name = "id") Long id){
        return ResponseEntity.ok(userService.getUserById(id));
    }

    //CHECK USER EXITS IN DB
    @GetMapping("/exists/{identityNumber}")
    public Boolean isUserExistsByIdentityNumber(@PathVariable(name = "identityNumber") String identityNumber){
        return userService.isUserExistsByIdentityNumber(identityNumber);
    }

    //UPDATE
    @PutMapping("/update/{id}")
    public ResponseEntity<UserDto> updateUser(@PathVariable Long id, @RequestBody UserDto userDto){
        return ResponseEntity.ok(userService.updateUser(id,userDto));
    }

    //DELETE
    @DeleteMapping("/delete/{id}")
    public UserDto deleteUser(@PathVariable Long id){
        return userService.deleteUser(id);
    }




}
