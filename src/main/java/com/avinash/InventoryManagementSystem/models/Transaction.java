package com.avinash.InventoryManagementSystem.models;

import com.avinash.InventoryManagementSystem.enums.TransanctionType;
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
@Table(name = "trnsactions")
@Data
@Builder
public class Transaction {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;

    private Integer totalProducts;

    private BigDecimal totalPrice;

    @Enumerated(EnumType.STRING)
    private TransanctionType transanctionType; //return ,sale,purchase

    @Enumerated(EnumType.STRING)
    private TransanctionType status; // PENDING, COMPLETED, CANCELLED

   private String description;

   private String note;

   private final LocalDateTime createdAt = LocalDateTime.now();
   private LocalDateTime updatedAt;

   @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
   private Product product;


    @ManyToOne(fetch = FetchType.LAZY)
     @JoinColumn(name = "user_id")
   private User user;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "supplier_id")
   private Supplier supplier;

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", totalProducts=" + totalProducts +
                ", totalPrice=" + totalPrice +
                ", transanctionType=" + transanctionType +
                ", status=" + status +
                ", description='" + description + '\'' +
                ", note='" + note + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", product=" + product +
                ", user=" + user +
                ", supplier=" + supplier +
                '}';
    }
}
