package com.online.shopping_back.dto.request.pay;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
public class PatchPayRequestDto {

    @NotNull    
    private int payNumber;

    @NotNull
    private Boolean  payStatus;
}
