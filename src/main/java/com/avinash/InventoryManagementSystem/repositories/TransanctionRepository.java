package com.avinash.InventoryManagementSystem.repositories;

import com.avinash.InventoryManagementSystem.models.Transaction;
import com.avinash.InventoryManagementSystem.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;


public interface TransanctionRepository extends JpaRepository<Transaction, Long>, JpaSpecificationExecutor<Transaction> {


}