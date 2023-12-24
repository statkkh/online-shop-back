package com.online.shopping_back.dto.response.orderProduct;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.online.shopping_back.dto.response.ResponseCode;
import com.online.shopping_back.dto.response.ResponseDto;
import com.online.shopping_back.dto.response.ResponseMessage;

import lombok.Getter;

@Getter
public class PostOrderProductResponseDto extends ResponseDto{
    
    private PostOrderProductResponseDto(String code, String messsage){
        super(code, messsage);
    }

    public static ResponseEntity<PostOrderProductResponseDto> success(){
        PostOrderProductResponseDto result = new PostOrderProductResponseDto(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
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
    
    public static ResponseEntity<ResponseDto> notExistProduct(){
        ResponseDto result = new ResponseDto(ResponseCode.NOT_FOUND_PRODUCT, ResponseMessage.NOT_FOUND_PRODUCT);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
    }    
    
    public static ResponseEntity<ResponseDto> notExistOrder(){
        ResponseDto result = new ResponseDto(ResponseCode.NOT_EXIST_ORDER, ResponseMessage.NOT_EXIST_ORDER);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
    }     


    public static ResponseEntity<ResponseDto> notExistOrderProduct(){
        ResponseDto result = new ResponseDto(ResponseCode.NOT_FOUND_ORDER_PRODUCT, ResponseMessage.NOT_FOUND_ORDER_PRODUCT);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
    }        
    
}
