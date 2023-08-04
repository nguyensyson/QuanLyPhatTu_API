package com.example.demo.entity;

import java.time.LocalDateTime;
import java.util.List;

import com.example.demo.dto.ChuaDto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "chuas")
public class Chuas {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "chuaid")
	private Integer chuaId;
	
	@Column(name = "cap_nhat")
	private LocalDateTime capNhat;
	
	@Column(name = "dia_chi")
	private String diaChi;
	
	@Column(name = "ngay_thanh_lap")
	private LocalDateTime ngayThanhLap;
	
	@Column(name = "ten_chua")
	private String tenChua;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "tru_tri", referencedColumnName = "phat_tu_id")
	private PhatTu truTri;
	
	@OneToMany(mappedBy = "chua", fetch = FetchType.LAZY)
	private List<PhatTu> listPhatTu;
	
	public ChuaDto loadDataView() {
		ChuaDto chuaDto = new ChuaDto();
		chuaDto.setCapNhat(capNhat);
		chuaDto.setChuaId(chuaId);
		chuaDto.setDiaChi(diaChi);
		chuaDto.setListPhatTu(listPhatTu);
		chuaDto.setNgayThanhLap(ngayThanhLap);
		chuaDto.setTenChua(tenChua);
		chuaDto.setTruTri(truTri);
		return chuaDto;
	}

	public Chuas(Integer chuaId, LocalDateTime capNhat, String diaChi, LocalDateTime ngayThanhLap, String tenChua,
			PhatTu truTri, List<PhatTu> listPhatTu) {
		this.chuaId = chuaId;
		this.capNhat = capNhat;
		this.diaChi = diaChi;
		this.ngayThanhLap = ngayThanhLap;
		this.tenChua = tenChua;
		this.truTri = truTri;
		this.listPhatTu = listPhatTu;
	}

	public Chuas() {
	}

	public Integer getChuaId() {
		return chuaId;
	}

	public void setChuaId(Integer chuaId) {
		this.chuaId = chuaId;
	}

	public LocalDateTime getCapNhat() {
		return capNhat;
	}

	public void setCapNhat(LocalDateTime capNhat) {
		this.capNhat = capNhat;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public LocalDateTime getNgayThanhLap() {
		return ngayThanhLap;
	}

	public void setNgayThanhLap(LocalDateTime ngayThanhLap) {
		this.ngayThanhLap = ngayThanhLap;
	}

	public String getTenChua() {
		return tenChua;
	}

	public void setTenChua(String tenChua) {
		this.tenChua = tenChua;
	}

	public PhatTu getTruTri() {
		return truTri;
	}

	public void setTruTri(PhatTu truTri) {
		this.truTri = truTri;
	}

	public List<PhatTu> getListPhatTu() {
		return listPhatTu;
	}

	public void setListPhatTu(List<PhatTu> listPhatTu) {
		this.listPhatTu = listPhatTu;
	}

	
}
