package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.ChuaDto;

public interface ChuaService {

	List<ChuaDto> getAll(Integer page);
	ChuaDto createChua(ChuaDto chuaDto);
	ChuaDto updateChua(ChuaDto chuaDto);
	ChuaDto deleteChua(Integer id);
}
