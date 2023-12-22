package com.online.shopping_back.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.online.shopping_back.dto.request.admin.PostAdminRequestDto;
import com.online.shopping_back.dto.response.admin.PostAdminResponseDto;
import com.online.shopping_back.service.AdminService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/admin")
@RequiredArgsConstructor
public class AdminController {
    
    private final AdminService adminService;

    @PostMapping("/{email}/{userNumber}")
    public ResponseEntity<? super PostAdminResponseDto> postAdmin(
        @RequestBody @Valid PostAdminRequestDto dto,
        @PathVariable("email") String email,
        @PathVariable("userNumber") Integer userNumber
    ){
        ResponseEntity<? super PostAdminResponseDto> response = adminService.postAdmin(dto, email, userNumber);
        return response;
    }
}
