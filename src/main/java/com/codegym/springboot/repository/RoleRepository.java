package com.codegym.springboot.repository;

import com.codegym.springboot.models.ERole;
import com.codegym.springboot.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);
}
