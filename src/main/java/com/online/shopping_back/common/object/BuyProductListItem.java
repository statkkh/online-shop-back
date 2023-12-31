package com.online.shopping_back.common.object;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

import com.online.shopping_back.entity.BuyProductEntity;

@Getter
@Setter
public class BuyProductListItem {
    
    private int buyProductNumber;
    private int userNumber;
    private int buyNumber; 
    private int productNumber;
    private String productName;
    private int productPrice;
    
    public BuyProductListItem(BuyProductEntity orderProductEntity){
        this.buyProductNumber = orderProductEntity.getBuyProductNumber();
        this.userNumber = orderProductEntity.getUserNumber();
        this.buyNumber = orderProductEntity.getBuyNumber();
        this.productNumber = orderProductEntity.getProductNumber();
        this.productName = orderProductEntity.getProductName();
        this.productPrice = orderProductEntity.getProductPrice();
    }

    public static List<BuyProductListItem> getOrderProductList(List<BuyProductEntity> orderProductEntities ){
        List<BuyProductListItem> list = new ArrayList<>();
        for(BuyProductEntity orderProductEntity : orderProductEntities){
            BuyProductListItem orderProductListItem = new BuyProductListItem(orderProductEntity);
            list.add(orderProductListItem);
        }
        return list;
    }    

}
