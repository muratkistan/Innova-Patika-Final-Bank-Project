package com.muratkistan.dto;

import com.muratkistan.custom.annotations.UniqueCredit;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreditDto {

    private String id;

    private String identityNumber;

    private double creditLimit;

    private Boolean status;

    public CreditDto(boolean status) {
        this.status = status;
    }
}
