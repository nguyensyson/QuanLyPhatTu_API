package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.PhatTu;

@Repository
public interface PhatTuRepository extends JpaRepository<PhatTu, Integer> {

	@Query("SELECT p FROM PhatTu p WHERE p.email = :email")
	Optional<PhatTu> findByEmail(@Param("email") String email);
	
	Optional<PhatTu> findByResetPasswordToken(String token);
}
