package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.PhatTuDto;
import com.example.demo.dto.ResetPasswordDto;
import com.example.demo.entity.PhatTu;

import jakarta.mail.MessagingException;

public interface PhatTuService {

	List<PhatTuDto> HienThi(Integer page);
	PhatTuDto addPhatTu(PhatTuDto dto);
	PhatTuDto updatePhatTu(PhatTuDto dto);
	String deletePhatTu(Integer id);
	void sendOtpEmail(String email) throws MessagingException;
	String resetPassword(ResetPasswordDto dto);
}
