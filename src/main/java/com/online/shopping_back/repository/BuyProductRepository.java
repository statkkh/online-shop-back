package com.online.shopping_back.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.online.shopping_back.entity.BuyProductEntity;
import java.util.List;

@Repository
public interface BuyProductRepository extends JpaRepository<BuyProductEntity, Integer>{

    List<BuyProductEntity> findByUserNumber(Integer userNumber);

    BuyProductEntity  findBybuyProductNumber(Integer  buyProductNumber);
} 
