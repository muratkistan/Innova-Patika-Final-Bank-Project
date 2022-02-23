package com.muratkistan.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(collection = "credits")
public class Credit {

    private String id;

    @NotNull
    @Indexed(unique=true)
    private String identityNumber;

    @NotNull
    private double creditLimit;
}
