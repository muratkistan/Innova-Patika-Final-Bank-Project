package com.muratkistan.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDto {

    private Long id;


    private String identityNumber;


    private String firstName;


    private String lastName;


    private double monthlySalary;


    private String phoneNumber;
}
