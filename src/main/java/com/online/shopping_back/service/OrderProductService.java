package com.online.shopping_back.service;

import org.springframework.http.ResponseEntity;

import com.online.shopping_back.dto.request.orderProduct.PostOrderProductRequestDto;
import com.online.shopping_back.dto.response.orderProduct.PostOrderProductResponseDto;

public interface OrderProductService {

    
    ResponseEntity<? super PostOrderProductResponseDto>postOrderProduct(PostOrderProductRequestDto dto, String email, Integer userNumber, Integer orderNumber,Integer productNumber);


} 