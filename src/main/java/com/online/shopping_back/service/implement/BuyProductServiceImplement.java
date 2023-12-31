package com.online.shopping_back.service.implement;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.online.shopping_back.dto.request.buyProduct.PatchBuyProductRequestDto;
import com.online.shopping_back.dto.request.buyProduct.PostBuyProductRequestDto;
import com.online.shopping_back.dto.response.ResponseDto;
import com.online.shopping_back.dto.response.buyProduct.DeleteOrderProductResponseDto;
import com.online.shopping_back.dto.response.buyProduct.GetOrderProductListResponseDto;
import com.online.shopping_back.dto.response.buyProduct.PatchOrderProductResponseDto;
import com.online.shopping_back.dto.response.buyProduct.PostOrderProductResponseDto;
import com.online.shopping_back.entity.BuyProductEntity;
import com.online.shopping_back.entity.ProductEntity;
import com.online.shopping_back.repository.BuyProductRepository;
import com.online.shopping_back.repository.BuyRepository;
import com.online.shopping_back.repository.ProductRepository;
import com.online.shopping_back.repository.UserRepository;
import com.online.shopping_back.service.BuyProductService;

import lombok.RequiredArgsConstructor;


import java.util.List;

@Service
@RequiredArgsConstructor
public class BuyProductServiceImplement implements BuyProductService{
    
    private final UserRepository userRepository;

    private final ProductRepository productRepository;
    
    private final BuyRepository buyRepository;

    private final BuyProductRepository  orderProductRepository;

    @Override
    public ResponseEntity<? super GetOrderProductListResponseDto> getOrderProductList(String email, Integer userNumber,
            Integer productNumber,Integer buyNumber ) {

        List<BuyProductEntity> orderProductEntities = null;

        try {

            boolean existedUser = userRepository.existsByEmail(email);
            if(!existedUser) return PostOrderProductResponseDto.notExistUser();

            ProductEntity productEntity = productRepository.findByProductNumber(productNumber);
            if(productEntity == null) return PostOrderProductResponseDto.notExistProduct();

            boolean existedOrder = buyRepository.existsByBuyNumber(buyNumber);
            if(!existedOrder) return PostOrderProductResponseDto.notExistOrder();

            orderProductEntities = orderProductRepository.findByUserNumber(userNumber);

            
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return GetOrderProductListResponseDto.success(orderProductEntities);
    }

    @Override
    public ResponseEntity<? super PostOrderProductResponseDto> postOrderProduct(PostBuyProductRequestDto dto,
            String email, Integer userNumber, Integer buyNumber, Integer productNumber) {
        try {
            boolean existedUser = userRepository.existsByEmail(email);
            if(!existedUser) return PostOrderProductResponseDto.notExistUser();

            ProductEntity productEntity = productRepository.findByProductNumber(productNumber);
            if(productEntity == null) return PostOrderProductResponseDto.notExistProduct();

            boolean existedOrder = buyRepository.existsByBuyNumber(buyNumber);
            if(!existedOrder) return PostOrderProductResponseDto.notExistOrder();

            BuyProductEntity orderProductEntity = new BuyProductEntity(dto, userNumber,buyNumber,productNumber);
            orderProductRepository.save(orderProductEntity);

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return PostOrderProductResponseDto.success();
    }

    @Override
    public ResponseEntity<? super PatchOrderProductResponseDto> patchOrderProduct(PatchBuyProductRequestDto dto,
            String email, Integer userNumber, Integer buyNumber, Integer productNumber) {
        
        try {
            boolean existedUser = userRepository.existsByEmail(email);
            if(!existedUser) return PatchOrderProductResponseDto.notExistUser();

            ProductEntity productEntity = productRepository.findByProductNumber(productNumber);
            if(productEntity == null) return PatchOrderProductResponseDto.notExistProduct();

            boolean existedOrder = buyRepository.existsByBuyNumber(buyNumber);
            if(!existedOrder) return PatchOrderProductResponseDto.notExistOrder();

            BuyProductEntity orderProductEntity = orderProductRepository.findBybuyProductNumber(dto.getBuyProductNumber());
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
            Integer buyNumber, Integer productNumber, Integer buyProductNumber) {
        
        try {

            boolean existedUser = userRepository.existsByEmail(email);
            if(!existedUser) return DeleteOrderProductResponseDto.notExistUser();

            ProductEntity productEntity = productRepository.findByProductNumber(productNumber);
            if(productEntity == null) return DeleteOrderProductResponseDto.notExistProduct();

            boolean existedOrder = buyRepository.existsByBuyNumber(buyNumber);
            if(!existedOrder) return DeleteOrderProductResponseDto.notExistOrder();       
            
            BuyProductEntity orderProductEntity = orderProductRepository.findBybuyProductNumber(buyProductNumber);
            if(orderProductEntity == null) return DeleteOrderProductResponseDto.notExistOrderProduct();

            orderProductRepository.delete(orderProductEntity);

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return DeleteOrderProductResponseDto.success();
    }



    
}
