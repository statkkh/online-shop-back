package com.online.shopping_back.dto.response.buy;

import com.online.shopping_back.dto.response.ResponseCode;
import com.online.shopping_back.dto.response.ResponseDto;
import com.online.shopping_back.dto.response.ResponseMessage;

import lombok.Getter;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


@Getter
public class PostBuyResponseDto extends ResponseDto{
    
    private PostBuyResponseDto(String code, String messsage){
        super(code, messsage);
    }

    public static ResponseEntity<PostBuyResponseDto> success(){
        PostBuyResponseDto result = new PostBuyResponseDto(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    public static ResponseEntity<ResponseDto> notExistUser(){
        ResponseDto result = new ResponseDto(ResponseCode.NOT_EXIST_USER, ResponseMessage.NOT_EXIST_USER);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
    }    
}
