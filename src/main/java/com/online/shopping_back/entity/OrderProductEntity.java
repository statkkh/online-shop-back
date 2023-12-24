package com.online.shopping_back.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import com.online.shopping_back.dto.request.orderProduct.PatchOrderProductRequestDto;
import com.online.shopping_back.dto.request.orderProduct.PostOrderProductRequestDto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="order_product")
@Table(name="order_product")
public class OrderProductEntity {
    
    @Id
    private int orderProductNumber;
    private int userNumber;
    private int orderNumber; 
    private int productNumber;
    private String productName;
    private int productPrice;


    public OrderProductEntity(PostOrderProductRequestDto dto, Integer userNumber,Integer orderNumber,Integer productNumber){
        this.userNumber = userNumber;
        this.orderNumber = orderNumber;
        this.productNumber = productNumber;
        this.productName = dto.getProductName();
        this.productPrice = dto.getProductPrice();
    }

    public void patchOrderProduct(PatchOrderProductRequestDto dto){
        this.productPrice = dto.getProductPrice();
    }
}
