package com.online.shopping_back.dto.response.pay;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.online.shopping_back.dto.response.ResponseCode;
import com.online.shopping_back.dto.response.ResponseDto;
import com.online.shopping_back.dto.response.ResponseMessage;

import lombok.Getter;

@Getter
public class PostPayResponseDto extends ResponseDto{
    
    private  PostPayResponseDto(String code, String messsage){
        super(code, messsage);
    }

    public static ResponseEntity<PostPayResponseDto> success(){
        PostPayResponseDto result = new PostPayResponseDto(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }   

    public static ResponseEntity<ResponseDto> notExistUser(){
        ResponseDto result = new ResponseDto(ResponseCode.NOT_EXIST_USER, ResponseMessage.NOT_EXIST_USER);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
    }
    
    public static ResponseEntity<ResponseDto> notExistOrder(){
        ResponseDto result = new ResponseDto(ResponseCode.NOT_EXIST_ORDER, ResponseMessage.NOT_EXIST_ORDER);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
    }        
}
