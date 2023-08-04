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

import com.example.demo.dto.ChuaDto;
import com.example.demo.service.ChuaService;

@RestController
@RequestMapping("/api/v1/management/chua")
public class ChuaController {

	@Autowired
	private ChuaService chuaService;
	
	@GetMapping("/hien-thi")
	public List<ChuaDto> hienThi(@RequestParam Optional<Integer> page) {
		return chuaService.getAll(page.orElse(0));
	}
	
	@PostMapping("/add")
	public ChuaDto addChua(@RequestBody ChuaDto chuaDto) {
		return chuaService.createChua(chuaDto);
	}
	
	@PutMapping("/update")
	public ChuaDto updateChua(@RequestBody ChuaDto chuaDto) {
		return chuaService.updateChua(chuaDto);
	}
	
	@DeleteMapping("/delete")
	public ChuaDto deleteChua(@RequestParam Integer id) {
		return chuaService.deleteChua(id);
	}
}
