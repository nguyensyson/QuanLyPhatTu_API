package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.ResetPasswordDto;
import com.example.demo.service.PhatTuService;

@RestController
@RequestMapping("/api/v1/auth")
public class ForgotPasswordController {

	@Autowired
	private PhatTuService phatTuService;

	@PostMapping("/forgot-password")
	public String processForgotPassword(@RequestParam String email) {
		try {
			phatTuService.sendOtpEmail(email);
			return "Mã OTP đã được gửi đến địa chỉ email của bạn.";
		} catch (Exception e) {
			e.printStackTrace();
            return "Có lỗi xảy ra trong quá trình gửi email. Vui lòng thử lại sau.";
		}
	}
	
	@PostMapping("/reset-password")
	public String resetPassword(@RequestBody ResetPasswordDto dto) {
		return phatTuService.resetPassword(dto);
	}
	
}
