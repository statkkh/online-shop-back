package com.online.shopping_back.service;

import org.springframework.http.ResponseEntity;

import com.online.shopping_back.dto.request.product.PostProductRequestDto;
import com.online.shopping_back.dto.response.product.PostProductResponseDto;

public interface ProductService {

    
    ResponseEntity<? super PostProductResponseDto> postProduct(PostProductRequestDto dto, String managerEmail, Integer userNumber);


} 
