package com.example.demo.dto;

import com.example.demo.entity.KieuThanhVien;

public class KieuThanhVienDto {

	private Integer kieuThanhVienId;
	private String code;
	private String tenKieu;
	
	public KieuThanhVien loadData() {
		return new KieuThanhVien(kieuThanhVienId, code, tenKieu, null);
	}
	
	public KieuThanhVienDto(Integer kieuThanhVienId, String code, String tenKieu) {
		this.kieuThanhVienId = kieuThanhVienId;
		this.code = code;
		this.tenKieu = tenKieu;
	}

	public KieuThanhVienDto() {
	}

	public Integer getKieuThanhVienId() {
		return kieuThanhVienId;
	}

	public void setKieuThanhVienId(Integer kieuThanhVienId) {
		this.kieuThanhVienId = kieuThanhVienId;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getTenKieu() {
		return tenKieu;
	}

	public void setTenKieu(String tenKieu) {
		this.tenKieu = tenKieu;
	}
	
}
