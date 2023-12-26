package com.online.shopping_back.dto.response.pay;

import com.online.shopping_back.dto.response.ResponseCode;
import com.online.shopping_back.dto.response.ResponseDto;
import com.online.shopping_back.dto.response.ResponseMessage;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import lombok.Getter;

@Getter
public class DeletePayResponseDto extends ResponseDto{
    
    private DeletePayResponseDto(String code, String messsage){
        super(code, messsage);
    }

    public static ResponseEntity<DeletePayResponseDto> success(){
        DeletePayResponseDto result = new DeletePayResponseDto(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    public static ResponseEntity<ResponseDto> notExistOrder(){
        ResponseDto result = new ResponseDto(ResponseCode.NOT_EXIST_ORDER, ResponseMessage.NOT_EXIST_ORDER);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
    }   
    
    public static ResponseEntity<ResponseDto> notExistPay(){
        ResponseDto result = new ResponseDto(ResponseCode.NOT_FOUND_PAY, ResponseMessage.NOT_FOUND_PAY);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
    }    

}
