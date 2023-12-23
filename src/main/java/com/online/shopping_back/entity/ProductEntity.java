package com.online.shopping_back.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.time.Instant;

import org.springframework.data.annotation.CreatedDate;

import com.online.shopping_back.dto.request.product.PatchProductRequestDto;
import com.online.shopping_back.dto.request.product.PostProductRequestDto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="product")
@Table(name="product")
public class ProductEntity {

    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int productNumber;
    private int userNumber;
    private String productName;
    private int price;
    @CreatedDate
    private String registerDate;

    public ProductEntity(PostProductRequestDto dto, Integer userNumber){        
        this.userNumber = userNumber;
        this.productName = dto.getProductName();
        this.price = dto.getPrice();
    }

    public void patchProduct(PatchProductRequestDto dto){
        this.productName = dto.getProductName();
        this.price = dto.getPrice();
    }
}
