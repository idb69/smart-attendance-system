package com.attendance.smartattendance.controller;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.attendance.smartattendance.model.User;
import com.attendance.smartattendance.repository.UserRepository;
import com.attendance.smartattendance.service.AttendanceService;

@Controller
public class AttendanceController {

    private final AttendanceService attendanceService;
    private final UserRepository userRepository;

    public AttendanceController(AttendanceService attendanceService, UserRepository userRepository) {
        this.attendanceService = attendanceService;
        this.userRepository = userRepository;
    }

    @GetMapping("/attendance/mark")
    public String markAttendance(@RequestParam String token, Principal principal, Model model) {
        User student = userRepository.findByEmail(principal.getName()).orElseThrow();
        String message = attendanceService.markAttendance(student, token);
        model.addAttribute("message", message);
        return "attendance-result";
    }
}
