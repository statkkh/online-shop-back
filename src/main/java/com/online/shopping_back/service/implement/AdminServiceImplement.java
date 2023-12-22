package com.online.shopping_back.service.implement;

import com.online.shopping_back.dto.request.admin.PostAdminRequestDto;
import com.online.shopping_back.dto.response.ResponseDto;
import com.online.shopping_back.dto.response.admin.PostAdminResponseDto;
import com.online.shopping_back.entity.AdminEntity;
import com.online.shopping_back.repository.AdminRepository;
import com.online.shopping_back.repository.UserRepository;
import com.online.shopping_back.service.AdminService;

import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AdminServiceImplement implements AdminService{
    
    private final UserRepository userRepository;

    private final AdminRepository adminRepository;

    @Override
    public ResponseEntity<? super PostAdminResponseDto> postAdmin(PostAdminRequestDto dto, String email,Integer userNumber) {
        
        try {
            
            boolean existedUser = userRepository.existsByEmail(email);
            if(!existedUser) return PostAdminResponseDto.notExistUser();

            AdminEntity adminEntity = new AdminEntity(dto, email, userNumber);
            adminRepository.save(adminEntity);
            
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return PostAdminResponseDto.success();
    }
}
