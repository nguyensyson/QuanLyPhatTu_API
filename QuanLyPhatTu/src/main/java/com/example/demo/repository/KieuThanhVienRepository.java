package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.KieuThanhVien;

@Repository
public interface KieuThanhVienRepository extends JpaRepository<KieuThanhVien, Integer> {

}
