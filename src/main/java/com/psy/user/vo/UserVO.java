package com.psy.user.vo;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

public class UserVO {
	@NotNull(message="아이디가 비었습니다.")
	@NotEmpty(message="아이디가 비었습니다.")
	private String userId;
	@NotNull(message="비밀번호가 비었습니다.")
	@NotEmpty(message="비밀번호가 비었습니다.")
	private String hashedPassword;
	private String salt;
	@NotNull(message="이름이 비었습니다.")
	@NotEmpty(message="이름이 비었습니다.")
	private String userName;
	@NotNull(message="전화번호가 비었습니다.")
	@NotEmpty(message="전화번호가 비었습니다.")
	private String phoneNumber;
	private String createdDate;
	private int point;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getHashedPassword() {
		return hashedPassword;
	}
	public void setHashedPassword(String hashedPassword) {
		this.hashedPassword = hashedPassword;
	}
	public String getSalt() {
		return salt;
	}
	public void setSalt(String salt) {
		this.salt = salt;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}

	
}
