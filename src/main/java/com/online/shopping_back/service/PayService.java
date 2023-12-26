package com.online.shopping_back.service;

import org.springframework.http.ResponseEntity;

import com.online.shopping_back.dto.request.pay.PatchPayRequestDto;
import com.online.shopping_back.dto.request.pay.PostPayRequestDto;
import com.online.shopping_back.dto.response.pay.PatchPayResponseDto;
import com.online.shopping_back.dto.response.pay.PostPayResponseDto;

public interface PayService {
    
    ResponseEntity<? super  PostPayResponseDto> postPay(PostPayRequestDto dto,String email,Integer userNumber, Integer orderNumber);
    ResponseEntity<? super PatchPayResponseDto> patchPay(PatchPayRequestDto dto, String email,Integer userNumber, Integer orderNumber);        
}
