package com.online.shopping_back.dto.response.orderProduct;

import com.online.shopping_back.common.object.OrderProductListItem;

import com.online.shopping_back.dto.response.ResponseCode;
import com.online.shopping_back.dto.response.ResponseDto;
import com.online.shopping_back.dto.response.ResponseMessage;
import com.online.shopping_back.entity.OrderProductEntity;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import lombok.Getter;

@Getter
public class GetOrderProductListResponseDto extends ResponseDto{
    
    private List<OrderProductListItem> orderProductList;

    private GetOrderProductListResponseDto(String code, String message,List<OrderProductEntity> orderProductEntities){
        super(code, message); 
        this.orderProductList = OrderProductListItem.getOrderProductList(orderProductEntities);
    }

    public static ResponseEntity<GetOrderProductListResponseDto> success(List<OrderProductEntity> orderProductEntities){
        GetOrderProductListResponseDto result = new GetOrderProductListResponseDto(ResponseCode.SUCCESS, ResponseMessage.SUCCESS, orderProductEntities);
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
}
