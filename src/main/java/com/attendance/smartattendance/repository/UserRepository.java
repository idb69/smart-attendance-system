package com.attendance.smartattendance.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.attendance.smartattendance.model.Role;
import com.attendance.smartattendance.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
    long countByRole(Role role);
}
