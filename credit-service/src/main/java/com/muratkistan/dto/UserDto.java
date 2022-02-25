package com.muratkistan.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDto {

    private Long id;


    @NotNull
    private String identityNumber;


    @NotNull
    private String firstName;


    @NotNull
    private String lastName;


    @NotNull
    private double monthlySalary;


    @NotNull
    private String phoneNumber;
}
