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

import com.online.shopping_back.dto.request.buy.PatchBuyRequestDto;
import com.online.shopping_back.dto.request.buy.PostBuyRequestDto;
import com.online.shopping_back.dto.response.buy.DeleteBuyResponseDto;
import com.online.shopping_back.dto.response.buy.GetBuyResponseDto;
import com.online.shopping_back.dto.response.buy.PatchBuyResponseDto;
import com.online.shopping_back.dto.response.buy.PostBuyResponseDto;
import com.online.shopping_back.service.BuyService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/buy")
@RequiredArgsConstructor
public class BuyController {
    
    private final BuyService  buyService;





    @PostMapping("/{userNumber}")
    public ResponseEntity<? super PostBuyResponseDto> postBuy(
        @RequestBody @Valid PostBuyRequestDto dto,
        @AuthenticationPrincipal String managerEmail,
        @PathVariable("userNumber") Integer userNumber        
    ){
        ResponseEntity<? super PostBuyResponseDto> response = buyService.postBuy(dto, managerEmail, userNumber);
        return response;
    }


    @PatchMapping("/{userNumber}")
    ResponseEntity<? super PatchBuyResponseDto> patchBuy(
        @RequestBody @Valid PatchBuyRequestDto dto,
        @AuthenticationPrincipal String email,
        @PathVariable("userNumber") Integer userNumber        
    ){
        ResponseEntity<? super PatchBuyResponseDto>  response = buyService.patchBuy(dto, email, userNumber);
        return response;
    }

    @DeleteMapping("/{userNumber}/{buyNumber}")
    public ResponseEntity<? super DeleteBuyResponseDto> deleteBuy(
        @AuthenticationPrincipal String email,
        @PathVariable("userNumber") Integer userNumber,
        @PathVariable("buyNumber") Integer buyNumber         
    ){
        ResponseEntity<? super DeleteBuyResponseDto> response = buyService.deleteBuy(email, userNumber, buyNumber);
        return response;
    }


    
}
