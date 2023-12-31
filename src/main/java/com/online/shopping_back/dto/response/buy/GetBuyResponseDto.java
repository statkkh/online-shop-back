package com.online.shopping_back.dto.response.buy;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.online.shopping_back.dto.response.ResponseCode;
import com.online.shopping_back.dto.response.ResponseDto;
import com.online.shopping_back.dto.response.ResponseMessage;
import com.online.shopping_back.entity.BuyEntity;

import lombok.Getter;

@Getter
public class GetBuyResponseDto extends ResponseDto{
    
    private int buyNumber;   
    private int userNumber;
    private String productName;    
    private LocalDateTime orderDatetime;
    private int orderTotalPrice;

    private GetBuyResponseDto(String code, String message,BuyEntity buyEntity){
        super(code, message);
        this.buyNumber = buyEntity.getBuyNumber();
        this.userNumber = buyEntity.getUserNumber();
        this.productName = buyEntity.getProductName();
        this.orderDatetime = buyEntity.getBuyDatetime();
        this.orderTotalPrice = buyEntity.getOrderTotalPrice();
    }

    public static ResponseEntity<GetBuyResponseDto> success(BuyEntity buyEntity){
        GetBuyResponseDto result = new GetBuyResponseDto(ResponseCode.SUCCESS,ResponseMessage.SUCCESS,buyEntity);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
    }

    public static ResponseEntity<ResponseDto> notExistUser() {
        ResponseDto result = new ResponseDto(ResponseCode.NOT_EXIST_USER, ResponseMessage.NOT_EXIST_USER);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
    }
    
    public static ResponseEntity<ResponseDto> notExistOrder(){
        ResponseDto result = new ResponseDto(ResponseCode.NOT_EXIST_BUY, ResponseMessage.NOT_EXIST_BUY);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
    }       

}
