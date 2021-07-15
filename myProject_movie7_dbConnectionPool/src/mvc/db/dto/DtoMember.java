package mvc.db.dto;

import java.util.Date;

public class DtoMember {	
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
	public DtoMember setId(String id) {
		this.id = id;
		return this;
	}
	public String getPassword() {
		return password;
	}
	public DtoMember setPassword(String password) {
		this.password = password;
		return this;
	}
	public String getName() {
		return name;
	}
	public DtoMember setName(String name) {
		this.name = name;
		return this;
	}
	public String getEmail() {
		return email;
	}
	public DtoMember setEmail(String email) {
		this.email = email;
		return this;
	}
	public int getBirthyear() {
		return birthyear;
	}
	public DtoMember setBirthyear(int birthyear) {
		this.birthyear = birthyear;
		return this;
	}
	public String getGender() {
		return gender;
	}
	public DtoMember setGender(String gender) {
		this.gender = gender;
		return this;
	}
	public String getInterest() {
		return interest;
	}
	public DtoMember setInterest(String interest) {
		this.interest = interest;
		return this;
	}	
	public Date getJoinDate() {
		return joinDate;
	}
	public DtoMember setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
		return this;
	}
	public Date getUpdateDate() {
		return updateDate;
	}
	public DtoMember setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
		return this;
	}
	public String getIsActive() {
		return isActive;
	}
	public DtoMember setIsActive(String isActive) {
		this.isActive = isActive;
		return this;
	}
}
