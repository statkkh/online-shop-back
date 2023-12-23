package com.online.shopping_back.dto.response.admin;

import lombok.Getter;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.online.shopping_back.dto.response.ResponseCode;
import com.online.shopping_back.dto.response.ResponseDto;
import com.online.shopping_back.dto.response.ResponseMessage;

@Getter
public class PatchAdminResponseDto extends ResponseDto{
    
    private PatchAdminResponseDto(String code, String message){
        super(code, message);
    }

    public static ResponseEntity<PatchAdminResponseDto> success(){
        PatchAdminResponseDto result = new PatchAdminResponseDto(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    public static ResponseEntity<ResponseDto> notExistUser(){
        ResponseDto result = new ResponseDto(ResponseCode.NOT_EXIST_USER, ResponseMessage.NOT_EXIST_USER);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
    }

    public static ResponseEntity<ResponseDto> notExistManager(){
        ResponseDto result = new ResponseDto(ResponseCode.NOT_EXIST_MANAGER, ResponseMessage.NOT_EXIST_MANAGER);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
    }

    
}
