package com.example.demo.service.impl;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.DonDangKyDto;
import com.example.demo.entity.DaoTrangs;
import com.example.demo.entity.DonDangKys;
import com.example.demo.repository.DaoTrangsRepository;
import com.example.demo.repository.DonDangKysRepository;
import com.example.demo.service.DonDangKyService;

@Service
public class DonDangKyServiceImpl implements DonDangKyService {
	
	@Autowired
	DonDangKysRepository dangKysRepository;
	@Autowired
	DaoTrangsRepository daoTrangsRepository;

	@Override
	public DonDangKyDto taoDon(DonDangKyDto dangKyDto) {
		return dangKysRepository.save(dangKyDto.loadDataView()).loadDataView();
	}

	@Override
	public String duyetDon(Integer id) {
		Optional<DonDangKys> donDangKys = dangKysRepository.findById(id);
		donDangKys.get().setNgayXuLy(LocalDateTime.now());
//		set nguoi xu ly
		donDangKys.get().setTrangThaiDon(1);
		Optional<DaoTrangs> daoTrangs = daoTrangsRepository.findById(donDangKys.get().getDaoTrang().getDaoTrangId());
		daoTrangs.get().setSoThanhVienThamGia(daoTrangs.get().getSoThanhVienThamGia() + 1);
		daoTrangsRepository.save(daoTrangs.get());
	    dangKysRepository.save(donDangKys.get());
	    return "Duyệt đơn thành công";
	}

}
