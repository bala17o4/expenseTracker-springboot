package com.project.expenseTracker.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserjpaRepository extends JpaRepository<UserDTO, Integer> {
 boolean existsByName(String name);

 Optional<UserDTO> findByName(String name);
}
