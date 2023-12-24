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

import com.online.shopping_back.dto.request.orderProduct.PostOrderProductRequestDto;
import com.online.shopping_back.dto.response.orderProduct.PostOrderProductResponseDto;
import com.online.shopping_back.service.OrderProductService;

import jakarta.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;

@RestController
@RequestMapping("/api/order-product")
@RequiredArgsConstructor
public class OrderProductController{
    
    private final OrderProductService orderProductService;

    @PostMapping("/{userNumber}/{productNumber}/{orderNumber}")
    public ResponseEntity<? super PostOrderProductResponseDto> postOrderProduct(
        @RequestBody @Valid PostOrderProductRequestDto dto,
        @AuthenticationPrincipal String email,
        @PathVariable("userNumber") Integer userNumber,
        @PathVariable("productNumber") Integer productNumber,
        @PathVariable("orderNumber") Integer orderNumber
    ){
        ResponseEntity<? super PostOrderProductResponseDto>  response = orderProductService.postOrderProduct(dto, email, userNumber, orderNumber, productNumber);
        return response;
    }

}