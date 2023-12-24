package com.online.shopping_back.common.object;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

import com.online.shopping_back.entity.OrderProductEntity;

@Getter
@Setter
public class OrderProductListItem {
    
    private int orderProductNumber;
    private int userNumber;
    private int orderNumber; 
    private int productNumber;
    private String productName;
    private int productPrice;
    
    public OrderProductListItem(OrderProductEntity orderProductEntity){
        this.orderProductNumber = orderProductEntity.getOrderProductNumber();
        this.userNumber = orderProductEntity.getUserNumber();
        this.orderNumber = orderProductEntity.getOrderNumber();
        this.productNumber = orderProductEntity.getProductNumber();
        this.productName = orderProductEntity.getProductName();
        this.productPrice = orderProductEntity.getProductPrice();
    }

    public static List<OrderProductListItem> getOrderProductList(List<OrderProductEntity> orderProductEntities ){
        List<OrderProductListItem> list = new ArrayList<>();
        for(OrderProductEntity orderProductEntity : orderProductEntities){
            OrderProductListItem orderProductListItem = new OrderProductListItem(orderProductEntity);
            list.add(orderProductListItem);
        }
        return list;
    }    

}
