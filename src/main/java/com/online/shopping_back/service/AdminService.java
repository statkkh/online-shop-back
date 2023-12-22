package com.online.shopping_back.service;

import org.springframework.http.ResponseEntity;

import com.online.shopping_back.dto.request.admin.PostAdminRequestDto;
import com.online.shopping_back.dto.response.admin.PostAdminResponseDto;

public interface AdminService {

    ResponseEntity<? super PostAdminResponseDto> postAdmin(PostAdminRequestDto dto,String email,  Integer userNumber);
} 