package com.wilfredo.rentacar.services.auth;

import org.springframework.stereotype.Service;

import com.wilfredo.rentacar.dto.SignupRequest;
import com.wilfredo.rentacar.dto.UserDto;
import com.wilfredo.rentacar.entity.User;
import com.wilfredo.rentacar.enums.UserRole;
import com.wilfredo.rentacar.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService{

    // Inyección de dependencia del repositorio de usuarios
    private final UserRepository userRepository;

    @Override
    public UserDto createCustomer(SignupRequest signupRequest) {
              // Crear un nuevo objeto User y asignar los valores del SignupRequest
        User user = new User();
        user.setUsername(signupRequest.getName());
        user.setEmail(signupRequest.getEmail());
        user.setPassword(signupRequest.getPassword());
        user.setUserRole(UserRole.CUSTOMER);
         // Guardar el usuario en la base de datos
        User createdUser = userRepository.save(user);
        // Crear un DTO (Data Transfer Object) para el usuario creado
        UserDto userDto = new UserDto();
        userDto.setId(createdUser.getId());

       return userDto;
    }

    @Override
    public boolean hasCustomerWithEmail(String email) {
        // Verificar si existe un usuario con el correo electrónico dado
        return userRepository.findFirstByEmail(email).isPresent();
    }

}
