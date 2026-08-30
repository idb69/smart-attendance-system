package com.attendance.smartattendance.controller;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.attendance.smartattendance.model.User;
import com.attendance.smartattendance.repository.AttendanceRepository;
import com.attendance.smartattendance.repository.UserRepository;
import com.attendance.smartattendance.service.AttendanceService;

@Controller
public class StudentController {

    private final UserRepository userRepository;
    private final AttendanceRepository attendanceRepository;
    private final AttendanceService attendanceService;

    public StudentController(UserRepository userRepository,
                             AttendanceRepository attendanceRepository,
                             AttendanceService attendanceService) {
        this.userRepository = userRepository;
        this.attendanceRepository = attendanceRepository;
        this.attendanceService = attendanceService;
    }

    @GetMapping("/student/dashboard")
    public String dashboard(Principal principal, Model model) {
        User user = userRepository.findByEmail(principal.getName()).orElseThrow();
        model.addAttribute("user", user);
        model.addAttribute("attendanceCount", attendanceRepository.countByStudent(user));
        model.addAttribute("history", attendanceService.studentHistory(user));
        return "student-dashboard";
    }
}
