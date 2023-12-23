package com.online.shopping_back.dto.response.admin;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.online.shopping_back.dto.response.ResponseCode;
import com.online.shopping_back.dto.response.ResponseDto;
import com.online.shopping_back.dto.response.ResponseMessage;
import com.online.shopping_back.entity.AdminEntity;

import lombok.Getter;

@Getter
public class GetAdminResponseDto extends ResponseDto{
    
    private String managerEmail;
    private int userNumber;
    private String managerName;    

    private GetAdminResponseDto(String code, String message, AdminEntity adminEntity){
        super(code, message);
        this.managerEmail = adminEntity.getManagerEmail();
        this.userNumber = adminEntity.getUserNumber();
        this.managerName = adminEntity.getManagerName();
    }

    public static ResponseEntity<GetAdminResponseDto> success(AdminEntity adminEntity){
        GetAdminResponseDto result = new GetAdminResponseDto(ResponseCode.SUCCESS, ResponseMessage.SUCCESS,adminEntity);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    public static ResponseEntity<ResponseDto> notExistUser(){
        ResponseDto result = new ResponseDto(ResponseCode.NOT_EXIST_USER, ResponseMessage.NOT_EXIST_USER);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
    }
    
    
}
