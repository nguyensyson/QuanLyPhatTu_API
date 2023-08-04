package com.example.demo.entity;

import java.time.LocalDateTime;
import java.util.List;

import com.example.demo.dto.DaoTrangDto;

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
@Table(name = "dao_trangs")
public class DaoTrangs {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "dao_trang_id")
	private Integer daoTrangId;
	
	@Column(name = "da_ket_thuc")
	private Boolean daKetThuc;
	
	@Column(name = "noi_dung")
	private String noiDung;
	
	@Column(name = "noi_to_chuc")
	private String noiToChuc;
	
	@Column(name = "so_thanh_vien_tham_gia")
	private Integer soThanhVienThamGia;
	
	@Column(name = "thoi_gian_to_chuc")
	private LocalDateTime thoiGianToChuc;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "nguoi_tru_tri", referencedColumnName = "phat_tu_id")
	private PhatTu nguoiTruTri;
	
	@OneToMany(mappedBy = "daoTrang", fetch = FetchType.LAZY)
	private List<PhatTuDaoTrang> daoTrangs;
	
	@OneToMany(mappedBy = "daoTrang", fetch = FetchType.LAZY)
	private List<DonDangKys> donDangKys;
	
	public DaoTrangDto loadDataView() {
		DaoTrangDto daoTrangDto = new DaoTrangDto();
		daoTrangDto.setDaKetThuc(daKetThuc);
		daoTrangDto.setDaoTrangId(daoTrangId);
		daoTrangDto.setNguoiTruTri(nguoiTruTri.getPhatTuId());
		daoTrangDto.setNoiDung(noiDung);
		daoTrangDto.setNoiToChuc(noiToChuc);
		daoTrangDto.setSoThanhVienThamGia(soThanhVienThamGia);
		daoTrangDto.setThoiGianToChuc(thoiGianToChuc);
		return daoTrangDto;
	}

	public DaoTrangs(Integer daoTrangId, Boolean daKetThuc, String noiDung, String noiToChuc,
			Integer soThanhVienThamGia, LocalDateTime thoiGianToChuc, PhatTu nguoiTruTri,
			List<PhatTuDaoTrang> daoTrangs, List<DonDangKys> donDangKys) {
		this.daoTrangId = daoTrangId;
		this.daKetThuc = daKetThuc;
		this.noiDung = noiDung;
		this.noiToChuc = noiToChuc;
		this.soThanhVienThamGia = soThanhVienThamGia;
		this.thoiGianToChuc = thoiGianToChuc;
		this.nguoiTruTri = nguoiTruTri;
		this.daoTrangs = daoTrangs;
		this.donDangKys = donDangKys;
	}

	public DaoTrangs() {
	}

	public Integer getDaoTrangId() {
		return daoTrangId;
	}

	public void setDaoTrangId(Integer daoTrangId) {
		this.daoTrangId = daoTrangId;
	}

	public Boolean getDaKetThuc() {
		return daKetThuc;
	}

	public void setDaKetThuc(Boolean daKetThuc) {
		this.daKetThuc = daKetThuc;
	}

	public String getNoiDung() {
		return noiDung;
	}

	public void setNoiDung(String noiDung) {
		this.noiDung = noiDung;
	}

	public String getNoiToChuc() {
		return noiToChuc;
	}

	public void setNoiToChuc(String noiToChuc) {
		this.noiToChuc = noiToChuc;
	}

	public Integer getSoThanhVienThamGia() {
		return soThanhVienThamGia;
	}

	public void setSoThanhVienThamGia(Integer soThanhVienThamGia) {
		this.soThanhVienThamGia = soThanhVienThamGia;
	}

	public LocalDateTime getThoiGianToChuc() {
		return thoiGianToChuc;
	}

	public void setThoiGianToChuc(LocalDateTime thoiGianToChuc) {
		this.thoiGianToChuc = thoiGianToChuc;
	}

	public PhatTu getNguoiTruTri() {
		return nguoiTruTri;
	}

	public void setNguoiTruTri(PhatTu nguoiTruTri) {
		this.nguoiTruTri = nguoiTruTri;
	}

	public List<PhatTuDaoTrang> getDaoTrangs() {
		return daoTrangs;
	}

	public void setDaoTrangs(List<PhatTuDaoTrang> daoTrangs) {
		this.daoTrangs = daoTrangs;
	}

	public List<DonDangKys> getDonDangKys() {
		return donDangKys;
	}

	public void setDonDangKys(List<DonDangKys> donDangKys) {
		this.donDangKys = donDangKys;
	}

	
}
