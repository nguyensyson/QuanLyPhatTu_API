package com.example.demo.entity;

import com.example.demo.dto.TokenType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "token")
public class Token {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "stoken")
	private String stoken;
	
	@Column(name = "expired")
	private Boolean expired;
	
	@Column(name = "revoked")
	private Boolean revoked;
	
	@Column(name = "token_type")
	@Enumerated(EnumType.STRING)
	private TokenType tokenType = TokenType.BEARER;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "phat_tu_id", referencedColumnName = "phat_tu_id")
	private PhatTu phatTu;

	public Token(Integer id, String stoken, Boolean expired, Boolean revoked, TokenType tokenType, PhatTu phatTu) {
		this.id = id;
		this.stoken = stoken;
		this.expired = expired;
		this.revoked = revoked;
		this.tokenType = tokenType;
		this.phatTu = phatTu;
	}

	public Token() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getStoken() {
		return stoken;
	}

	public void setStoken(String stoken) {
		this.stoken = stoken;
	}

	public Boolean getExpired() {
		return expired;
	}

	public void setExpired(Boolean expired) {
		this.expired = expired;
	}

	public Boolean getRevoked() {
		return revoked;
	}

	public void setRevoked(Boolean revoked) {
		this.revoked = revoked;
	}

	public TokenType getTokenType() {
		return tokenType;
	}

	public void setTokenType(TokenType tokenType) {
		this.tokenType = tokenType;
	}

	public PhatTu getPhatTu() {
		return phatTu;
	}

	public void setPhatTu(PhatTu phatTu) {
		this.phatTu = phatTu;
	}
	
	public static class Builder {
        private Integer id;
        private String stoken;
        private Boolean expired;
        private Boolean revoked;
        private TokenType tokenType = TokenType.BEARER;
        private PhatTu phatTu;

        // Setter methods for all fields

        public Builder setId(Integer id) {
            this.id = id;
            return this;
        }

        public Builder setStoken(String stoken) {
            this.stoken = stoken;
            return this;
        }

        public Builder setExpired(Boolean expired) {
            this.expired = expired;
            return this;
        }

        public Builder setRevoked(Boolean revoked) {
            this.revoked = revoked;
            return this;
        }

        public Builder setTokenType(TokenType tokenType) {
            this.tokenType = tokenType;
            return this;
        }

        public Builder setPhatTu(PhatTu phatTu) {
            this.phatTu = phatTu;
            return this;
        }

        public Token build() {
            Token token = new Token();
            token.id = this.id;
            token.stoken = this.stoken;
            token.expired = this.expired;
            token.revoked = this.revoked;
            token.tokenType = this.tokenType;
            token.phatTu = this.phatTu;
            return token;
        }
    }

}
