package com.avinash.InventoryManagementSystem.dtos;


import com.avinash.InventoryManagementSystem.enums.UserRole;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor


public class RegisterRequest {

    @NotBlank(message = "Name is required")
    private String name;


    @NotBlank(message = "email is required")
    private String email;



    @NotBlank(message = "Password is required")
    private String password;

    private UserRole role;

}
