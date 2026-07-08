package com.library.repository;

import com.library.entity.Role;
import com.library.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    // Login
    Optional<User> findByUsername(String username);

    Optional<User> findByEmail(String email);

    // Check existing user
    boolean existsByUsername(String username);

    boolean existsByEmail(String email);

    // Search users
    List<User> findByFirstNameContainingIgnoreCase(String firstName);

    List<User> findByLastNameContainingIgnoreCase(String lastName);

    List<User> findByUsernameContainingIgnoreCase(String username);

    List<User> findByEmailContainingIgnoreCase(String email);

    // Account status
    List<User> findByEnabled(Boolean enabled);

    // Role-based queries
    List<User> findByRolesContaining(Role role);

    // Combined search
    List<User> findByFirstNameContainingIgnoreCaseOrLastNameContainingIgnoreCase(
            String firstName,
            String lastName
    );

    // Authentication
    Optional<User> findByUsernameAndEnabledTrue(String username);

    Optional<User> findByEmailAndEnabledTrue(String email);

}