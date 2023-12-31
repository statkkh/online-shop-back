package com.online.shopping_back.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

import com.online.shopping_back.dto.request.buy.PatchBuyRequestDto;
import com.online.shopping_back.dto.request.buy.PostBuyRequestDto;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="buy")
@Table(name="buy")
public class BuyEntity {
    
    @Id
    private int buyNumber;   
    private int userNumber;
    private String productName;
    @Column(columnDefinition = "DATETIME DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime buyDatetime;
    private int orderTotalPrice;

    public BuyEntity(PostBuyRequestDto dto, Integer userNumber){
        this.userNumber = userNumber;
        this.productName = dto.getProductName();
        this.buyDatetime = LocalDateTime.now(); 
    }

    public void patchBuy(PatchBuyRequestDto dto){
        this.productName = dto.getProductName();
    }
    
}
