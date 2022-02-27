package com.muratkistan.service.impl;

import com.muratkistan.dto.UserDto;
import com.muratkistan.model.User;
import org.assertj.core.error.uri.ShouldHaveUserInfo;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TestSupport {

    public static List<User> generateUsers(){
        return IntStream.range(0,5).mapToObj(i ->
             new User((long)i,i+"tc",i+"firstName",i+"lastName",i+1000,i+"phone")
        ).collect(Collectors.toList());

    }

    public static List<UserDto> generateUserDtoList(List<User> userList){
        return userList.stream()
                .map(from -> new UserDto(from.getId(),from.getIdentityNumber(),from.getFirstName(),from.getLastName(),from.getMonthlySalary(),from.getPhoneNumber()))
                .collect(Collectors.toList());
    }
}
