package com.online.shopping_back.dto.response.product;

import com.online.shopping_back.common.object.ProductListItem;
import com.online.shopping_back.dto.response.ResponseCode;
import com.online.shopping_back.dto.response.ResponseDto;
import com.online.shopping_back.dto.response.ResponseMessage;
import com.online.shopping_back.entity.ProductEntity;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import lombok.Getter;

@Getter
public class GetProductListResponseDto extends ResponseDto{
    
    private List<ProductListItem> productList;

    private GetProductListResponseDto(String code, String message, List<ProductEntity> productEntities){
        super(code, message); 
        this.productList = ProductListItem.getProductList(productEntities);
    }

    public static ResponseEntity<GetProductListResponseDto> success(List<ProductEntity> productEntities){
        GetProductListResponseDto result = new GetProductListResponseDto(ResponseCode.SUCCESS, ResponseMessage.SUCCESS,productEntities);
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
