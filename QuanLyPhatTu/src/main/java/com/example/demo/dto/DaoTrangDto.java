package com.example.demo.dto;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.entity.DaoTrangs;
import com.example.demo.entity.DonDangKys;
import com.example.demo.entity.PhatTu;
import com.example.demo.entity.PhatTuDaoTrang;
import com.example.demo.repository.PhatTuRepository;

public class DaoTrangDto {
	
	@Autowired
	PhatTuRepository phatTuRepository;

	private Integer daoTrangId;
	private Boolean daKetThuc;
	private String noiDung;
	private String noiToChuc;
	private Integer soThanhVienThamGia;
	private LocalDateTime thoiGianToChuc;
	private Integer nguoiTruTri;
	
//	public DaoTrangs loadDataView() {
//		DaoTrangs daoTrangs = new DaoTrangs();
//		daoTrangs.setDaKetThuc(daKetThuc);
//		daoTrangs.setDaoTrangId(daoTrangId);
//		daoTrangs.setNguoiTruTri(phatTuRepository.findById(nguoiTruTri).get());
//		daoTrangs.setNoiDung(noiDung);
//		daoTrangs.setNoiToChuc(noiToChuc);
//		daoTrangs.setThoiGianToChuc(thoiGianToChuc);
//		daoTrangs.setSoThanhVienThamGia(soThanhVienThamGia);
//		return daoTrangs;
//	}
	
	public DaoTrangs loadDataView(DaoTrangs daoTrangs) {
		daoTrangs.setDaKetThuc(daKetThuc);
		daoTrangs.setDaoTrangId(daoTrangId);
		daoTrangs.setNguoiTruTri(phatTuRepository.findById(nguoiTruTri).get());
		daoTrangs.setNoiDung(noiDung);
		daoTrangs.setNoiToChuc(noiToChuc);
		daoTrangs.setThoiGianToChuc(thoiGianToChuc);
		daoTrangs.setSoThanhVienThamGia(soThanhVienThamGia);
		return daoTrangs;
	}

	public DaoTrangDto(PhatTuRepository phatTuRepository, Integer daoTrangId, Boolean daKetThuc, String noiDung,
			String noiToChuc, Integer soThanhVienThamGia, LocalDateTime thoiGianToChuc, Integer nguoiTruTri) {
		this.phatTuRepository = phatTuRepository;
		this.daoTrangId = daoTrangId;
		this.daKetThuc = daKetThuc;
		this.noiDung = noiDung;
		this.noiToChuc = noiToChuc;
		this.soThanhVienThamGia = soThanhVienThamGia;
		this.thoiGianToChuc = thoiGianToChuc;
		this.nguoiTruTri = nguoiTruTri;
	}

	public DaoTrangDto() {
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

	public Integer getNguoiTruTri() {
		return nguoiTruTri;
	}

	public void setNguoiTruTri(Integer nguoiTruTri) {
		this.nguoiTruTri = nguoiTruTri;
	}

}
