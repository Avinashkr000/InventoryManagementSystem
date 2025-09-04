package com.avinash.InventoryManagementSystem.dtos;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "products")
@Data
@Builder
public class ProductDTO {


    private Long id;


    private Long categoryId;
    private Long productId;
    private Long supplierId;

    private String name;

    private String sku;

    private BigDecimal price;
    private Integer stockQuantity;

    private String description;
    private LocalDateTime expiryDate;
    private String imageUrl;

    private LocalDateTime createdAt;



}
