package com.online.shopping_back.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.DeleteMapping;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.online.shopping_back.dto.request.order.PostOrderRequestDto;
import com.online.shopping_back.dto.response.order.PostOrderResponseDto;
import com.online.shopping_back.service.BuyService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/buy")
@RequiredArgsConstructor
public class BuyController {
    
    private final BuyService  buyService;








    @PostMapping("/{userNumber}")
    public ResponseEntity<? super PostOrderResponseDto> postBuy(
        @RequestBody @Valid PostOrderRequestDto dto,
        @AuthenticationPrincipal String managerEmail,
        @PathVariable("userNumber") Integer userNumber        
    ){
        ResponseEntity<? super PostOrderResponseDto> response = buyService.postBuy(dto, managerEmail, userNumber);
        return response;
    }








    
}
