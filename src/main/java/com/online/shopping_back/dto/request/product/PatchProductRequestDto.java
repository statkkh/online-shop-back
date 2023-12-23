package com.online.shopping_back.dto.request.product;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
public class PatchProductRequestDto {

    @NotNull
    private int productNumber;

    @NotBlank
    private String productName;

    @NotNull
    private int price;    
}
