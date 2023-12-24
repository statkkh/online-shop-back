package com.online.shopping_back.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.online.shopping_back.entity.BuyEntity;
import java.util.List;


@Repository
public interface BuyRepository extends JpaRepository<BuyEntity, Integer>{
    
    boolean existsByOrderNumber(Integer orderNumber);

    List<BuyEntity> findByUserNumber(Integer userNumber);
}
