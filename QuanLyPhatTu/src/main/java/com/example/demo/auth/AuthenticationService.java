package com.example.demo.auth;

import java.io.IOException;

import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.config.JwtService;
import com.example.demo.dto.TokenType;
import com.example.demo.entity.PhatTu;
import com.example.demo.entity.Token;
import com.example.demo.repository.PhatTuRepository;
import com.example.demo.repository.TokenRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Service
public class AuthenticationService {

	private final PhatTuRepository phatTuRepository;
	private final TokenRepository tokenRepository;
	private final PasswordEncoder passwordEncoder;
	private final JwtService jwtService;
	private final AuthenticationManager authenticationManager;
	
	public AuthenticationService(PhatTuRepository phatTuRepository, TokenRepository tokenRepository,
			PasswordEncoder passwordEncoder, JwtService jwtService, AuthenticationManager authenticationManager) {
		this.phatTuRepository = phatTuRepository;
		this.tokenRepository = tokenRepository;
		this.passwordEncoder = passwordEncoder;
		this.jwtService = jwtService;
		this.authenticationManager = authenticationManager;
	}
	
	public void changePassword(String email, String currentPassword, String newPassword) {
        PhatTu user = phatTuRepository.findByEmail(email)
            .orElseThrow(() -> new UsernameNotFoundException("User not found with email: " + email));

        if (passwordEncoder.matches(currentPassword, user.getPassword())) {
            String encodedNewPassword = passwordEncoder.encode(newPassword);
            user.setPassword(encodedNewPassword);
            phatTuRepository.save(user);
        } else {
            throw new IllegalArgumentException("Incorrect current password");
        }
    }
	
	public String register(RegisterRequest request) {
	    var user = new PhatTu.Builder()
	    		.setEmail(request.getEmail())
	    		.setGioiTinh(request.getGioiTinh())
	    		.setHo(request.getHo())
	    		.setTenDem(request.getTenDem())
	    		.setTen(request.getTen())
	    		.setNgaySinh(request.getNgaySinh())
	    		.setPassword(passwordEncoder.encode(request.getPassword()))
	    		.setPhapDanh(request.getPassword())
	    		.setSoDienThoai(request.getSoDienThoai())
	    		.setKieuThanhVien(request.getKieuThanhVien())
	    		.build();
	    var savedUser = phatTuRepository.save(user);
//	    var jwtToken = jwtService.generateToken(user);
//	    var refreshToken = jwtService.generateRefreshToken(user);
//	    saveUserToken(savedUser, jwtToken);
	    
//	    return new AuthenticationResponse.Builder()
//	        .setAccessToken(jwtToken)
//	            .setRefreshToken(refreshToken)
//	        .build();
	    
	    return "Đăng ký thành công";
	  }
	
	private void saveUserToken(PhatTu user, String jwtToken) {
	    var token = new Token.Builder()
	        .setPhatTu(user)
	        .setStoken(jwtToken)
	        .setTokenType(TokenType.BEARER)
	        .setExpired(false)
	        .setRevoked(false)
	        .build();
	    tokenRepository.save(token);
	  }
	
	public AuthenticationResponse authenticate(AuthenticationRequest request) {
	    authenticationManager.authenticate(
	        new UsernamePasswordAuthenticationToken(
	            request.getEmail(),
	            request.getPassword()
	        )
	    );
	    var user = phatTuRepository.findByEmail(request.getEmail())
	        .orElseThrow();
	    
	    System.out.println(user.getEmail());
	    var jwtToken = jwtService.generateToken(user);
	    var refreshToken = jwtService.generateRefreshToken(user);
	    revokeAllUserTokens(user);
	    saveUserToken(user, jwtToken);
	    return new AuthenticationResponse.Builder()
	        .setAccessToken(jwtToken)
	            .setRefreshToken(refreshToken)
	        .build();
	  }
	
	private void revokeAllUserTokens(PhatTu user) {
	    var validUserTokens = tokenRepository.findAllValidTokenByPhatTu(user.getPhatTuId());
	    if (validUserTokens.isEmpty())
	      return;
	    validUserTokens.forEach(token -> {
	      token.setExpired(true);
	      token.setRevoked(true);
	    });
	    tokenRepository.saveAll(validUserTokens);
	  }

	public void refreshToken(
	          HttpServletRequest request,
	          HttpServletResponse response
	  ) throws IOException {
	    final String authHeader = request.getHeader(HttpHeaders.AUTHORIZATION);
	    final String refreshToken;
	    final String userEmail;
	    if (authHeader == null ||!authHeader.startsWith("Bearer ")) {
	      return;
	    }
	    refreshToken = authHeader.substring(7);
	    userEmail = jwtService.extractUsername(refreshToken);
	    if (userEmail != null) {
	      var user = this.phatTuRepository.findByEmail(userEmail)
	              .orElseThrow();
	      if (jwtService.isTokenValid(refreshToken, user)) {
	        var accessToken = jwtService.generateToken(user);
	        revokeAllUserTokens(user);
	        saveUserToken(user, accessToken);
	        var authResponse = new AuthenticationResponse.Builder()
	                .setAccessToken(accessToken)
	                .setRefreshToken(refreshToken)
	                .build();
	        new ObjectMapper().writeValue(response.getOutputStream(), authResponse);
	      }
	    }
	  }
}
