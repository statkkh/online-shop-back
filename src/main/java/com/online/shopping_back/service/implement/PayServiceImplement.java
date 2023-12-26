package com.online.shopping_back.service.implement;

import com.online.shopping_back.dto.request.pay.PatchPayRequestDto;
import com.online.shopping_back.dto.request.pay.PostPayRequestDto;

import com.online.shopping_back.dto.response.ResponseDto;
import com.online.shopping_back.dto.response.pay.DeletePayResponseDto;
import com.online.shopping_back.dto.response.pay.PatchPayResponseDto;
import com.online.shopping_back.dto.response.pay.PostPayResponseDto;

import com.online.shopping_back.entity.PayEntity;

import com.online.shopping_back.repository.BuyRepository;
import com.online.shopping_back.repository.PayRepository;
import com.online.shopping_back.repository.UserRepository;

import com.online.shopping_back.service.PayService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import org.springframework.http.ResponseEntity;

@Service
@RequiredArgsConstructor
public class PayServiceImplement implements PayService{
    
    private final UserRepository userRepository;

    private final BuyRepository buyRepository;

    private final PayRepository payRepository;

    @Override
    public ResponseEntity<? super PostPayResponseDto> postPay(PostPayRequestDto dto,String email, Integer userNumber,Integer orderNumber) {
        
        try {
            
            boolean existedUser = userRepository.existsByEmail(email);
            if(!existedUser) return PostPayResponseDto.notExistUser();

            boolean existedOrder = buyRepository.existsByOrderNumber(orderNumber);
            if(!existedOrder) return PostPayResponseDto.notExistOrder();

            PayEntity  payEntity = new PayEntity(dto, userNumber, orderNumber);
            payRepository.save(payEntity);

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return PostPayResponseDto.success();
    }

    @Override
    public ResponseEntity<? super PatchPayResponseDto> patchPay(PatchPayRequestDto dto, String email,Integer userNumber, Integer orderNumber) {
        
        try {
            
            boolean existedUser = userRepository.existsByEmail(email);
            if(!existedUser) return PatchPayResponseDto.notExistUser();

            boolean existedOrder = buyRepository.existsByOrderNumber(orderNumber);
            if(!existedOrder) return PatchPayResponseDto.notExistOrder();

            PayEntity  payEntity = payRepository.findByPayNumber(dto.getPayNumber());
            if(payEntity == null) return PatchPayResponseDto.notExistPay();

            payEntity.patchPay(dto);
            payRepository.save(payEntity);

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return PatchPayResponseDto.success();
    }

    @Override
    public ResponseEntity<? super DeletePayResponseDto> deletePay(String email, Integer userNumber, Integer orderNumber,Integer payNumber) {
        
        try {

            boolean existedUser = userRepository.existsByEmail(email);
            if(!existedUser) return PatchPayResponseDto.notExistUser();

            boolean existedOrder = buyRepository.existsByOrderNumber(orderNumber);
            if(!existedOrder) return PatchPayResponseDto.notExistOrder();         
            
            PayEntity  payEntity = payRepository.findByPayNumber(payNumber);
            if(payEntity == null) return DeletePayResponseDto.notExistPay();

            payRepository.delete(payEntity);
            
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return DeletePayResponseDto.success();
    }

    
}
