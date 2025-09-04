package com.avinash.InventoryManagementSystem.dtos;

import com.avinash.InventoryManagementSystem.enums.TransanctionType;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)


public class TransactionDTO {


    private Long id;

    private Integer totalProducts;

    private BigDecimal totalPrice;


    private TransanctionType transanctionType; //return ,sale,purchase


    private TransanctionType status; // PENDING, COMPLETED, CANCELLED

    private String description;

    private String note;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    private ProductDTO product;


    private UserDTO user;


    private SupplierDTO supplier;


}
