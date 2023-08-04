package com.example.demo.dto;

import java.time.LocalDateTime;

import com.example.demo.entity.Chuas;
import com.example.demo.entity.KieuThanhVien;
import com.example.demo.entity.PhatTu;

public class PhatTuDto {

	private Integer phatTuId;
	private byte[] anhChup;
	private Boolean daHoanTuc;
	private String email;
	private Integer gioiTinh;
	private String ho;
	private LocalDateTime ngayHoanTuc;
	private LocalDateTime ngaySinh;
	private LocalDateTime ngayXuatGia;
	private String phapDanh;
	private String soDienThoai;
	private String ten;
	private String tenDem;
	private Chuas chua;
	private KieuThanhVien kieuThanhVien;
	
	public PhatTu loadData() {
		PhatTu phatTu = new PhatTu();
		phatTu.setAnhChup(anhChup);
		phatTu.setDaHoanTuc(daHoanTuc);
		phatTu.setEmail(email);
		phatTu.setGioiTinh(gioiTinh);
		phatTu.setHo(ho);
		phatTu.setNgayHoanTuc(ngayHoanTuc);
		phatTu.setNgaySinh(ngaySinh);
		phatTu.setNgayXuatGia(ngayXuatGia);
		phatTu.setPhapDanh(phapDanh);
		phatTu.setSoDienThoai(soDienThoai);
		phatTu.setTen(ten);
		phatTu.setTenDem(tenDem);
		phatTu.setChua(chua);
		phatTu.setKieuThanhVien(kieuThanhVien);
		return phatTu;
	}
	
	public PhatTu loadData(PhatTu phatTu) {
		
		phatTu.setAnhChup(anhChup);
		phatTu.setDaHoanTuc(daHoanTuc);
		phatTu.setEmail(email);
		phatTu.setGioiTinh(gioiTinh);
		phatTu.setHo(ho);
		phatTu.setNgayHoanTuc(ngayHoanTuc);
		phatTu.setNgaySinh(ngaySinh);
		phatTu.setNgayXuatGia(ngayXuatGia);
		phatTu.setPhapDanh(phapDanh);
		phatTu.setSoDienThoai(soDienThoai);
		phatTu.setTen(ten);
		phatTu.setTenDem(tenDem);
		phatTu.setChua(chua);
		phatTu.setKieuThanhVien(kieuThanhVien);
		return phatTu;
	}

	public PhatTuDto(Integer phatTuId, byte[] anhChup, Boolean daHoanTuc, String email, Integer gioiTinh, String ho,
			LocalDateTime ngayHoanTuc, LocalDateTime ngaySinh, LocalDateTime ngayXuatGia, String phapDanh,
			String soDienThoai, String ten, String tenDem, Chuas chua, KieuThanhVien kieuThanhVien) {
		this.phatTuId = phatTuId;
		this.anhChup = anhChup;
		this.daHoanTuc = daHoanTuc;
		this.email = email;
		this.gioiTinh = gioiTinh;
		this.ho = ho;
		this.ngayHoanTuc = ngayHoanTuc;
		this.ngaySinh = ngaySinh;
		this.ngayXuatGia = ngayXuatGia;
		this.phapDanh = phapDanh;
		this.soDienThoai = soDienThoai;
		this.ten = ten;
		this.tenDem = tenDem;
		this.chua = chua;
		this.kieuThanhVien = kieuThanhVien;
	}

	public PhatTuDto() {
	}

	public Integer getPhatTuId() {
		return phatTuId;
	}

	public void setPhatTuId(Integer phatTuId) {
		this.phatTuId = phatTuId;
	}

	public byte[] getAnhChup() {
		return anhChup;
	}

	public void setAnhChup(byte[] anhChup) {
		this.anhChup = anhChup;
	}

	public Boolean getDaHoanTuc() {
		return daHoanTuc;
	}

	public void setDaHoanTuc(Boolean daHoanTuc) {
		this.daHoanTuc = daHoanTuc;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh(Integer gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	public String getHo() {
		return ho;
	}

	public void setHo(String ho) {
		this.ho = ho;
	}

	public LocalDateTime getNgayHoanTuc() {
		return ngayHoanTuc;
	}

	public void setNgayHoanTuc(LocalDateTime ngayHoanTuc) {
		this.ngayHoanTuc = ngayHoanTuc;
	}

	public LocalDateTime getNgaySinh() {
		return ngaySinh;
	}

	public void setNgaySinh(LocalDateTime ngaySinh) {
		this.ngaySinh = ngaySinh;
	}

	public LocalDateTime getNgayXuatGia() {
		return ngayXuatGia;
	}

	public void setNgayXuatGia(LocalDateTime ngayXuatGia) {
		this.ngayXuatGia = ngayXuatGia;
	}

	public String getPhapDanh() {
		return phapDanh;
	}

	public void setPhapDanh(String phapDanh) {
		this.phapDanh = phapDanh;
	}

	public String getSoDienThoai() {
		return soDienThoai;
	}

	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}

	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public String getTenDem() {
		return tenDem;
	}

	public void setTenDem(String tenDem) {
		this.tenDem = tenDem;
	}

	public Chuas getChua() {
		return chua;
	}

	public void setChua(Chuas chua) {
		this.chua = chua;
	}

	public KieuThanhVien getKieuThanhVien() {
		return kieuThanhVien;
	}

	public void setKieuThanhVien(KieuThanhVien kieuThanhVien) {
		this.kieuThanhVien = kieuThanhVien;
	}
	
	
}
