package com.example.sproute.domain;

public class Address {
	private String city;
	private String dong;
	private String zipCode;
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getDong() {
		return dong;
	}
	public void setDong(String dong) {
		this.dong = dong;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	public Address(String city, String dong, String zipCode) {
		this.city = city;
		this.dong = dong;
		this.zipCode = zipCode;
	}
	
	public String toString() {
		return city + " " + dong
				+ " (우편번호 : " + zipCode + ")";
	}	
	
	

}
