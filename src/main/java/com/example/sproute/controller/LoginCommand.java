package com.example.sproute.controller;

import javax.validation.constraints.NotBlank;

public class LoginCommand {
	@NotBlank
	private String loginId;
	@NotBlank
	private String loginpw;
	public String getLoginId() {
		return loginId;
	}
	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}
	public String getLoginpw() {
		return loginpw;
	}
	public void setLoginpw(String loginpw) {
		this.loginpw = loginpw;
	}
	
	

}
