package com.online.shopping_back.dto.request.order;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PatchOrderRequestDto {
    
    @NotNull
    private int orderNumber;    
    
    @NotBlank
    private String productName;
}
