package com.avinash.InventoryManagementSystem.repositories;

import com.avinash.InventoryManagementSystem.models.Category;
import com.avinash.InventoryManagementSystem.models.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;


public interface SupplierRepository extends JpaRepository<Supplier, Long> {


}
