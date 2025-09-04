package com.avinash.InventoryManagementSystem.dtos;


import com.avinash.InventoryManagementSystem.enums.UserRole;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)


public class TransanctionRequest {

    @Positive(message = "Product ID is required")
    private Long productId;


    @Positive(message = "quantity id is required")
    private Integer quantity;


    private Long supplierId;

    private String description;

    private String note;


}
