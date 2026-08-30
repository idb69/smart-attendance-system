package com.attendance.smartattendance.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.attendance.smartattendance.model.Attendance;
import com.attendance.smartattendance.model.AttendanceSession;
import com.attendance.smartattendance.model.User;
import com.attendance.smartattendance.repository.AttendanceRepository;
import com.attendance.smartattendance.repository.AttendanceSessionRepository;

@Service
public class AttendanceService {

    private final AttendanceRepository attendanceRepository;
    private final AttendanceSessionRepository sessionRepository;

    public AttendanceService(AttendanceRepository attendanceRepository,
                             AttendanceSessionRepository sessionRepository) {
        this.attendanceRepository = attendanceRepository;
        this.sessionRepository = sessionRepository;
    }

    public AttendanceSession createSession() {
        String token = UUID.randomUUID().toString();
        AttendanceSession session = new AttendanceSession(token, LocalDateTime.now().plusMinutes(10));
        return sessionRepository.save(session);
    }

    public String markAttendance(User student, String token) {
        AttendanceSession session = sessionRepository.findByToken(token)
                .orElse(null);

        if (session == null || !session.isActive() || LocalDateTime.now().isAfter(session.getExpiresAt())) {
            return "Invalid or expired QR attendance session.";
        }

        if (attendanceRepository.existsByStudentAndAttendanceDate(student, LocalDate.now())) {
            return "Attendance already marked for today.";
        }

        attendanceRepository.save(new Attendance(student, LocalDate.now(), LocalDateTime.now()));
        return "Attendance marked successfully!";
    }

    public List<Attendance> studentHistory(User student) {
        return attendanceRepository.findByStudentOrderByAttendanceDateDesc(student);
    }

    public List<Attendance> allAttendance() {
        return attendanceRepository.findAllByOrderByAttendanceDateDesc();
    }
}
