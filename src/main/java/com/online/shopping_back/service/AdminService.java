package com.online.shopping_back.service;

import org.springframework.http.ResponseEntity;

import com.online.shopping_back.dto.request.admin.PatchAdminRequestDto;
import com.online.shopping_back.dto.request.admin.PostAdminRequestDto;

import com.online.shopping_back.dto.response.admin.GetAdminResponseDto;
import com.online.shopping_back.dto.response.admin.PatchAdminResponseDto;
import com.online.shopping_back.dto.response.admin.PostAdminResponseDto;

public interface AdminService {
    ResponseEntity<? super GetAdminResponseDto> getAdmin(String email);
    ResponseEntity<? super PostAdminResponseDto> postAdmin(PostAdminRequestDto dto,String email,  Integer userNumber);
    ResponseEntity<? super PatchAdminResponseDto> patchAdmin(PatchAdminRequestDto dto,String email);
} 