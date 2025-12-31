package com.fitness.userservice.repository;

import com.fitness.userservice.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users, Long> {
    Boolean existsByEmail(String email);
}
