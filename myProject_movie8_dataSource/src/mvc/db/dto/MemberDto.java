package mvc.db.dto;

import java.util.Date;

public class MemberDto {	
	private String id;
	private String password;
	private String name;
	private String email;
	private int birthyear; 
	private String gender;
	private String interest;
	private Date joinDate;	
	private Date updateDate;
	private String isActive;

	public String getId() {
		return id;
	}
	public MemberDto setId(String id) {
		this.id = id;
		return this;
	}
	public String getPassword() {
		return password;
	}
	public MemberDto setPassword(String password) {
		this.password = password;
		return this;
	}
	public String getName() {
		return name;
	}
	public MemberDto setName(String name) {
		this.name = name;
		return this;
	}
	public String getEmail() {
		return email;
	}
	public MemberDto setEmail(String email) {
		this.email = email;
		return this;
	}
	public int getBirthyear() {
		return birthyear;
	}
	public MemberDto setBirthyear(int birthyear) {
		this.birthyear = birthyear;
		return this;
	}
	public String getGender() {
		return gender;
	}
	public MemberDto setGender(String gender) {
		this.gender = gender;
		return this;
	}
	public String getInterest() {
		return interest;
	}
	public MemberDto setInterest(String interest) {
		this.interest = interest;
		return this;
	}	
	public Date getJoinDate() {
		return joinDate;
	}
	public MemberDto setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
		return this;
	}
	public Date getUpdateDate() {
		return updateDate;
	}
	public MemberDto setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
		return this;
	}
	public String getIsActive() {
		return isActive;
	}
	public MemberDto setIsActive(String isActive) {
		this.isActive = isActive;
		return this;
	}
}
