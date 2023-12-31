package com.online.shopping_back.dto.request.buyProduct;


import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PatchBuyProductRequestDto {

    @NotNull
    private int buyProductNumber;
    
    @NotNull
    private int productPrice;
}
