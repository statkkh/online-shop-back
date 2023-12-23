package com.online.shopping_back.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.online.shopping_back.entity.ProductEntity;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Integer>{
    
    List<ProductEntity> findByUserNumber(Integer userNumber);

    ProductEntity findByProductNumber(Integer productNumber);

}
