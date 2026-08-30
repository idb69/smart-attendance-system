package com.attendance.smartattendance.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.attendance.smartattendance.model.AttendanceSession;

public interface AttendanceSessionRepository extends JpaRepository<AttendanceSession, Long> {
    Optional<AttendanceSession> findByToken(String token);
}
