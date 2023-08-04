package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Token;

@Repository
public interface TokenRepository extends JpaRepository<Token, Integer> {

	Optional<Token> findByStoken(String stoken);
	
	@Query("SELECT t FROM Token t INNER JOIN PhatTu pt "
			+ "ON t.phatTu.phatTuId = pt.phatTuId "
			+ "WHERE pt.phatTuId = :id AND (t.expired = false OR t.revoked = false)")
	List<Token> findAllValidTokenByPhatTu(Integer id);
}
