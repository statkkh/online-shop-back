package com.online.shopping_back.service;

import org.springframework.http.ResponseEntity;

import com.online.shopping_back.dto.request.buyProduct.PatchBuyProductRequestDto;
import com.online.shopping_back.dto.request.buyProduct.PostBuyProductRequestDto;
import com.online.shopping_back.dto.response.buyProduct.DeleteOrderProductResponseDto;
import com.online.shopping_back.dto.response.buyProduct.GetOrderProductListResponseDto;
import com.online.shopping_back.dto.response.buyProduct.PatchOrderProductResponseDto;
import com.online.shopping_back.dto.response.buyProduct.PostOrderProductResponseDto;

public interface BuyProductService {

    ResponseEntity<? super GetOrderProductListResponseDto> getOrderProductList(String email, Integer userNumber,Integer productNumber, Integer butNumber); 
    ResponseEntity<? super PostOrderProductResponseDto>postOrderProduct(PostBuyProductRequestDto dto, String email, Integer userNumber, Integer butNumber,Integer productNumber);
    ResponseEntity<? super PatchOrderProductResponseDto> patchOrderProduct(PatchBuyProductRequestDto dto, String email, Integer userNumber, Integer butNumber,Integer productNumber);
    ResponseEntity<? super  DeleteOrderProductResponseDto> deleteOrderProduct(String email, Integer userNumber, Integer butNumber,Integer productNumber,Integer buyProductNumber );
} 