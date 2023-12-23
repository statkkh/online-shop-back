package com.online.shopping_back.common.object;

import lombok.Getter;
import lombok.Setter;


import java.util.ArrayList;
import java.util.List;

import com.online.shopping_back.entity.ProductEntity;

import java.time.LocalDateTime;

@Getter
@Setter
public class ProductListItem {
    
    private int productNumber;
    private int userNumber;
    private String productName;
    private int price;
    private LocalDateTime registerDate;

    public ProductListItem(ProductEntity productEntity){
        this.productNumber = productEntity.getProductNumber();
        this.userNumber = productEntity.getUserNumber();
        this.productName = productEntity.getProductName();
        this.price = productEntity.getPrice();
        this.registerDate = productEntity.getRegisterDate();
    }

    public static List<ProductListItem> getProductList(List<ProductEntity> productEntities ){
        List<ProductListItem> list = new ArrayList<>();
        for(ProductEntity productEntity : productEntities){
            ProductListItem productListItem = new ProductListItem(productEntity);
            list.add(productListItem);
        }
        return list;
    }
}
