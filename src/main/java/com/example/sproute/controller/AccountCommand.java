package com.example.sproute.controller;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.springframework.format.annotation.DateTimeFormat;

public class AccountCommand {
   private int id;
   @NotBlank
   private String userId;
   @NotBlank
   private String password;
   @NotBlank
   private String cPassword;
   @Email
   private String email;
   @NotBlank
   private String address;
   @NotBlank
   @Pattern(regexp="^01\\d{1}-\\d{3,4}-\\d{4}$")
   private String phone;
   @NotBlank
   private String sex;
   @NotBlank
   private String name;
   @Pattern(regexp="^(19|20)\\d{2}(0[1-9]|1[012])(0[1-9]|[12][0-9]|3[0-1])$")
   private String birth;
   
   public AccountCommand() {
      
   }
   public AccountCommand(int id, String userId, String password, String email, String address, String phone,
         String sex, String name, String birth) {
      this.id = id;
      this.userId = userId;
      this.password = password;
      this.email = email;
      this.address = address;
      this.phone = phone;
      this.sex = sex;
      this.name = name;
      this.birth = birth;
   }
   public int getId() {
      return id;
   }
   public void setId(int id) {
      this.id = id;
   }
   public String getUserId() {
      return userId;
   }
   public void setUserId(String userId) {
      this.userId = userId;
   }
   public String getPassword() {
      return password;
   }
   public void setPassword(String password) {
      this.password = password;
   }
   
   public String getcPassword() {
	return cPassword;
}


public void setcPassword(String cPassword) {
	this.cPassword = cPassword;
}
public String getEmail() {
      return email;
   }
   public void setEmail(String email) {
      this.email = email;
   }
   public String getAddress() {
      return address;
   }
   public void setAddress(String address) {
      this.address = address;
   }
   public String getPhone() {
      return phone;
   }
   public void setPhone(String phone) {
      this.phone = phone;
   }
   public String getSex() {
      return sex;
   }
   public void setSex(String sex) {
      this.sex = sex;
   }
   public String getName() {
      return name;
   }
   public void setName(String name) {
      this.name = name;
   }
   public String getBirth() {
      return birth;
   }
   public void setBirth(String birth) {
      this.birth = birth;
   }
	public boolean isSamecPassword() {
		if (password == null || cPassword == null)
			return false;
		return password.equals(cPassword);
	}
	
	@Override
	public String toString() {
		return "AccountCommand [id=" + id + ", userId=" + userId + ", password=" + password + ", cPassword=" + cPassword
				+ ", email=" + email + ", address=" + address + ", phone=" + phone + ", sex=" + sex + ", name=" + name
				+ ", birth=" + birth + "]";
	}

   
   

}