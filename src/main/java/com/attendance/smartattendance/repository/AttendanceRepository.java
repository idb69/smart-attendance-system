package com.attendance.smartattendance.repository;

import java.time.LocalDate;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.attendance.smartattendance.model.Attendance;
import com.attendance.smartattendance.model.User;

public interface AttendanceRepository extends JpaRepository<Attendance, Long> {
    boolean existsByStudentAndAttendanceDate(User student, LocalDate attendanceDate);
    List<Attendance> findByStudentOrderByAttendanceDateDesc(User student);
    List<Attendance> findAllByOrderByAttendanceDateDesc();
    long countByStudent(User student);
}
