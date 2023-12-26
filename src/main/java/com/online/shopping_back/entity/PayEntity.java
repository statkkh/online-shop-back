package com.online.shopping_back.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

import com.online.shopping_back.dto.request.pay.PostPayRequestDto;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="pay")
@Table(name="pay")
public class PayEntity {

    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int payNumber;
    private int userNumber;
    private int orderNumber; 
    private int payPrice;
    private int payStatus;
    @Column(columnDefinition = "DATETIME DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime payDatetime;  
    
    public PayEntity(PostPayRequestDto dto, Integer userNumber,Integer orderNumber){
        this.userNumber = userNumber;
        this.orderNumber = orderNumber;
        this.payDatetime = LocalDateTime.now(); 
    }
    
    public void patchPay(){
        
    }
}
