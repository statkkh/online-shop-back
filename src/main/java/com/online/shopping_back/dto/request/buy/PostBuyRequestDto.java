package com.online.shopping_back.dto.request.buy;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PostBuyRequestDto{
    
    @NotBlank
    private String productName;
}
