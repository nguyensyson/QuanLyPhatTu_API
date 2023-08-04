package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.DonDangKys;

@Repository
public interface DonDangKysRepository extends JpaRepository<DonDangKys, Integer> {

}
