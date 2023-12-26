package com.online.shopping_back.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.online.shopping_back.entity.PayEntity;


@Repository
public interface PayRepository extends JpaRepository<PayEntity, Integer>{
    
    PayEntity findByPayNumber(Integer payNumber);

    
}
