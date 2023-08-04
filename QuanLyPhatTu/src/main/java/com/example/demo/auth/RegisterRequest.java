package com.example.demo.auth;

import java.time.LocalDateTime;

import com.example.demo.entity.KieuThanhVien;

public class RegisterRequest {

	private String email;
	private Integer gioiTinh;
	private String ho;
	private String tenDem;
	private String ten;
	private LocalDateTime ngaySinh;
	private String password;
	private String phapDanh;
	private String soDienThoai;
	private KieuThanhVien kieuThanhVien;

	public RegisterRequest(String email, Integer gioiTinh, String ho, String tenDem, String ten, LocalDateTime ngaySinh,
			String password, String phapDanh, String soDienThoai, KieuThanhVien kieuThanhVien) {
		super();
		this.email = email;
		this.gioiTinh = gioiTinh;
		this.ho = ho;
		this.tenDem = tenDem;
		this.ten = ten;
		this.ngaySinh = ngaySinh;
		this.password = password;
		this.phapDanh = phapDanh;
		this.soDienThoai = soDienThoai;
		this.kieuThanhVien = kieuThanhVien;
	}

	public RegisterRequest() {
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

	public String getTenDem() {
		return tenDem;
	}

	public void setTenDem(String tenDem) {
		this.tenDem = tenDem;
	}

	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public LocalDateTime getNgaySinh() {
		return ngaySinh;
	}

	public void setNgaySinh(LocalDateTime ngaySinh) {
		this.ngaySinh = ngaySinh;
	}

	public String getPassword() {
		return password;
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
	
	public KieuThanhVien getKieuThanhVien() {
		return kieuThanhVien;
	}

	public void setKieuThanhVien(KieuThanhVien kieuThanhVien) {
		this.kieuThanhVien = kieuThanhVien;
	}

	public static class Builder {
        private String email;
        private Integer gioiTinh;
        private String ho;
        private String tenDem;
        private String ten;
        private LocalDateTime ngaySinh;
        private String password;
        private String phapDanh;
        private String soDienThoai;
        private KieuThanhVien kieuThanhVien;

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

        public Builder setTenDem(String tenDem) {
            this.tenDem = tenDem;
            return this;
        }

        public Builder setTen(String ten) {
            this.ten = ten;
            return this;
        }

        public Builder setNgaySinh(LocalDateTime ngaySinh) {
            this.ngaySinh = ngaySinh;
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
        
        public Builder setKieuThanhVien(KieuThanhVien kieuThanhVien) {
        	this.kieuThanhVien = kieuThanhVien;
        	return this;
        }

        public RegisterRequest build() {
            RegisterRequest request = new RegisterRequest();
            request.email = this.email;
            request.gioiTinh = this.gioiTinh;
            request.ho = this.ho;
            request.tenDem = this.tenDem;
            request.ten = this.ten;
            request.ngaySinh = this.ngaySinh;
            request.password = this.password;
            request.phapDanh = this.phapDanh;
            request.soDienThoai = this.soDienThoai;
            request.kieuThanhVien = this.kieuThanhVien;
            return request;
        }
    }
}
