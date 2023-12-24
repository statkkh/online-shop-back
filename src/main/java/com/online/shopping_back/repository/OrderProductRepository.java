package com.online.shopping_back.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.online.shopping_back.entity.OrderProductEntity;
import java.util.List;

@Repository
public interface OrderProductRepository extends JpaRepository<OrderProductEntity, Integer>{

    List<OrderProductEntity> existsByUserNumber(Integer userNumber);

    OrderProductEntity  findByOrderProductNumber(Integer  orderProductNumber);
} 
