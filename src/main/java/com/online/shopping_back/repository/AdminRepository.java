package com.online.shopping_back.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mysql.cj.x.protobuf.MysqlxDatatypes.Scalar.String;
import com.online.shopping_back.entity.AdminEntity;

@Repository
public interface AdminRepository extends JpaRepository<AdminEntity,String>{
    
    boolean existsByUserNumber(Integer userNumber);
    boolean existsByManagerEmail(String managerEmail);

    AdminEntity findByManagerEmail(String managerEmail);
}
