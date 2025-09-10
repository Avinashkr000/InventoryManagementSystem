package com.avinash.InventoryManagementSystem.dtos;



import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;


import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)


public class Response {

    private int status;

    private String message;

    private String token;

    private String role;

    private String expirationTime;


    // for pagination

    private Integer totalPages;

    private Long totalElements;


    // data output optionals


    private UserDTO user;
    private List<UserDTO> users;

    private SupplierDTO supplier;
    private List<SupplierDTO> suppliers;

    private CategoryDTO category;
    private List<CategoryDTO> categories;

    private ProductDTO product;
    private List<ProductDTO> products;

    private TransactionDTO transaction;
    private List<TransactionDTO> transactions;

    private final LocalDateTime timestamp = LocalDateTime.now();

}
