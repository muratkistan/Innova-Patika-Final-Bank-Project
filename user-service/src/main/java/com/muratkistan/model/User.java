package com.muratkistan.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Log4j2
@Builder
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @Override
    public String toString() {
        return "User{" +
                " identityNumber='" + identityNumber + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", monthlySalary=" + monthlySalary +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
