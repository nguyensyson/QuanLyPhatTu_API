package com.example.demo.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.dto.PhatTuDto;
import com.example.demo.dto.ResetPasswordDto;
import com.example.demo.entity.PhatTu;
import com.example.demo.repository.PhatTuRepository;
import com.example.demo.service.PhatTuService;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class PhatTuServiceImpl implements PhatTuService {
	
	@Autowired
	PhatTuRepository phatTuRepository;
	@Autowired
    private JavaMailSender javaMailSender;
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public List<PhatTuDto> HienThi(Integer page) {
		List<PhatTuDto> phatTuDtos = new ArrayList<>();
		Pageable pageable = PageRequest.of(page, 10);
		Page<PhatTu> phatTus = phatTuRepository.findAll(pageable);
		
		for (PhatTu i : phatTus.getContent()) {
			PhatTuDto dto = i.LoadDataViewDTO();
			phatTuDtos.add(dto);
		}
		return phatTuDtos;
	}

	@Override
	public PhatTuDto addPhatTu(PhatTuDto dto) {
		return phatTuRepository.save(dto.loadData()).LoadDataViewDTO();
	}

	@Override
	public PhatTuDto updatePhatTu(PhatTuDto dto) {
		Optional<PhatTu> phatTu = phatTuRepository.findById(dto.getPhatTuId());
		return phatTuRepository.save(dto.loadData(phatTu.get())).LoadDataViewDTO();
	}

	@Override
	public String deletePhatTu(Integer id) {
		Optional<PhatTu> phatTu = phatTuRepository.findById(id);
		phatTu.get().setStatusPhatTu(0);
		phatTuRepository.save(phatTu.get());
		return "Xoa phat tu thanh cong";
	}

	@Override
	public void sendOtpEmail(String email) throws MessagingException {
		
		Optional<PhatTu> phatTu = phatTuRepository.findByEmail(email);
		
		String otp = generateOtp();
		phatTu.get().setResetPasswordToken(otp);
		phatTuRepository.save(phatTu.get());
		
		MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);

        helper.setTo(email);
        helper.setSubject("Xác nhận OTP - Chức năng quên mật khẩu");
        helper.setText("Mã OTP của bạn là: " + otp);

        javaMailSender.send(message);
	}
	
	private String generateOtp() {
        // Mã OTP ngẫu nhiên có thể được tạo theo ý muốn
        Random random = new Random();
        int otpNumber = 100000 + random.nextInt(900000); // Mã OTP 6 chữ số
        return String.valueOf(otpNumber);
    }

	@Override
	public String resetPassword(ResetPasswordDto dto) {
		Optional<PhatTu> phatTu = phatTuRepository.findByEmail(dto.getEmail());
		
		if(!dto.getOtp().equals(phatTu.get().getResetPasswordToken())) {
			return "Mã OTP Không đúng";
		}
		
		phatTu.get().setResetPasswordToken("");
		phatTu.get().setPassword(passwordEncoder.encode(dto.getNewPassword()));
		phatTuRepository.save(phatTu.get());
		
		return "Đổi mật khẩu thành công";
	}

}
