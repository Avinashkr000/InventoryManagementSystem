package com.avinash.InventoryManagementSystem.repositories;

import com.avinash.InventoryManagementSystem.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CategoryRepository extends JpaRepository<Category, Long> {


}
