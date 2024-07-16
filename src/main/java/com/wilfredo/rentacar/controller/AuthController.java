package com.wilfredo.rentacar.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wilfredo.rentacar.dto.SignupRequest;
import com.wilfredo.rentacar.dto.UserDto;
import com.wilfredo.rentacar.services.auth.AuthService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/signup")
    public ResponseEntity<?> signupCustomer(@RequestBody SignupRequest signupRequest) {
        String email = signupRequest.getEmail();
// Verifica si ya existe un cliente con el mismo correo electrónico
        if (authService.hasCustomerWithEmail(email)) {
            return ResponseEntity.badRequest().body("Email already exists");
        }
 // Si no existe, crea un nuevo cliente
        UserDto createdCustomerDto = authService.createCustomer(signupRequest);
        if (createdCustomerDto == null) {
            return ResponseEntity.badRequest().body("Customer not created");
        }
// Devuelve una respuesta con el DTO del cliente creado y el código de estado 201 (CREATED)
        return new ResponseEntity<>(createdCustomerDto, HttpStatus.CREATED);
    }
}

