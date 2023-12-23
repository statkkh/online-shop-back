package com.online.shopping_back.service.implement;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.online.shopping_back.dto.request.product.PatchProductRequestDto;
import com.online.shopping_back.dto.request.product.PostProductRequestDto;
import com.online.shopping_back.dto.response.ResponseDto;
import com.online.shopping_back.dto.response.product.PatchProductResponseDto;
import com.online.shopping_back.dto.response.product.PostProductResponseDto;
import com.online.shopping_back.entity.ProductEntity;
import com.online.shopping_back.repository.AdminRepository;
import com.online.shopping_back.repository.ProductRepository;
import com.online.shopping_back.repository.UserRepository;
import com.online.shopping_back.service.ProductService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductServiceImplement implements ProductService{
    
    private final UserRepository userRepository;
    
    private final AdminRepository adminRepository;
    
    private final ProductRepository productRepository;

    @Override
    public ResponseEntity<? super PostProductResponseDto> postProduct(PostProductRequestDto dto, String managerEmail,Integer userNumber) {
        
        try {
            boolean existedUser = userRepository.existsByEmail(managerEmail);
            if(!existedUser) return PostProductResponseDto.notExistUser();

            boolean existedManager = adminRepository.existsByManagerEmail(managerEmail);
            if(!existedManager) return PostProductResponseDto.notExistManager();
            
            ProductEntity productEntity = new ProductEntity(dto, userNumber);    
            productRepository.save(productEntity);                    

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return PostProductResponseDto.success();
    }

    @Override
    public ResponseEntity<? super PatchProductResponseDto> patchProduct(PatchProductRequestDto dto,String managerEmail, Integer userNumber) {
        
        try {
            boolean existedUser = userRepository.existsByEmail(managerEmail);
            if(!existedUser) return PatchProductResponseDto.notExistUser();

            boolean existedManager = adminRepository.existsByManagerEmail(managerEmail);
            if(!existedManager) return PatchProductResponseDto.notExistManager();
            
            ProductEntity productEntity = productRepository.findByProductNumber(dto.getProductNumber());
            if(productEntity == null) return PatchProductResponseDto.notExistProduct();

            productEntity.patchProduct(dto);
            productRepository.save(productEntity);

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return PatchProductResponseDto.success();
    }

    
}
