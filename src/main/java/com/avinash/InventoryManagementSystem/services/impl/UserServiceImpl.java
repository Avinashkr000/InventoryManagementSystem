package com.avinash.InventoryManagementSystem.services.impl;


import com.avinash.InventoryManagementSystem.dtos.LoginRequest;
import com.avinash.InventoryManagementSystem.dtos.RegisterRequest;
import com.avinash.InventoryManagementSystem.dtos.Response;
import com.avinash.InventoryManagementSystem.dtos.UserDTO;
import com.avinash.InventoryManagementSystem.enums.UserRole;
import com.avinash.InventoryManagementSystem.exceptions.InvalidCredentialsException;
import com.avinash.InventoryManagementSystem.exceptions.NotFoundException;
import com.avinash.InventoryManagementSystem.models.User;
import com.avinash.InventoryManagementSystem.repositories.UserRepository;
import com.avinash.InventoryManagementSystem.security.JwtUtils;
import com.avinash.InventoryManagementSystem.services.UserService;
import io.jsonwebtoken.security.Password;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.ReactiveSecurityContextHolder;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j

public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final ModelMapper modelMapper;
    private final JwtUtils jwtUtils;

    @Override
    public Response registerUser(RegisterRequest registerRequest) {

        UserRole role = UserRole.MANAGER;

        if (registerRequest.getRole() != null){

            role = registerRequest.getRole();

        }

        User userToSave = User.builder()
                .name(registerRequest.getName())
                .email(registerRequest.getEmail())
                .password(passwordEncoder.encode(registerRequest.getPassword()))
                .role(role)
                .build();

        return Response.builder()
                .status(200)
                .message("User was successfully registered")
                .build();
    }

    @Override
    public Response loginUser(LoginRequest loginRequest) {

        User user = userRepository.findByEmail(loginRequest.getEmail())
                .orElseThrow(()->new NotFoundException("Email Not Found"));

        if (!passwordEncoder.matches(loginRequest.getPassword(), user.getPassword())) {
            throw new InvalidCredentialsException("Password Does Not Match");
        }

        String token = jwtUtils.generateToken(user.getEmail());

        return Response.builder()
                .status(200)
                .message("User Logged in Successfully")
                .role(String.valueOf(user.getRole()))
                .token(token)
                .expirationTime("6 months")
                .build();

    }


    @Override
    public Response getAllUsers() {

        List<User> users = userRepository.findAll(Sort.by(Sort.Direction.DESC, "id"));

        users.forEach(user -> user.setTransanctions(null));

        List<UserDTO> userDTOS = modelMapper.map(users, new TypeToken<List<UserDTO>>(){}.getType());

        return Response.builder()
                .status(200)
                .message("success")
                .users(userDTOS)
                .build();

    }

    @Override
    public User getCurrentLoggedInUser() {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        String email = authentication.getName();

        User user = userRepository.findByEmail(email).orElseThrow(()-> new NotFoundException(("User Not Found")));

        user.setTransanctions(null);
        return user;


    }

    @Override
    public Response getUserById(Long id) {

        User user = userRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("User Not Found"));

        UserDTO userDTO = modelMapper.map(user, UserDTO.class);

        userDTO.setTransanctions(null);

        return Response.builder()
                .status(200)
                .message("success")
                .user(userDTO)
                .build();

    }

    @Override
    public Response updateUser(Long id, UserDTO userDTO) {

        User existingUser = userRepository.findById(id).orElseThrow(() -> new NotFoundException("User Not Found"));

        if(userDTO.getEmail()!= null) existingUser.setEmail(userDTO.getEmail());
        if(userDTO.getPhoneNumber() != null) existingUser.setPhoneNumber(userDTO.getPhoneNumber());
        if(userDTO.getName() != null) existingUser.setName(userDTO.getName());
        if(userDTO.getRole() != null) existingUser.setRole(userDTO.getRole());


        if(userDTO.getPassword() != null && !userDTO.getPassword().isEmpty()){
            existingUser.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        }

        userRepository.save(existingUser);

        return Response.builder()
                .status(200)
                .message("User Successfully Updated")
                .build();


    }

    @Override
    public Response deleteUser(Long id) {
        userRepository.findById(id).orElseThrow(() -> new NotFoundException("User Not Found"));

        userRepository.deleteById(id);

        return Response.builder()
                .status(200)
                .message("User Successfully Deleted")
                .build();

    }

    @Override
    public Response getUserTransactions(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new NotFoundException("User Not Found"));

        UserDTO userDTO = modelMapper.map(user, UserDTO.class);

        userDTO.getTransanctions().forEach(transactionDTO -> {
            transactionDTO.setUser(null);
            transactionDTO.setSupplier(null);
        });

        return Response.builder()
                .status(200)
                .message("success")
                .user(userDTO)
                .build();
    }
}
