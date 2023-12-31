package com.online.shopping_back.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.online.shopping_back.entity.BuyEntity;
import java.util.List;


@Repository
public interface BuyRepository extends JpaRepository<BuyEntity, Integer>{
    
    boolean existsByBuyNumber(Integer buyNumber);

    // @Query(
    //     value = 
    //     "SELECT " +
    //         "B.user_number AS userNumber, " +
    //         "B.product_name AS productName, " +
    //         "B.order_datetime AS orderDatetime, " +
    //         "(  " +
    //             "SELECT SUM(OP2.product_price) " +
    //             "FROM order_product  AS OP2 " +
    //             "WHERE B.order_number = OP2.order_number " +
    //             "AND B.product_name = OP2.product_name " +
    //         ") AS orderTotalPrice " +
    //     "FROM buy AS B " +
    //     "JOIN order_product AS OP " +
    //     "ON B.product_name = OP.product_name " ,
    //     nativeQuery = true
    // )
    
    BuyEntity findByBuyNumber(Integer buyNumber);
}
