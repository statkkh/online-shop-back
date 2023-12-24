package com.online.shopping_back.service;

import org.springframework.http.ResponseEntity;

import com.online.shopping_back.dto.request.order.PatchOrderRequestDto;
import com.online.shopping_back.dto.request.order.PostOrderRequestDto;
import com.online.shopping_back.dto.response.order.PatchOrderResponseDto;
import com.online.shopping_back.dto.response.order.PostOrderResponseDto;

public interface BuyService {
    
    ResponseEntity<? super PostOrderResponseDto> postBuy(PostOrderRequestDto dto,String email,Integer userNumber);
    ResponseEntity<? super PatchOrderResponseDto> patchBuy(PatchOrderRequestDto dto, String email,Integer userNumber);
}
