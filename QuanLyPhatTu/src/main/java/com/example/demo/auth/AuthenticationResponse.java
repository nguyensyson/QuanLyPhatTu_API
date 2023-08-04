package com.example.demo.auth;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AuthenticationResponse {

	@JsonProperty("access_token")
	private String accessToken;
	
	@JsonProperty("refresh_token")
	private String refreshToken;

	public AuthenticationResponse(String accessToken, String refreshToken) {
		this.accessToken = accessToken;
		this.refreshToken = refreshToken;
	}

	public AuthenticationResponse() {
	}

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public String getRefreshToken() {
		return refreshToken;
	}

	public void setRefreshToken(String refreshToken) {
		this.refreshToken = refreshToken;
	}
	
	public static class Builder {
        private String accessToken;
        private String refreshToken;

        // Setter methods for all fields

        public Builder setAccessToken(String accessToken) {
            this.accessToken = accessToken;
            return this;
        }

        public Builder setRefreshToken(String refreshToken) {
            this.refreshToken = refreshToken;
            return this;
        }

        // Build method to create the AuthenticationResponse instance
        public AuthenticationResponse build() {
            AuthenticationResponse response = new AuthenticationResponse();
            response.accessToken = this.accessToken;
            response.refreshToken = this.refreshToken;
            return response;
        }
    }
}
