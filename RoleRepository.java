package com.library.repository;

import com.library.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

    // Find role by name
    Optional<Role> findByName(String name);

    // Check if role exists
    boolean existsByName(String name);

    // Search roles
    List<Role> findByNameContainingIgnoreCase(String name);

}