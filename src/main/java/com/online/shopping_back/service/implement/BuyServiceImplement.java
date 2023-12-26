package com.online.shopping_back.service.implement;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.online.shopping_back.dto.request.order.PatchOrderRequestDto;
import com.online.shopping_back.dto.request.order.PostOrderRequestDto;
import com.online.shopping_back.dto.response.ResponseDto;
import com.online.shopping_back.dto.response.order.DeleteOrderResponseDto;
import com.online.shopping_back.dto.response.order.GetOrderResponseDto;
import com.online.shopping_back.dto.response.order.PatchOrderResponseDto;
import com.online.shopping_back.dto.response.order.PostOrderResponseDto;
import com.online.shopping_back.dto.response.orderProduct.PostOrderProductResponseDto;

import com.online.shopping_back.entity.BuyEntity;
import com.online.shopping_back.repository.BuyRepository;
import com.online.shopping_back.repository.UserRepository;
import com.online.shopping_back.service.BuyService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BuyServiceImplement implements BuyService{
    
    private final UserRepository userRepository;

    
    private final BuyRepository buyRepository;    
    


    @Override
    public ResponseEntity<? super PostOrderResponseDto> postBuy(PostOrderRequestDto dto,String email, Integer userNumber) {
        
        try {
            
            boolean existedUser = userRepository.existsByEmail(email);
            if(!existedUser) return PostOrderResponseDto.notExistUser();

            BuyEntity buyEntity = new BuyEntity(dto, userNumber);
            buyRepository.save(buyEntity);


        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return PostOrderResponseDto.success();
    }

    @Override
    public ResponseEntity<? super PatchOrderResponseDto> patchBuy(PatchOrderRequestDto dto, String email,Integer userNumber) {
        
        try {
            boolean existedUser = userRepository.existsByEmail(email);
            if(!existedUser) return PatchOrderResponseDto.notExistUser();
            
            BuyEntity buyEntity = buyRepository.findByOrderNumber(dto.getOrderNumber());
            if(buyEntity == null) return PatchOrderResponseDto.notExistOrder();

            buyEntity.patchBuy(dto);
            buyRepository.save(buyEntity);

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return PatchOrderResponseDto.success();
    }

    @Override
    public ResponseEntity<? super DeleteOrderResponseDto> deleteBuy(String email, Integer userNumber,Integer orderNumber) {
        
        try {
            boolean existedUser = userRepository.existsByEmail(email);
            if(!existedUser) return PatchOrderResponseDto.notExistUser();
            
            BuyEntity buyEntity = buyRepository.findByOrderNumber(orderNumber);
            if(buyEntity == null) return DeleteOrderResponseDto.notExistOrder();

            buyRepository.delete(buyEntity);
            
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }    
        return DeleteOrderResponseDto.success();
    }
    
    
}
