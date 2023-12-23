package com.online.shopping_back.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PatchMapping;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.online.shopping_back.dto.request.admin.PatchAdminRequestDto;
import com.online.shopping_back.dto.request.admin.PostAdminRequestDto;
import com.online.shopping_back.dto.response.admin.GetAdminResponseDto;
import com.online.shopping_back.dto.response.admin.PatchAdminResponseDto;
import com.online.shopping_back.dto.response.admin.PostAdminResponseDto;
import com.online.shopping_back.service.AdminService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/admin")
@RequiredArgsConstructor
public class AdminController {
    
    private final AdminService adminService;

    @GetMapping("")
    public ResponseEntity<? super GetAdminResponseDto> getAdmin(
        @AuthenticationPrincipal String email
    ){
        ResponseEntity<? super GetAdminResponseDto> response = adminService.getAdmin(email);
        return response;
    }

    @PostMapping("/{userNumber}")
    public ResponseEntity<? super PostAdminResponseDto> postAdmin(
        @RequestBody @Valid PostAdminRequestDto dto,
        @AuthenticationPrincipal String email,
        @PathVariable("userNumber") Integer userNumber
    ){
        ResponseEntity<? super PostAdminResponseDto> response = adminService.postAdmin(dto, email, userNumber);
        return response;
    }

    @PatchMapping("/")
    public ResponseEntity<? super PatchAdminResponseDto> patchAdmin(
        @RequestBody @Valid PatchAdminRequestDto dto,
        @AuthenticationPrincipal String email
    ){
        ResponseEntity<?super PatchAdminResponseDto> response = adminService.patchAdmin(dto, email);
        return response;
    }
}
