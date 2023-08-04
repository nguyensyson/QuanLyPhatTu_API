package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.DaoTrangDto;

public interface DaoTrangService {

	List<DaoTrangDto> getAll(Integer page);
	DaoTrangDto createDaoTrang(DaoTrangDto daoTrangDto);
	DaoTrangDto updateDaotrang(DaoTrangDto daoTrangDto);
	DaoTrangDto deleteDaoTrang(Integer id);
}
