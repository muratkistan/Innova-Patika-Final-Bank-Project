package com.muratkistan.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.index.Indexed;


import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreditScoreDto {

    private String id;

    @NotNull
    @Indexed(unique=true)
    private String identityNumber;

    @NotNull
    private int creditScore;

    public CreditScoreDto(int creditScore) {
        this.creditScore = creditScore;
    }

    public CreditScoreDto(String identityNumber, int creditScore) {
        this.identityNumber = identityNumber;
        this.creditScore = creditScore;
    }
}
