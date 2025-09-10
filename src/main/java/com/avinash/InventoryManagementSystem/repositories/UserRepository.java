package com.avinash.InventoryManagementSystem.repositories;

import com.avinash.InventoryManagementSystem.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmal(String email);


}
