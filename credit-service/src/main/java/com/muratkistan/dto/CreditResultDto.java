package com.muratkistan.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreditResultDto {
    private boolean status;
    private String identityNumber;
    private int creditScore;
    private double creditLimit;

    public CreditResultDto(boolean status) {
        this.status = status;
    }
}
