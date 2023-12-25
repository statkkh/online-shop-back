package com.online.shopping_back.dto.response.order;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.online.shopping_back.dto.response.ResponseCode;
import com.online.shopping_back.dto.response.ResponseDto;
import com.online.shopping_back.dto.response.ResponseMessage;
import com.online.shopping_back.entity.BuyEntity;

import lombok.Getter;

@Getter
public class GetOrderResponseDto extends ResponseDto{
    
    private int orderNumber;   
    private int userNumber;
    private String productName;    
    private LocalDateTime orderDatetime;
    private int orderTotalPrice;

    private GetOrderResponseDto(String code, String message,BuyEntity buyEntity){
        super(code, message);
        this.orderNumber = buyEntity.getOrderNumber();
        this.userNumber = buyEntity.getUserNumber();
        this.productName = buyEntity.getProductName();
        this.orderDatetime = buyEntity.getOrderDatetime();
        this.orderTotalPrice = buyEntity.getOrderTotalPrice();
    }

    public static ResponseEntity<GetOrderResponseDto> success(BuyEntity buyEntity){
        GetOrderResponseDto result = new GetOrderResponseDto(ResponseCode.SUCCESS,ResponseMessage.SUCCESS,buyEntity);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
    }

    public static ResponseEntity<ResponseDto> notExistUser() {
        ResponseDto result = new ResponseDto(ResponseCode.NOT_EXIST_USER, ResponseMessage.NOT_EXIST_USER);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
    }
    
    public static ResponseEntity<ResponseDto> notExistOrder(){
        ResponseDto result = new ResponseDto(ResponseCode.NOT_EXIST_ORDER, ResponseMessage.NOT_EXIST_ORDER);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
    }       

}
