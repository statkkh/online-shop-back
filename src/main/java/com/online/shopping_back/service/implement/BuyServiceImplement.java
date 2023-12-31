package com.online.shopping_back.service.implement;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.online.shopping_back.dto.request.buy.PatchBuyRequestDto;
import com.online.shopping_back.dto.request.buy.PostBuyRequestDto;
import com.online.shopping_back.dto.response.ResponseDto;
import com.online.shopping_back.dto.response.buy.DeleteBuyResponseDto;
import com.online.shopping_back.dto.response.buy.GetBuyResponseDto;
import com.online.shopping_back.dto.response.buy.PatchBuyResponseDto;
import com.online.shopping_back.dto.response.buy.PostBuyResponseDto;
import com.online.shopping_back.dto.response.buyProduct.PostOrderProductResponseDto;
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
    public ResponseEntity<? super PostBuyResponseDto> postBuy(PostBuyRequestDto dto,String email, Integer userNumber) {
        
        try {
            
            boolean existedUser = userRepository.existsByEmail(email);
            if(!existedUser) return PostBuyResponseDto.notExistUser();

            BuyEntity buyEntity = new BuyEntity(dto, userNumber);
            buyRepository.save(buyEntity);


        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return PostBuyResponseDto.success();
    }

    @Override
    public ResponseEntity<? super PatchBuyResponseDto> patchBuy(PatchBuyRequestDto dto, String email,Integer buyNumber) {
        
        try {
            boolean existedUser = userRepository.existsByEmail(email);
            if(!existedUser) return PatchBuyResponseDto.notExistUser();
            
            BuyEntity buyEntity = buyRepository.findByBuyNumber(dto.getBuyNumber());
            if(buyEntity == null) return PatchBuyResponseDto.notExistOrder();

            buyEntity.patchBuy(dto);
            buyRepository.save(buyEntity);

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return PatchBuyResponseDto.success();
    }

    @Override
    public ResponseEntity<? super DeleteBuyResponseDto> deleteBuy(String email, Integer buyNumber,Integer orderNumber) {
        
        try {
            boolean existedUser = userRepository.existsByEmail(email);
            if(!existedUser) return PatchBuyResponseDto.notExistUser();
            
            BuyEntity buyEntity = buyRepository.findByBuyNumber(buyNumber);
            if(buyEntity == null) return DeleteBuyResponseDto.notExistOrder();

            buyRepository.delete(buyEntity);
            
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }    
        return DeleteBuyResponseDto.success();
    }
    
    
}
