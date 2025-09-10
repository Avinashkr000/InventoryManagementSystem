package com.avinash.InventoryManagementSystem.dtos;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "products")
@Data
@Builder
public class ProductDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "category_id")
    private Long categoryId;

    @Column(name = "product_id")
    private Long productId; // consider removing if redundant with `id`

    @Column(name = "supplier_id")
    private Long supplierId;

    @Column(nullable = false)
    private String name;

    private String sku;

    private BigDecimal price;

    @Column(name = "stock_quantity")
    private Integer stockQuantity;

    private String description;

    @Column(name = "expiry_date")
    private LocalDateTime expiryDate;

    @Column(name = "image_url")
    private String imageUrl;

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;
}
