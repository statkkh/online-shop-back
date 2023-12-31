package com.online.shopping_back.service.implement;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.online.shopping_back.dto.request.buyProduct.PatchBuyProductRequestDto;
import com.online.shopping_back.dto.request.buyProduct.PostBuyProductRequestDto;
import com.online.shopping_back.dto.response.ResponseDto;
import com.online.shopping_back.dto.response.buyProduct.DeleteBuyProductResponseDto;
import com.online.shopping_back.dto.response.buyProduct.GetBuyProductListResponseDto;
import com.online.shopping_back.dto.response.buyProduct.PatchBuyProductResponseDto;
import com.online.shopping_back.dto.response.buyProduct.PostBuyProductResponseDto;
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
    public ResponseEntity<? super GetBuyProductListResponseDto> getOrderProductList(String email, Integer userNumber,
            Integer productNumber,Integer buyNumber ) {

        List<BuyProductEntity> orderProductEntities = null;

        try {

            boolean existedUser = userRepository.existsByEmail(email);
            if(!existedUser) return PostBuyProductResponseDto.notExistUser();

            ProductEntity productEntity = productRepository.findByProductNumber(productNumber);
            if(productEntity == null) return PostBuyProductResponseDto.notExistProduct();

            boolean existedOrder = buyRepository.existsByBuyNumber(buyNumber);
            if(!existedOrder) return PostBuyProductResponseDto.notExistOrder();

            orderProductEntities = orderProductRepository.findByUserNumber(userNumber);

            
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return GetBuyProductListResponseDto.success(orderProductEntities);
    }

    @Override
    public ResponseEntity<? super PostBuyProductResponseDto> postOrderProduct(PostBuyProductRequestDto dto,
            String email, Integer userNumber, Integer buyNumber, Integer productNumber) {
        try {
            boolean existedUser = userRepository.existsByEmail(email);
            if(!existedUser) return PostBuyProductResponseDto.notExistUser();

            ProductEntity productEntity = productRepository.findByProductNumber(productNumber);
            if(productEntity == null) return PostBuyProductResponseDto.notExistProduct();

            boolean existedOrder = buyRepository.existsByBuyNumber(buyNumber);
            if(!existedOrder) return PostBuyProductResponseDto.notExistOrder();

            BuyProductEntity orderProductEntity = new BuyProductEntity(dto, userNumber,buyNumber,productNumber);
            orderProductRepository.save(orderProductEntity);

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return PostBuyProductResponseDto.success();
    }

    @Override
    public ResponseEntity<? super PatchBuyProductResponseDto> patchOrderProduct(PatchBuyProductRequestDto dto,
            String email, Integer userNumber, Integer buyNumber, Integer productNumber) {
        
        try {
            boolean existedUser = userRepository.existsByEmail(email);
            if(!existedUser) return PatchBuyProductResponseDto.notExistUser();

            ProductEntity productEntity = productRepository.findByProductNumber(productNumber);
            if(productEntity == null) return PatchBuyProductResponseDto.notExistProduct();

            boolean existedOrder = buyRepository.existsByBuyNumber(buyNumber);
            if(!existedOrder) return PatchBuyProductResponseDto.notExistOrder();

            BuyProductEntity orderProductEntity = orderProductRepository.findBybuyProductNumber(dto.getBuyProductNumber());
            if(orderProductEntity == null) return PatchBuyProductResponseDto.notExistOrderProduct();

            orderProductEntity.patchOrderProduct(dto);
            orderProductRepository.save(orderProductEntity);            

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }        
        return PatchBuyProductResponseDto.success();        
    }

    @Override
    public ResponseEntity<? super DeleteBuyProductResponseDto> deleteOrderProduct(String email, Integer userNumber,
            Integer buyNumber, Integer productNumber, Integer buyProductNumber) {
        
        try {

            boolean existedUser = userRepository.existsByEmail(email);
            if(!existedUser) return DeleteBuyProductResponseDto.notExistUser();

            ProductEntity productEntity = productRepository.findByProductNumber(productNumber);
            if(productEntity == null) return DeleteBuyProductResponseDto.notExistProduct();

            boolean existedOrder = buyRepository.existsByBuyNumber(buyNumber);
            if(!existedOrder) return DeleteBuyProductResponseDto.notExistOrder();       
            
            BuyProductEntity orderProductEntity = orderProductRepository.findBybuyProductNumber(buyProductNumber);
            if(orderProductEntity == null) return DeleteBuyProductResponseDto.notExistOrderProduct();

            orderProductRepository.delete(orderProductEntity);

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return DeleteBuyProductResponseDto.success();
    }



    
}
