package com.online.shopping_back.controller;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.DeleteMapping;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.online.shopping_back.dto.request.buyProduct.PatchBuyProductRequestDto;
import com.online.shopping_back.dto.request.buyProduct.PostBuyProductRequestDto;
import com.online.shopping_back.dto.response.buyProduct.DeleteBuyProductResponseDto;
import com.online.shopping_back.dto.response.buyProduct.GetBuyProductListResponseDto;
import com.online.shopping_back.dto.response.buyProduct.PatchBuyProductResponseDto;
import com.online.shopping_back.dto.response.buyProduct.PostBuyProductResponseDto;
import com.online.shopping_back.service.BuyProductService;

import jakarta.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;

@RestController
@RequestMapping("/api/order-product")
@RequiredArgsConstructor
public class BuyProductController{
    
    private final BuyProductService orderProductService;

    @GetMapping("/{userNumber}/{productNumber}/{buyNumber}")
    public ResponseEntity< ? super GetBuyProductListResponseDto> getOrderProductList(
        @AuthenticationPrincipal String email,
        @PathVariable("userNumber") Integer userNumber,
        @PathVariable("productNumber") Integer productNumber,
        @PathVariable("buyNumber") Integer buyNumber        
    ){
        ResponseEntity< ? super GetBuyProductListResponseDto>  response = orderProductService.getOrderProductList(email, userNumber, productNumber, buyNumber);
        return response;
    }


    @PostMapping("/{userNumber}/{productNumber}/{buyNumber}")
    public ResponseEntity<? super PostBuyProductResponseDto> postOrderProduct(
        @RequestBody @Valid PostBuyProductRequestDto dto,
        @AuthenticationPrincipal String email,
        @PathVariable("userNumber") Integer userNumber,
        @PathVariable("productNumber") Integer productNumber,
        @PathVariable("buyNumber") Integer buyNumber
    ){
        ResponseEntity<? super PostBuyProductResponseDto>  response = orderProductService.postOrderProduct(dto, email, userNumber, buyNumber, productNumber);
        return response;
    }

    @PatchMapping("/{userNumber}/{productNumber}/{buyNumber}")
    public ResponseEntity<? super PatchBuyProductResponseDto> patchOrderProduct(
        @RequestBody @Valid PatchBuyProductRequestDto dto,
        @AuthenticationPrincipal String email,
        @PathVariable("userNumber") Integer userNumber,
        @PathVariable("productNumber") Integer productNumber,
        @PathVariable("buyNumber") Integer buyNumber        
    ){
        ResponseEntity<? super PatchBuyProductResponseDto>  response = orderProductService.patchOrderProduct(dto, email, userNumber, buyNumber, productNumber);
        return response;
    }   

    @DeleteMapping("/{userNumber}/{productNumber}/{buyNumber}/{buyProductNumber}")
    public ResponseEntity<? super  DeleteBuyProductResponseDto> deleteOrderProduct(
        @AuthenticationPrincipal String email,
        @PathVariable("userNumber") Integer userNumber,
        @PathVariable("productNumber") Integer productNumber,
        @PathVariable("buyNumber") Integer buyNumber,
        @PathVariable("buyProductNumber") Integer buyProductNumber    
    ){
        ResponseEntity<? super  DeleteBuyProductResponseDto> response = orderProductService.deleteOrderProduct(email, userNumber, buyNumber, productNumber, buyProductNumber);
        return response;
    }

}
