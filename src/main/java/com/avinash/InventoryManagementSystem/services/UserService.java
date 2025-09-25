package com.avinash.InventoryManagementSystem.services;

import com.avinash.InventoryManagementSystem.dtos.LoginRequest;
import com.avinash.InventoryManagementSystem.dtos.RegisterRequest;
import com.avinash.InventoryManagementSystem.dtos.Response;
import com.avinash.InventoryManagementSystem.dtos.UserDTO;
import com.avinash.InventoryManagementSystem.models.User;

public interface UserService {

    Response registerUser(RegisterRequest registerRequest);

    Response loginUser(LoginRequest loginRequest);

    Response getAllUsers();

    User getCurrentLoggedInUser();

    Response getUserById(Long id);

    Response updateUser(Long id, UserDTO userDTO);

    Response deleteUser(Long id);

    Response getUserTransactions(Long id);
}
