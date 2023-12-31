package com.online.shopping_back.service;

import org.springframework.http.ResponseEntity;

import com.online.shopping_back.dto.request.buyProduct.PatchBuyProductRequestDto;
import com.online.shopping_back.dto.request.buyProduct.PostBuyProductRequestDto;
import com.online.shopping_back.dto.response.buyProduct.DeleteBuyProductResponseDto;
import com.online.shopping_back.dto.response.buyProduct.GetBuyProductListResponseDto;
import com.online.shopping_back.dto.response.buyProduct.PatchBuyProductResponseDto;
import com.online.shopping_back.dto.response.buyProduct.PostBuyProductResponseDto;

public interface BuyProductService {

    ResponseEntity<? super GetBuyProductListResponseDto> getOrderProductList(String email, Integer userNumber,Integer productNumber, Integer butNumber); 
    ResponseEntity<? super PostBuyProductResponseDto>postOrderProduct(PostBuyProductRequestDto dto, String email, Integer userNumber, Integer butNumber,Integer productNumber);
    ResponseEntity<? super PatchBuyProductResponseDto> patchOrderProduct(PatchBuyProductRequestDto dto, String email, Integer userNumber, Integer butNumber,Integer productNumber);
    ResponseEntity<? super  DeleteBuyProductResponseDto> deleteOrderProduct(String email, Integer userNumber, Integer butNumber,Integer productNumber,Integer buyProductNumber );
} 