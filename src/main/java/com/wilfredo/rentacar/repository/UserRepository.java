package com.wilfredo.rentacar.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wilfredo.rentacar.entity.User;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    // Busca el primer usuario con el correo electrónico dado
    Optional<User> findFirstByEmail(String email);
}
