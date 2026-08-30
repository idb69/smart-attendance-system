package com.attendance.smartattendance.controller;

import java.io.ByteArrayOutputStream;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.time.format.DateTimeFormatter;
import java.util.Base64;

import javax.imageio.ImageIO;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.attendance.smartattendance.model.AttendanceSession;
import com.attendance.smartattendance.model.Role;
import com.attendance.smartattendance.repository.AttendanceRepository;
import com.attendance.smartattendance.repository.UserRepository;
import com.attendance.smartattendance.service.AttendanceService;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

@Controller
public class AdminController {

    private final UserRepository userRepository;
    private final AttendanceRepository attendanceRepository;
    private final AttendanceService attendanceService;

    public AdminController(UserRepository userRepository,
                           AttendanceRepository attendanceRepository,
                           AttendanceService attendanceService) {
        this.userRepository = userRepository;
        this.attendanceRepository = attendanceRepository;
        this.attendanceService = attendanceService;
    }

    @GetMapping("/admin/dashboard")
    public String dashboard(Model model) {
        model.addAttribute("studentCount", userRepository.countByRole(Role.STUDENT));
        model.addAttribute("attendanceCount", attendanceRepository.count());
        model.addAttribute("attendanceList", attendanceService.allAttendance());
        return "admin-dashboard";
    }

    @GetMapping("/admin/generate-qr")
    public String generateQr(Model model) throws Exception {
        AttendanceSession session = attendanceService.createSession();
        String attendanceUrl = "/attendance/mark?token=" +
                URLEncoder.encode(session.getToken(), StandardCharsets.UTF_8);

        QRCodeWriter writer = new QRCodeWriter();
        BitMatrix matrix = writer.encode(attendanceUrl, BarcodeFormat.QR_CODE, 300, 300);

        ByteArrayOutputStream output = new ByteArrayOutputStream();
        ImageIO.write(MatrixToImageWriter.toBufferedImage(matrix), "PNG", output);

        model.addAttribute("qrImage", Base64.getEncoder().encodeToString(output.toByteArray()));
        model.addAttribute("token", session.getToken());
        model.addAttribute("expiresAt",
                session.getExpiresAt().format(DateTimeFormatter.ofPattern("dd MMM yyyy HH:mm")));

        return "qr";
    }
}
