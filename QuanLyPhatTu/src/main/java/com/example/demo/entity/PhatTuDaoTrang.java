package com.example.demo.entity;

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
@Table(name = "phat_tu_dao_trangs")
public class PhatTuDaoTrang {

	@Id
	@Column(name = "phat_tu_dao_trangid")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer phatTuDaoTrangId;
	
	@Column(name = "da_tham_gia")
	private Boolean daThamGia;
	
	@Column(name = "ly_do_khong_tham_gia")
	private String lyDoKhongThamGia;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "dao_trang_id", referencedColumnName = "dao_trang_id")
	private DaoTrangs daoTrang;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "phat_tu_id", referencedColumnName = "phat_tu_id")
	private PhatTu phatTu;

	public PhatTuDaoTrang(Integer phatTuDaoTrangId, Boolean daThamGia, String lyDoKhongThamGia, DaoTrangs daoTrang,
			PhatTu phatTu) {
		this.phatTuDaoTrangId = phatTuDaoTrangId;
		this.daThamGia = daThamGia;
		this.lyDoKhongThamGia = lyDoKhongThamGia;
		this.daoTrang = daoTrang;
		this.phatTu = phatTu;
	}

	public PhatTuDaoTrang() {
	}

	public Integer getPhatTuDaoTrangId() {
		return phatTuDaoTrangId;
	}

	public void setPhatTuDaoTrangId(Integer phatTuDaoTrangId) {
		this.phatTuDaoTrangId = phatTuDaoTrangId;
	}

	public Boolean getDaThamGia() {
		return daThamGia;
	}

	public void setDaThamGia(Boolean daThamGia) {
		this.daThamGia = daThamGia;
	}

	public String getLyDoKhongThamGia() {
		return lyDoKhongThamGia;
	}

	public void setLyDoKhongThamGia(String lyDoKhongThamGia) {
		this.lyDoKhongThamGia = lyDoKhongThamGia;
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
