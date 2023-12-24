package com.online.shopping_back.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.online.shopping_back.entity.OrderEntity;
import java.util.List;


@Repository
public interface OrderRepository extends JpaRepository<OrderEntity, Integer>{
    
    boolean existsByOrderNumber(Integer orderNumber);

    List<OrderEntity> findByUserNumber(Integer userNumber);
}
