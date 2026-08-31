package com.attendance.smartattendance;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.attendance.smartattendance.model.Role;
import com.attendance.smartattendance.model.User;
import com.attendance.smartattendance.repository.UserRepository;

@SpringBootApplication
public class SmartAttendanceSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(SmartAttendanceSystemApplication.class, args);
    }

    @Bean
    CommandLineRunner createDefaultAdmin(
            UserRepository userRepository,
            PasswordEncoder passwordEncoder) {

        return args -> {
            if (userRepository.findByEmail("admin@attendance.com").isEmpty()) {

                User admin = new User(
                        "System Admin",
                        "admin@attendance.com",
                        passwordEncoder.encode("admin123"),
                        Role.ADMIN
                );

                userRepository.save(admin);
            }
        };
    }
}
