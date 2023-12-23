package com.online.shopping_back.service;

import org.springframework.http.ResponseEntity;

import com.online.shopping_back.dto.request.product.PatchProductRequestDto;
import com.online.shopping_back.dto.request.product.PostProductRequestDto;
import com.online.shopping_back.dto.response.product.DeleteProductResponseDto;
import com.online.shopping_back.dto.response.product.PatchProductResponseDto;
import com.online.shopping_back.dto.response.product.PostProductResponseDto;

public interface ProductService {

    
    ResponseEntity<? super PostProductResponseDto> postProduct(PostProductRequestDto dto, String managerEmail, Integer userNumber);
    ResponseEntity<? super PatchProductResponseDto> patchProduct(PatchProductRequestDto dto,String managerEmail, Integer userNumber);
    ResponseEntity<? super DeleteProductResponseDto> deleteProduct(String managerEmail, Integer userNumber,Integer productNumber);
} 
