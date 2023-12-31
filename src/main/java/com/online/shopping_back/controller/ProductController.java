package com.online.shopping_back.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.DeleteMapping;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.online.shopping_back.dto.request.product.PatchProductRequestDto;
import com.online.shopping_back.dto.request.product.PostProductRequestDto;

import com.online.shopping_back.dto.response.product.GetProductListResponseDto; 
import com.online.shopping_back.dto.response.product.PostProductResponseDto;
import com.online.shopping_back.dto.response.product.PatchProductResponseDto;
import com.online.shopping_back.dto.response.product.DeleteProductResponseDto;

import com.online.shopping_back.service.ProductService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
public class ProductController {
    
    private final ProductService productService;


    @GetMapping("/{userNumber}")
    ResponseEntity<? super GetProductListResponseDto> getProductList(
        @AuthenticationPrincipal String managerEmail,
        @PathVariable("userNumber") Integer userNumber
    ){
        ResponseEntity<? super GetProductListResponseDto> response = productService.getProductList(managerEmail, userNumber);
        return response;
    }

    @PostMapping("/{userNumber}")
    public ResponseEntity<? super PostProductResponseDto> postProduct(
        @RequestBody @Valid PostProductRequestDto dto,
        @AuthenticationPrincipal String managerEmail,
        @PathVariable("userNumber") Integer userNumber
    ){
        ResponseEntity<? super PostProductResponseDto>  response = productService.postProduct(dto, managerEmail, userNumber);
        return response;
    }    

    @PatchMapping("/{userNumber}")
    public ResponseEntity<? super PatchProductResponseDto> patchProduct(
        @RequestBody @Valid PatchProductRequestDto dto,
        @AuthenticationPrincipal String managerEmail,
        @PathVariable("userNumber") Integer userNumber        
    ){
        ResponseEntity<? super PatchProductResponseDto> response = productService.patchProduct(dto, managerEmail, userNumber);
        return response;
    }


    @DeleteMapping("/{userNumber}/{productNumber}")
    public ResponseEntity<? super DeleteProductResponseDto> deleteProduct(
        @AuthenticationPrincipal String managerEmail,
        @PathVariable("userNumber") Integer userNumber,
        @PathVariable("userNumber") Integer productNumber
    ){
        ResponseEntity<? super DeleteProductResponseDto> response = productService.deleteProduct(managerEmail, userNumber, productNumber);
        return response;
    }
}
