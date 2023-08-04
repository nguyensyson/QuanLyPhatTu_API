package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.DaoTrangs;

@Repository
public interface DaoTrangsRepository extends JpaRepository<DaoTrangs, Integer> {

}
