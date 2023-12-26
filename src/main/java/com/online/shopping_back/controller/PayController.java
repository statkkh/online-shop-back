package com.online.shopping_back.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.DeleteMapping;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.online.shopping_back.dto.request.pay.PatchPayRequestDto;
import com.online.shopping_back.dto.request.pay.PostPayRequestDto;
import com.online.shopping_back.dto.response.pay.PatchPayResponseDto;
import com.online.shopping_back.dto.response.pay.PostPayResponseDto;
import com.online.shopping_back.service.PayService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/pay")
@RequiredArgsConstructor
public class PayController {
    
    private final PayService payService;

    @PostMapping("/{userNumber}/{orderNumber}")
    public ResponseEntity<? super  PostPayResponseDto> postPay(
        @RequestBody @Valid PostPayRequestDto dto,
        @AuthenticationPrincipal String email,
        @PathVariable("userNumber") Integer userNumber,
        @PathVariable("orderNumber") Integer orderNumber
    ){
        ResponseEntity<? super  PostPayResponseDto>  response = payService.postPay(dto, email, userNumber, orderNumber);
        return response;
    }

    @PatchMapping("/{userNumber}/{orderNumber}")
    public ResponseEntity<? super PatchPayResponseDto> patchPay(
        @RequestBody @Valid PatchPayRequestDto dto,
        @AuthenticationPrincipal String email,
        @PathVariable("userNumber") Integer userNumber,
        @PathVariable("orderNumber") Integer orderNumber        
    ){
        ResponseEntity<? super PatchPayResponseDto> response = payService.patchPay(dto, email, userNumber, orderNumber);
        return response;
    }


}
