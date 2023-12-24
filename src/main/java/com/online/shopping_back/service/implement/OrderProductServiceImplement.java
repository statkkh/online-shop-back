package com.online.shopping_back.service.implement;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.online.shopping_back.dto.request.orderProduct.PostOrderProductRequestDto;
import com.online.shopping_back.dto.response.ResponseDto;
import com.online.shopping_back.dto.response.orderProduct.PostOrderProductResponseDto;
import com.online.shopping_back.dto.response.product.PatchProductResponseDto;
import com.online.shopping_back.entity.BuyEntity;
import com.online.shopping_back.entity.OrderProductEntity;
import com.online.shopping_back.entity.ProductEntity;
import com.online.shopping_back.repository.OrderProductRepository;
import com.online.shopping_back.repository.BuyRepository;
import com.online.shopping_back.repository.ProductRepository;
import com.online.shopping_back.repository.UserRepository;
import com.online.shopping_back.service.OrderProductService;

import lombok.RequiredArgsConstructor;


import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderProductServiceImplement implements OrderProductService{
    
    private final UserRepository userRepository;

    private final ProductRepository productRepository;
    
    private final BuyRepository buyRepository;

    private final OrderProductRepository  orderProductRepository;

    @Override
    public ResponseEntity<? super PostOrderProductResponseDto> postOrderProduct(PostOrderProductRequestDto dto,
            String email, Integer userNumber, Integer orderNumber, Integer productNumber) {
        try {
            boolean existedUser = userRepository.existsByEmail(email);
            if(!existedUser) return PostOrderProductResponseDto.notExistUser();

            ProductEntity productEntity = productRepository.findByProductNumber(productNumber);
            if(productEntity == null) return PostOrderProductResponseDto.notExistProduct();

            boolean existedOrder = buyRepository.existsByOrderNumber(orderNumber);
            if(!existedOrder) return PostOrderProductResponseDto.notExistOrder();

            OrderProductEntity orderProductEntity = new OrderProductEntity(dto, userNumber,orderNumber,productNumber);
            orderProductRepository.save(orderProductEntity);

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return PostOrderProductResponseDto.success();
    }

    
}
