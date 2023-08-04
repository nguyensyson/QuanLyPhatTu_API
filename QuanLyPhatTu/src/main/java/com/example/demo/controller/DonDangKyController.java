package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.DonDangKyDto;
import com.example.demo.service.DonDangKyService;

@RestController
public class DonDangKyController {
	
	@Autowired
	DonDangKyService donDangKyService;

	@PostMapping("/api/v1/user/tao")
	public DonDangKyDto taoDon(@RequestBody DonDangKyDto dangKyDto) {
		return donDangKyService.taoDon(dangKyDto);
	}
	
	@PutMapping("/api/v1/management/dang-ky-don/duyet-don")
	public String duyetDon(@RequestParam Integer id) {
		return donDangKyService.duyetDon(id);
	}
	
}
