package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Chuas;

@Repository
public interface ChuasRepository extends JpaRepository<Chuas, Integer> {

}
