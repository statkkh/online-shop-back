package com.online.shopping_back.service;

import org.springframework.http.ResponseEntity;

import com.online.shopping_back.dto.request.orderProduct.PatchOrderProductRequestDto;
import com.online.shopping_back.dto.request.orderProduct.PostOrderProductRequestDto;

import com.online.shopping_back.dto.response.orderProduct.GetOrderProductListResponseDto;
import com.online.shopping_back.dto.response.orderProduct.PostOrderProductResponseDto;
import com.online.shopping_back.dto.response.orderProduct.PatchOrderProductResponseDto;
import com.online.shopping_back.dto.response.orderProduct.DeleteOrderProductResponseDto;

public interface OrderProductService {

    ResponseEntity<? super GetOrderProductListResponseDto> getOrderProductList(String email, Integer userNumber,Integer productNumber, Integer orderNumber); 
    ResponseEntity<? super PostOrderProductResponseDto>postOrderProduct(PostOrderProductRequestDto dto, String email, Integer userNumber, Integer orderNumber,Integer productNumber);
    ResponseEntity<? super PatchOrderProductResponseDto> patchOrderProduct(PatchOrderProductRequestDto dto, String email, Integer userNumber, Integer orderNumber,Integer productNumber);
    ResponseEntity<? super  DeleteOrderProductResponseDto> deleteOrderProduct(String email, Integer userNumber, Integer orderNumber,Integer productNumber,Integer orderProductNumber );
} 