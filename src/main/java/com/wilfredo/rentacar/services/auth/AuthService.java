package com.wilfredo.rentacar.services.auth;

import com.wilfredo.rentacar.dto.SignupRequest;
import com.wilfredo.rentacar.dto.UserDto;

public interface AuthService {

// Método para crear un cliente a partir de SignupRequest
UserDto createCustomer(SignupRequest signupRequest);

// Método para verificar si ya existe un cliente con un correo electrónico dado
boolean hasCustomerWithEmail(String email);
}
