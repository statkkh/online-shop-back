package com.online.shopping_back.dto.request.buy;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PatchBuyRequestDto {
    
    @NotNull
    private int buyNumber;    
    
    @NotBlank
    private String productName;
}
