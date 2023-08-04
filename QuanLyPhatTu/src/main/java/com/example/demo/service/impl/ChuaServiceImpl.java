package com.example.demo.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.demo.dto.ChuaDto;
import com.example.demo.entity.Chuas;
import com.example.demo.repository.ChuasRepository;
import com.example.demo.service.ChuaService;

@Service
public class ChuaServiceImpl implements ChuaService {
	
	@Autowired
	private ChuasRepository chuasRepository;

	@Override
	public List<ChuaDto> getAll(Integer page) {
		Pageable pageable = PageRequest.of(page, 10);
		Page<Chuas> pages = chuasRepository.findAll(pageable);
		List<ChuaDto> chuaDtos = new ArrayList<>();
		for (Chuas i : pages.getContent()) {
			ChuaDto dto = i.loadDataView();
			chuaDtos.add(dto);
		}
		return chuaDtos;
	}

	@Override
	public ChuaDto createChua(ChuaDto chuaDto) {
		Chuas chuas = chuasRepository.save(chuaDto.loadDataView());
		return chuas.loadDataView();
	}

	@Override
	public ChuaDto updateChua(ChuaDto chuaDto) {
		Chuas chuas = chuaDto.loadDataView(chuasRepository.findById(chuaDto.getChuaId()).get());
		return chuasRepository.save(chuas).loadDataView();
	}

	@Override
	public ChuaDto deleteChua(Integer id) {
		Optional<Chuas> chuas = chuasRepository.findById(id);
		chuasRepository.delete(chuas.get());
		return chuas.get().loadDataView();
	}

	
}
