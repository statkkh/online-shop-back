package com.online.shopping_back.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

import com.online.shopping_back.dto.request.order.PostOrderRequestDto;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="order")
@Table(name="order")
public class OrderEntity {

    @Id
    private int orderNumber;   
    private int userNumber;
    private String productName;
    @Column(columnDefinition = "DATETIME DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime orderDatetime;
    private int orderTotalPrice;

    public OrderEntity(PostOrderRequestDto dto, Integer userNumber){
        this.userNumber = userNumber;
        this.productName = dto.getProductName();
        
        this.orderDatetime = LocalDateTime.now(); 
    }
}
