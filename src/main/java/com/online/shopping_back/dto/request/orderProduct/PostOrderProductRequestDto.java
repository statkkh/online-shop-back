package com.online.shopping_back.dto.request.orderProduct;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PostOrderProductRequestDto {
    
    @NotBlank
    private String productName;

    @NotNull
    private int productPrice;
}
