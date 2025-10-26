package com.avinash.InventoryManagementSystem.services;

import com.avinash.InventoryManagementSystem.dtos.CategoryDTO;
import com.avinash.InventoryManagementSystem.dtos.Response;

public interface CategoryService {


    Response createCategory(CategoryDTO categoryDTO);

    Response getAllCategories();

    Response getCategoryById(Long id);

    Response updateCategory(Long id, CategoryDTO categoryDTO);

    Response deleteCategory(Long id);

}
