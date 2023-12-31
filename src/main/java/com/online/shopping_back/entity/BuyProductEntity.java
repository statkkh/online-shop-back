package com.online.shopping_back.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import com.online.shopping_back.dto.request.buyProduct.PatchBuyProductRequestDto;
import com.online.shopping_back.dto.request.buyProduct.PostBuyProductRequestDto;

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
public class BuyProductEntity {
    
    @Id
    private int buyProductNumber;
    private int userNumber;
    private int buyNumber; 
    private int productNumber;
    private String productName;
    private int productPrice;


    public BuyProductEntity(PostBuyProductRequestDto dto, Integer userNumber,Integer buyNumber,Integer productNumber){
        this.userNumber = userNumber;
        this.buyNumber = buyNumber;
        this.productNumber = productNumber;
        this.productName = dto.getProductName();
        this.productPrice = dto.getProductPrice();
    }

    public void patchOrderProduct(PatchBuyProductRequestDto dto){
        this.productPrice = dto.getProductPrice();
    }
}
