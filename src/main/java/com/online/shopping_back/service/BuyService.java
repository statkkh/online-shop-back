package com.online.shopping_back.service;

import org.springframework.http.ResponseEntity;

import com.online.shopping_back.dto.request.buy.PatchBuyRequestDto;
import com.online.shopping_back.dto.request.buy.PostBuyRequestDto;
import com.online.shopping_back.dto.response.buy.DeleteBuyResponseDto;
import com.online.shopping_back.dto.response.buy.GetBuyResponseDto;
import com.online.shopping_back.dto.response.buy.PatchBuyResponseDto;
import com.online.shopping_back.dto.response.buy.PostBuyResponseDto;

public interface BuyService {

    ResponseEntity<? super PostBuyResponseDto> postBuy(PostBuyRequestDto dto,String email,Integer userNumber);
    ResponseEntity<? super PatchBuyResponseDto> patchBuy(PatchBuyRequestDto dto, String email,Integer userNumber);
    ResponseEntity<? super DeleteBuyResponseDto> deleteBuy( String email,Integer userNumber, Integer buyNumber);
}
