package com.example.demo.dto;

import java.time.LocalDateTime;

import com.example.demo.entity.DaoTrangs;
import com.example.demo.entity.DonDangKys;
import com.example.demo.entity.PhatTu;

public class DonDangKyDto {

	private Integer donDangKyId;
	private LocalDateTime ngayGuiDon;
	private LocalDateTime ngayXuLy;
	private PhatTu nguoiXuLy;
	private Integer trangThaiDon;
	private DaoTrangs daoTrang;
	private PhatTu phatTu;
	
	public DonDangKys loadDataView() {
		DonDangKys donDangKys = new DonDangKys();
		donDangKys.setDaoTrang(daoTrang);
		donDangKys.setDonDangKyId(donDangKyId);
		donDangKys.setNgayGuiDon(ngayGuiDon);
		donDangKys.setNgayXuLy(ngayXuLy);
		donDangKys.setNguoiXuLy(nguoiXuLy);
		donDangKys.setPhatTu(phatTu);
		donDangKys.setTrangThaiDon(trangThaiDon);
		return donDangKys;
	}
	
	public DonDangKyDto(Integer donDangKyId, LocalDateTime ngayGuiDon, LocalDateTime ngayXuLy, PhatTu nguoiXuLy,
			Integer trangThaiDon, DaoTrangs daoTrang, PhatTu phatTu) {
		this.donDangKyId = donDangKyId;
		this.ngayGuiDon = ngayGuiDon;
		this.ngayXuLy = ngayXuLy;
		this.nguoiXuLy = nguoiXuLy;
		this.trangThaiDon = trangThaiDon;
		this.daoTrang = daoTrang;
		this.phatTu = phatTu;
	}

	public DonDangKyDto() {
	}

	public Integer getDonDangKyId() {
		return donDangKyId;
	}

	public void setDonDangKyId(Integer donDangKyId) {
		this.donDangKyId = donDangKyId;
	}

	public LocalDateTime getNgayGuiDon() {
		return ngayGuiDon;
	}

	public void setNgayGuiDon(LocalDateTime ngayGuiDon) {
		this.ngayGuiDon = ngayGuiDon;
	}

	public LocalDateTime getNgayXuLy() {
		return ngayXuLy;
	}

	public void setNgayXuLy(LocalDateTime ngayXuLy) {
		this.ngayXuLy = ngayXuLy;
	}

	public PhatTu getNguoiXuLy() {
		return nguoiXuLy;
	}

	public void setNguoiXuLy(PhatTu nguoiXuLy) {
		this.nguoiXuLy = nguoiXuLy;
	}

	public Integer getTrangThaiDon() {
		return trangThaiDon;
	}

	public void setTrangThaiDon(Integer trangThaiDon) {
		this.trangThaiDon = trangThaiDon;
	}

	public DaoTrangs getDaoTrang() {
		return daoTrang;
	}

	public void setDaoTrang(DaoTrangs daoTrang) {
		this.daoTrang = daoTrang;
	}

	public PhatTu getPhatTu() {
		return phatTu;
	}

	public void setPhatTu(PhatTu phatTu) {
		this.phatTu = phatTu;
	}
	
}
