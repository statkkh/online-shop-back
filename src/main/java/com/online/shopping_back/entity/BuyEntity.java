package com.online.shopping_back.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

import com.online.shopping_back.dto.request.order.PatchOrderRequestDto;
import com.online.shopping_back.dto.request.order.PostOrderRequestDto;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="buy")
@Table(name="buy")
public class BuyEntity {

    @Id
    private int orderNumber;   
    private int userNumber;
    private String productName;
    @Column(columnDefinition = "DATETIME DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime orderDatetime;
    private int orderTotalPrice;

    public BuyEntity(PostOrderRequestDto dto, Integer userNumber){
        this.userNumber = userNumber;
        this.productName = dto.getProductName();
        this.orderDatetime = LocalDateTime.now(); 
    }

    public void patchBuy(PatchOrderRequestDto dto){
        this.productName = dto.getProductName();
    }
}
