package com.muratkistan.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreditScoreDto {
    private String id;
    private String identityNumber;
    private int score=500;

    public CreditScoreDto(String identityNumber, int score) {
        this.identityNumber = identityNumber;
        this.score = score;
    }
}
