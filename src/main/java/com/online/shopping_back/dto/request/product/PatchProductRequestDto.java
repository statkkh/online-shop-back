package com.online.shopping_back.dto.request.product;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.validation.constraints.NotBlank;

@Getter
@Setter
@NoArgsConstructor
public class PatchProductRequestDto {
    
    @NotBlank
    private String productName;

    @NotBlank
    private int price;    
}
