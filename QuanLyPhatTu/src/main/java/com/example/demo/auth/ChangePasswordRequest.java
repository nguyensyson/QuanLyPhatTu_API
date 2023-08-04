package com.example.demo.auth;

public class ChangePasswordRequest {

	private String email;
	private String currentPassword;
	private String newPassword;
	
	public ChangePasswordRequest(String email, String currentPassword, String newPassword) {
		this.email = email;
		this.currentPassword = currentPassword;
		this.newPassword = newPassword;
	}

	public ChangePasswordRequest() {
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCurrentPassword() {
		return currentPassword;
	}

	public void setCurrentPassword(String currentPassword) {
		this.currentPassword = currentPassword;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}
	
	
}
