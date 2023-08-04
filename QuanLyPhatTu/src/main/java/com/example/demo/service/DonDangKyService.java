package com.example.demo.service;

import com.example.demo.dto.DonDangKyDto;

public interface DonDangKyService {

	DonDangKyDto taoDon(DonDangKyDto dangKyDto);
	String duyetDon(Integer id);
}
