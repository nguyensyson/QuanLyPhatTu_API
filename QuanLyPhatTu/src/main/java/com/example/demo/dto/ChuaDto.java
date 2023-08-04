package com.example.demo.dto;

import java.time.LocalDateTime;
import java.util.List;

import com.example.demo.entity.Chuas;
import com.example.demo.entity.PhatTu;

public class ChuaDto {

	private Integer chuaId;
	private LocalDateTime capNhat;
	private String diaChi;
	private LocalDateTime ngayThanhLap;
	private String tenChua;
	private PhatTu truTri;
	private List<PhatTu> listPhatTu;
	
	public Chuas loadDataView() {
		Chuas chuas = new Chuas();
		chuas.setCapNhat(capNhat);
		chuas.setDiaChi(diaChi);
		chuas.setNgayThanhLap(ngayThanhLap);
		chuas.setTenChua(tenChua);
		chuas.setTruTri(truTri);
		return chuas;
	}
	
	public Chuas loadDataView(Chuas chuas) {
		chuas.setCapNhat(capNhat);
		chuas.setDiaChi(diaChi);
		chuas.setNgayThanhLap(ngayThanhLap);
		chuas.setTenChua(tenChua);
		chuas.setTruTri(truTri);
		return chuas;
	}
	
	public ChuaDto(Integer chuaId, LocalDateTime capNhat, String diaChi, LocalDateTime ngayThanhLap, String tenChua,
			PhatTu truTri, List<PhatTu> listPhatTu) {
		this.chuaId = chuaId;
		this.capNhat = capNhat;
		this.diaChi = diaChi;
		this.ngayThanhLap = ngayThanhLap;
		this.tenChua = tenChua;
		this.truTri = truTri;
		this.listPhatTu = listPhatTu;
	}

	public ChuaDto() {
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
