package com.online.shopping_back.service;

import org.springframework.http.ResponseEntity;

import com.online.shopping_back.dto.request.auth.SignInRequestDto;
import com.online.shopping_back.dto.request.auth.SignUpRequestDto;
import com.online.shopping_back.dto.response.auth.SignInResponseDto;
import com.online.shopping_back.dto.response.auth.SignUpResponseDto;

public interface AuthService {

    ResponseEntity<? super SignUpResponseDto> signUp(SignUpRequestDto dto);
    ResponseEntity<? super SignInResponseDto> signIn(SignInRequestDto dto);
}
