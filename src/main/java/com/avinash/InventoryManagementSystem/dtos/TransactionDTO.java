package com.avinash.InventoryManagementSystem.dtos;


import com.avinash.InventoryManagementSystem.enums.TransanctionType;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import org.springframework.transaction.TransactionStatus;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class TransactionDTO {

    private Long id;

    private Integer totalProducts;

    private BigDecimal totalPrice;


    private TransanctionType transactionType; // pruchase, sale, return


    private TransactionStatus status; //pending, completed, processing

    private String description;
    private String note;

    private LocalDateTime createdAt;
    private LocalDateTime updateAt;

    private ProductDTO product;

    private UserDTO user;

    private SupplierDTO supplier;


}