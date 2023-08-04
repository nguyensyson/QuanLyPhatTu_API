package com.example.demo.entity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.example.demo.dto.KieuThanhVienDto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "kieu_thanh_vien")
public class KieuThanhVien {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "kieu_thanh_vien_id")
	private Integer kieuThanhVienId;
	
	@Column(name = "code")
	private String code;
	
	@Column(name = "ten_kieu")
	private String tenKieu;
	
	@OneToMany(mappedBy = "kieuThanhVien", fetch = FetchType.LAZY)
	private List<PhatTu> listPhatTu;
	
	public KieuThanhVienDto loadData() {
		return new KieuThanhVienDto(kieuThanhVienId, code, tenKieu);
	}

	public KieuThanhVien(Integer kieuThanhVienId, String code, String tenKieu, List<PhatTu> listPhatTu) {
		this.kieuThanhVienId = kieuThanhVienId;
		this.code = code;
		this.tenKieu = tenKieu;
		this.listPhatTu = listPhatTu;
	}

	public KieuThanhVien() {
	}

	public Integer getKieuThanhVienId() {
		return kieuThanhVienId;
	}

	public void setKieuThanhVienId(Integer kieuThanhVienId) {
		this.kieuThanhVienId = kieuThanhVienId;
	}

	public List<PhatTu> getListPhatTu() {
		return listPhatTu;
	}

	public void setListPhatTu(List<PhatTu> listPhatTu) {
		this.listPhatTu = listPhatTu;
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
	
	public List<SimpleGrantedAuthority> getAuthorities() {
		List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_" + tenKieu));
        return authorities;
	}

	
}
