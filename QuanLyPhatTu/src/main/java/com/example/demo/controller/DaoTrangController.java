package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.DaoTrangDto;
import com.example.demo.service.DaoTrangService;

@RestController
@RequestMapping("/api/v1/management/dao-trang")
public class DaoTrangController {

	@Autowired
	private DaoTrangService daoTrangService;
	
	@GetMapping("/hien-thi")
	public List<DaoTrangDto> hienThi(@RequestParam Optional<Integer> page) {
		return daoTrangService.getAll(page.orElse(0));
	}
	
	@PostMapping("/add")
	public DaoTrangDto addDaoTrang(@RequestBody DaoTrangDto daoTrangDto) {
		return daoTrangService.createDaoTrang(daoTrangDto);
	}
	
	@PutMapping("/update")
	public DaoTrangDto updateDaoTrang(@RequestBody DaoTrangDto daoTrangDto) {
		return daoTrangService.updateDaotrang(daoTrangDto);
	}
	
	@DeleteMapping("/delete")
	public DaoTrangDto deleteDaoTrang(@RequestParam Integer id) {
		return daoTrangService.deleteDaoTrang(id);
	}
	
}
