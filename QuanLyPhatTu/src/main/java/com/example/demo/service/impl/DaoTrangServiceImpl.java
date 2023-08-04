package com.example.demo.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.demo.dto.DaoTrangDto;
import com.example.demo.entity.DaoTrangs;
import com.example.demo.entity.PhatTu;
import com.example.demo.repository.DaoTrangsRepository;
import com.example.demo.repository.PhatTuRepository;
import com.example.demo.service.DaoTrangService;

@Service
public class DaoTrangServiceImpl implements DaoTrangService {
	
	@Autowired
	private DaoTrangsRepository daoTrangsRepository;
	
	@Autowired
	private PhatTuRepository phatTuRepository;

	@Override
	public List<DaoTrangDto> getAll(Integer page) {
		Pageable pageable = PageRequest.of(page, 10);
		Page<DaoTrangs> pages = daoTrangsRepository.findAll(pageable);
		List<DaoTrangDto> daoTrangDtos = new ArrayList<>();
		for (DaoTrangs i : pages.getContent()) {
			DaoTrangDto dto = i.loadDataView();
			daoTrangDtos.add(dto);
		}
		return daoTrangDtos;
	}

	@Override
	public DaoTrangDto createDaoTrang(DaoTrangDto daoTrangDto) {
		
		DaoTrangs daoTrangs = new DaoTrangs();
		daoTrangs.setDaKetThuc(daoTrangDto.getDaKetThuc());
		daoTrangs.setNguoiTruTri(phatTuRepository.findById(daoTrangDto.getNguoiTruTri()).get());
		daoTrangs.setNoiDung(daoTrangDto.getNoiDung());
		daoTrangs.setNoiToChuc(daoTrangDto.getNoiToChuc());
		daoTrangs.setThoiGianToChuc(daoTrangDto.getThoiGianToChuc());
		daoTrangs.setSoThanhVienThamGia(daoTrangDto.getSoThanhVienThamGia());
		return daoTrangsRepository.save(daoTrangs).loadDataView();
	}

	@Override
	public DaoTrangDto updateDaotrang(DaoTrangDto daoTrangDto) {
		DaoTrangs daoTrangs = daoTrangDto.loadDataView(daoTrangsRepository.findById(daoTrangDto.getDaoTrangId()).get());
		return daoTrangsRepository.save(daoTrangs).loadDataView();
	}

	@Override
	public DaoTrangDto deleteDaoTrang(Integer id) {
		Optional<DaoTrangs> daoTrang = daoTrangsRepository.findById(id);
		daoTrangsRepository.delete(daoTrang.get());
		return daoTrang.get().loadDataView();
	}

}
