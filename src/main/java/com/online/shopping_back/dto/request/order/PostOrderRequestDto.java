package com.online.shopping_back.dto.request.order;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PostOrderRequestDto{
    
    @NotBlank
    private String productName;
}
