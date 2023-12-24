package com.online.shopping_back.service.implement;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.online.shopping_back.dto.response.ResponseDto;

import com.online.shopping_back.dto.request.orderProduct.PatchOrderProductRequestDto;
import com.online.shopping_back.dto.request.orderProduct.PostOrderProductRequestDto;
import com.online.shopping_back.dto.response.orderProduct.DeleteOrderProductResponseDto;
import com.online.shopping_back.dto.response.orderProduct.GetOrderProductListResponseDto;
import com.online.shopping_back.dto.response.orderProduct.PatchOrderProductResponseDto;
import com.online.shopping_back.dto.response.orderProduct.PostOrderProductResponseDto;

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
    public ResponseEntity<? super GetOrderProductListResponseDto> getOrderProductList(String email, Integer userNumber,
            Integer productNumber,Integer orderNumber ) {

        List<OrderProductEntity> orderProductEntities = null;

        try {

            boolean existedUser = userRepository.existsByEmail(email);
            if(!existedUser) return PostOrderProductResponseDto.notExistUser();

            ProductEntity productEntity = productRepository.findByProductNumber(productNumber);
            if(productEntity == null) return PostOrderProductResponseDto.notExistProduct();

            boolean existedOrder = buyRepository.existsByOrderNumber(orderNumber);
            if(!existedOrder) return PostOrderProductResponseDto.notExistOrder();

            orderProductEntities = orderProductRepository.findByUserNumber(userNumber);

            
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return GetOrderProductListResponseDto.success(orderProductEntities);
    }

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

    @Override
    public ResponseEntity<? super PatchOrderProductResponseDto> patchOrderProduct(PatchOrderProductRequestDto dto,
            String email, Integer userNumber, Integer orderNumber, Integer productNumber) {
        
        try {
            boolean existedUser = userRepository.existsByEmail(email);
            if(!existedUser) return PatchOrderProductResponseDto.notExistUser();

            ProductEntity productEntity = productRepository.findByProductNumber(productNumber);
            if(productEntity == null) return PatchOrderProductResponseDto.notExistProduct();

            boolean existedOrder = buyRepository.existsByOrderNumber(orderNumber);
            if(!existedOrder) return PatchOrderProductResponseDto.notExistOrder();

            OrderProductEntity orderProductEntity = orderProductRepository.findByOrderProductNumber(dto.getOrderProductNumber());
            if(orderProductEntity == null) return PatchOrderProductResponseDto.notExistOrderProduct();

            orderProductEntity.patchOrderProduct(dto);
            orderProductRepository.save(orderProductEntity);            

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }        
        return PatchOrderProductResponseDto.success();        
    }

    @Override
    public ResponseEntity<? super DeleteOrderProductResponseDto> deleteOrderProduct(String email, Integer userNumber,
            Integer orderNumber, Integer productNumber, Integer orderProductNumber) {
        
        try {

            boolean existedUser = userRepository.existsByEmail(email);
            if(!existedUser) return DeleteOrderProductResponseDto.notExistUser();

            ProductEntity productEntity = productRepository.findByProductNumber(productNumber);
            if(productEntity == null) return DeleteOrderProductResponseDto.notExistProduct();

            boolean existedOrder = buyRepository.existsByOrderNumber(orderNumber);
            if(!existedOrder) return DeleteOrderProductResponseDto.notExistOrder();       
            
            OrderProductEntity orderProductEntity = orderProductRepository.findByOrderProductNumber(orderProductNumber);
            if(orderProductEntity == null) return DeleteOrderProductResponseDto.notExistOrderProduct();

            orderProductRepository.delete(orderProductEntity);

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return DeleteOrderProductResponseDto.success();
    }



    
}
