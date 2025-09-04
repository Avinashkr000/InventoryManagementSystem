package com.avinash.InventoryManagementSystem.dtos;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;




@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "products")


public class SupplierDTO {

    private Long id;

    @NotBlank(message = "Name is required")
    private String name;

    @NotBlank(message = " contactInfo is required")
    private String contactInfo;

    private String address;


}
