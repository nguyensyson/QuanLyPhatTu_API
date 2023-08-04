package com.example.demo.entity;

import java.time.LocalDateTime;

import com.example.demo.dto.DonDangKyDto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "don_dang_kys")
public class DonDangKys {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "don_dang_kyid")
	private Integer donDangKyId;
	
	@Column(name = "ngay_gui_don")
	private LocalDateTime ngayGuiDon;
	
	@Column(name = "ngay_xu_ly")
	private LocalDateTime ngayXuLy;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "nguoi_xu_ly", referencedColumnName = "phat_tu_id")
	private PhatTu nguoiXuLy;
	
	@Column(name = "trang_thai_don")
	private Integer trangThaiDon;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "dao_trangid", referencedColumnName = "dao_trang_id")
	private DaoTrangs daoTrang;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "phat_tu_id", referencedColumnName = "phat_tu_id")
	private PhatTu phatTu;
	
	public DonDangKyDto loadDataView() {
		DonDangKyDto dangKyDto = new DonDangKyDto();
		dangKyDto.setDaoTrang(daoTrang);
		dangKyDto.setDonDangKyId(donDangKyId);
		dangKyDto.setNgayGuiDon(ngayGuiDon);
		dangKyDto.setNgayXuLy(ngayXuLy);
		dangKyDto.setNguoiXuLy(nguoiXuLy);
		dangKyDto.setPhatTu(phatTu);
		dangKyDto.setTrangThaiDon(trangThaiDon);
		return dangKyDto;
	}

	public DonDangKys(Integer donDangKyId, LocalDateTime ngayGuiDon, LocalDateTime ngayXuLy, PhatTu nguoiXuLy,
			Integer trangThaiDon, DaoTrangs daoTrang, PhatTu phatTu) {
		this.donDangKyId = donDangKyId;
		this.ngayGuiDon = ngayGuiDon;
		this.ngayXuLy = ngayXuLy;
		this.nguoiXuLy = nguoiXuLy;
		this.trangThaiDon = trangThaiDon;
		this.daoTrang = daoTrang;
		this.phatTu = phatTu;
	}

	public DonDangKys() {
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
