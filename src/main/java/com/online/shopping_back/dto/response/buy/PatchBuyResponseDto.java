package com.online.shopping_back.dto.response.buy;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.online.shopping_back.dto.response.ResponseCode;
import com.online.shopping_back.dto.response.ResponseDto;
import com.online.shopping_back.dto.response.ResponseMessage;

import lombok.Getter;

@Getter
public class PatchBuyResponseDto extends ResponseDto{
    
    private PatchBuyResponseDto(String code, String messsage){
        super(code, messsage);
    }

    public static ResponseEntity<PatchBuyResponseDto> success(){
        PatchBuyResponseDto result = new PatchBuyResponseDto(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
    }    

    public static ResponseEntity<ResponseDto> notExistUser(){
        ResponseDto result = new ResponseDto(ResponseCode.NOT_EXIST_USER, ResponseMessage.NOT_EXIST_USER);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
    }        

    public static ResponseEntity<ResponseDto> notExistOrder(){
        ResponseDto result = new ResponseDto(ResponseCode.NOT_EXIST_BUY, ResponseMessage.NOT_EXIST_BUY);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
    }    

}
