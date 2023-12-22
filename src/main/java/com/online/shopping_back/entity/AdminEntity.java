package com.online.shopping_back.entity;

import com.online.shopping_back.dto.request.admin.PatchAdminRequestDto;
import com.online.shopping_back.dto.request.admin.PostAdminRequestDto;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="admin")
@Table(name="admin")
public class AdminEntity {
    
    @Id
    private String managerEmail;
    private int userNumber;
    private String managerName;

    public AdminEntity(PostAdminRequestDto dto, String managerEmail,int userNumber){
        this.managerEmail = managerEmail;
        this.userNumber = userNumber;
        this.managerName = dto.getManagerName();
    }

    public void patchAdmin(PatchAdminRequestDto dto){
        this.managerName = dto.getManagerName();
    }
}
