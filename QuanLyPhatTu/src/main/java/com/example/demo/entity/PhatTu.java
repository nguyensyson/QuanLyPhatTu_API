package com.example.demo.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Hibernate;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.demo.dto.PhatTuDto;

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
@Table(name = "phat_tu")
public class PhatTu implements UserDetails {
	
	@Id
	@Column(name = "phat_tu_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer phatTuId;
	
	@Column(name = "anh_chup")
	private byte[] anhChup;
	
	@Column(name = "da_hoan_tuc")
	private Boolean daHoanTuc;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "gioi_tinh")
	private Integer gioiTinh;
	
	@Column(name = "ho")
	private String ho;
	
	@Column(name = "ngay_cap_nhat")
	private LocalDateTime ngayCapNhat;
	
	@Column(name = "ngay_hoan_tuc")
	private LocalDateTime ngayHoanTuc;
	
	@Column(name = "ngay_sinh")
	private LocalDateTime ngaySinh;
	
	@Column(name = "ngay_xuat_gia")
	private LocalDateTime ngayXuatGia;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "phap_danh")
	private String phapDanh;
	
	@Column(name = "so_dien_thoai")
	private String soDienThoai;
	
	@Column(name = "ten")
	private String ten;
	
	@Column(name = "ten_dem")
	private String tenDem;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "chuaid", referencedColumnName = "chuaid")
	private Chuas chua;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "kieu_thanh_vienid", referencedColumnName = "kieu_thanh_vien_id")
	private KieuThanhVien kieuThanhVien;
	
	@Column(name = "reset_password_token")
	private String resetPasswordToken;
	
	@Column(name = "status_phat_tu")
	private Integer statusPhatTu;
	
	@OneToMany(mappedBy = "nguoiXuLy", fetch = FetchType.LAZY)
	private List<DonDangKys> listDonTao;

	@OneToMany(mappedBy = "phatTu", fetch = FetchType.LAZY)
	private List<PhatTuDaoTrang> daoTrangs;

	@OneToMany(mappedBy = "phatTu", fetch = FetchType.LAZY)
	private List<DonDangKys> listDonDangKy;
	
	@OneToMany(mappedBy = "phatTu", fetch = FetchType.LAZY)
	private List<Token> listToken;
	
	@OneToMany(mappedBy = "truTri", fetch = FetchType.LAZY)
	private List<Chuas> listChua;
	
	@OneToMany(mappedBy = "nguoiTruTri", fetch = FetchType.LAZY)
	private List<DaoTrangs> listDaoTrang;
	
	public PhatTuDto LoadDataViewDTO() {
		PhatTuDto phatTuDto = new PhatTuDto();
		phatTuDto.setAnhChup(anhChup);
		phatTuDto.setChua(chua);
		phatTuDto.setDaHoanTuc(daHoanTuc);
		phatTuDto.setEmail(email);
		phatTuDto.setGioiTinh(gioiTinh);
		phatTuDto.setHo(ho);
		phatTuDto.setKieuThanhVien(kieuThanhVien);
		phatTuDto.setNgayHoanTuc(ngayHoanTuc);
		phatTuDto.setNgaySinh(ngaySinh);
		phatTuDto.setNgayXuatGia(ngayXuatGia);
		phatTuDto.setPhapDanh(phapDanh);
		phatTuDto.setPhatTuId(phatTuId);
		phatTuDto.setSoDienThoai(soDienThoai);
		phatTuDto.setTen(ten);
		phatTuDto.setTenDem(tenDem);
		return phatTuDto;
	}

	public PhatTu(Integer phatTuId, byte[] anhChup, Boolean daHoanTuc, String email, Integer gioiTinh, String ho,
			LocalDateTime ngayCapNhat, LocalDateTime ngayHoanTuc, LocalDateTime ngaySinh, LocalDateTime ngayXuatGia,
			String password, String phapDanh, String soDienThoai, String ten, String tenDem, Chuas chua,
			KieuThanhVien kieuThanhVien, String resetPasswordToken, Integer statusPhatTu) {
		super();
		this.phatTuId = phatTuId;
		this.anhChup = anhChup;
		this.daHoanTuc = daHoanTuc;
		this.email = email;
		this.gioiTinh = gioiTinh;
		this.ho = ho;
		this.ngayCapNhat = ngayCapNhat;
		this.ngayHoanTuc = ngayHoanTuc;
		this.ngaySinh = ngaySinh;
		this.ngayXuatGia = ngayXuatGia;
		this.password = password;
		this.phapDanh = phapDanh;
		this.soDienThoai = soDienThoai;
		this.ten = ten;
		this.tenDem = tenDem;
		this.chua = chua;
		this.kieuThanhVien = kieuThanhVien;
		this.resetPasswordToken = resetPasswordToken;
		this.statusPhatTu = statusPhatTu;
	}

	public PhatTu() {
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

	public LocalDateTime getNgayCapNhat() {
		return ngayCapNhat;
	}

	public void setNgayCapNhat(LocalDateTime ngayCapNhat) {
		this.ngayCapNhat = ngayCapNhat;
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

	public void setPassword(String password) {
		this.password = password;
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

	public List<DonDangKys> getListDonTao() {
		return listDonTao;
	}

	public void setListDonTao(List<DonDangKys> listDonTao) {
		this.listDonTao = listDonTao;
	}

	public List<PhatTuDaoTrang> getDaoTrangs() {
		return daoTrangs;
	}

	public void setDaoTrangs(List<PhatTuDaoTrang> daoTrangs) {
		this.daoTrangs = daoTrangs;
	}

	public List<DonDangKys> getListDonDangKy() {
		return listDonDangKy;
	}

	public void setListDonDangKy(List<DonDangKys> listDonDangKy) {
		this.listDonDangKy = listDonDangKy;
	}

	public List<Token> getListToken() {
		return listToken;
	}

	public void setListToken(List<Token> listToken) {
		this.listToken = listToken;
	}

	public List<Chuas> getListChua() {
		return listChua;
	}

	public void setListChua(List<Chuas> listChua) {
		this.listChua = listChua;
	}

	public List<DaoTrangs> getListDaoTrang() {
		return listDaoTrang;
	}

	public void setListDaoTrang(List<DaoTrangs> listDaoTrang) {
		this.listDaoTrang = listDaoTrang;
	}

	public String getResetPasswordToken() {
		return resetPasswordToken;
	}

	public void setResetPasswordToken(String resetPasswordToken) {
		this.resetPasswordToken = resetPasswordToken;
	}

	public Integer getStatusPhatTu() {
		return statusPhatTu;
	}

	public void setStatusPhatTu(Integer statusPhatTu) {
		this.statusPhatTu = statusPhatTu;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		if(kieuThanhVien != null) {
			Hibernate.initialize(kieuThanhVien);
		}
		return this.kieuThanhVien.getAuthorities();
	}
	
	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return email;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
	
	public static class Builder {
        private Integer phatTuId;
        private byte[] anhChup;
        private Boolean daHoanTuc;
        private String email;
        private Integer gioiTinh;
        private String ho;
        private LocalDateTime ngayCapNhat;
        private LocalDateTime ngayHoanTuc;
        private LocalDateTime ngaySinh;
        private LocalDateTime ngayXuatGia;
        private String password;
        private String phapDanh;
        private String soDienThoai;
        private String ten;
        private String tenDem;
        private Chuas chua;
        private KieuThanhVien kieuThanhVien;

        public Builder setPhatTuId(Integer phatTuId) {
            this.phatTuId = phatTuId;
            return this;
        }

        public Builder setAnhChup(byte[] anhChup) {
            this.anhChup = anhChup;
            return this;
        }

        public Builder setDaHoanTuc(Boolean daHoanTuc) {
            this.daHoanTuc = daHoanTuc;
            return this;
        }

        public Builder setEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder setGioiTinh(Integer gioiTinh) {
            this.gioiTinh = gioiTinh;
            return this;
        }

        public Builder setHo(String ho) {
            this.ho = ho;
            return this;
        }

        public Builder setNgayCapNhat(LocalDateTime ngayCapNhat) {
            this.ngayCapNhat = ngayCapNhat;
            return this;
        }

        public Builder setNgayHoanTuc(LocalDateTime ngayHoanTuc) {
            this.ngayHoanTuc = ngayHoanTuc;
            return this;
        }

        public Builder setNgaySinh(LocalDateTime ngaySinh) {
            this.ngaySinh = ngaySinh;
            return this;
        }

        public Builder setNgayXuatGia(LocalDateTime ngayXuatGia) {
            this.ngayXuatGia = ngayXuatGia;
            return this;
        }

        public Builder setPassword(String password) {
            this.password = password;
            return this;
        }

        public Builder setPhapDanh(String phapDanh) {
            this.phapDanh = phapDanh;
            return this;
        }

        public Builder setSoDienThoai(String soDienThoai) {
            this.soDienThoai = soDienThoai;
            return this;
        }

        public Builder setTen(String ten) {
            this.ten = ten;
            return this;
        }

        public Builder setTenDem(String tenDem) {
            this.tenDem = tenDem;
            return this;
        }

        public Builder setChua(Chuas chua) {
            this.chua = chua;
            return this;
        }

        public Builder setKieuThanhVien(KieuThanhVien kieuThanhVien) {
            this.kieuThanhVien = kieuThanhVien;
            return this;
        }

        public PhatTu build() {
            PhatTu phatTu = new PhatTu();
            phatTu.phatTuId = this.phatTuId;
            phatTu.anhChup = this.anhChup;
            phatTu.daHoanTuc = this.daHoanTuc;
            phatTu.email = this.email;
            phatTu.gioiTinh = this.gioiTinh;
            phatTu.ho = this.ho;
            phatTu.ngayCapNhat = this.ngayCapNhat;
            phatTu.ngayHoanTuc = this.ngayHoanTuc;
            phatTu.ngaySinh = this.ngaySinh;
            phatTu.ngayXuatGia = this.ngayXuatGia;
            phatTu.password = this.password;
            phatTu.phapDanh = this.phapDanh;
            phatTu.soDienThoai = this.soDienThoai;
            phatTu.ten = this.ten;
            phatTu.tenDem = this.tenDem;
            phatTu.chua = this.chua;
            phatTu.kieuThanhVien = this.kieuThanhVien;
            return phatTu;
        }
    }
	
}
