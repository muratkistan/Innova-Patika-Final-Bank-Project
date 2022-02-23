package com.muratkistan.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDto {

    private Long id;

    @Column(name = "identity_number",unique = true)
    @NotNull
    private String identityNumber;

    @Column(name = "first_name")
    @NotNull
    private String firstName;

    @Column(name="last_name")
    @NotNull
    private String lastName;

    @Column(name = "monthly_salary")
    @NotNull
    private double monthlySalary;

    @Column(name = "phone_number",unique = true)
    @NotNull
    private String phoneNumber;
}
