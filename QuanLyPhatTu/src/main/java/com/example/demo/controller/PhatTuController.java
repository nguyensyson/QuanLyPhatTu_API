package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.PhatTuDto;
import com.example.demo.service.PhatTuService;

@RestController
@RequestMapping("/api/v1/management/phat-tu")
public class PhatTuController {
	
	@Autowired
	PhatTuService phatTuService;
	
	@GetMapping("/hien-thi")
	public List<PhatTuDto> HienThi(@RequestParam Optional<Integer> page) {
		return phatTuService.HienThi(page.orElse(0));
	}
	
	@PostMapping("/add")
	public PhatTuDto addPhatTu(@RequestBody PhatTuDto dto) {
		return phatTuService.addPhatTu(dto);
	}
	
	@PutMapping("/update")
	public PhatTuDto updatePhatTu(@RequestBody PhatTuDto dto) {
		return phatTuService.updatePhatTu(dto);
	}
	
	@PostMapping("/delete")
	public String deletePhatTu(@RequestParam Integer id) {
		return phatTuService.deletePhatTu(id);
	}

}
