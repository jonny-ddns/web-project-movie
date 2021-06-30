package mvc_member.memberObject;

import java.util.Date;

public class MemberVO {
	
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
	public MemberVO setId(String id) {
		this.id = id;
		return this;
	}
	public String getPassword() {
		return password;
	}
	public MemberVO setPassword(String password) {
		this.password = password;
		return this;
	}
	public String getName() {
		return name;
	}
	public MemberVO setName(String name) {
		this.name = name;
		return this;
	}
	public String getEmail() {
		return email;
	}
	public MemberVO setEmail(String email) {
		this.email = email;
		return this;
	}
	public int getBirthyear() {
		return birthyear;
	}
	public MemberVO setBirthyear(int birthyear) {
		this.birthyear = birthyear;
		return this;
	}
	public String getGender() {
		return gender;
	}
	public MemberVO setGender(String gender) {
		this.gender = gender;
		return this;
	}
	public String getInterest() {
		return interest;
	}
	public MemberVO setInterest(String interest) {
		this.interest = interest;
		return this;
	}	
	public Date getJoinDate() {
		return joinDate;
	}
	public MemberVO setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
		return this;
	}
	public Date getUpdateDate() {
		return updateDate;
	}
	public MemberVO setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
		return this;
	}
	public String getIsActive() {
		return isActive;
	}
	public MemberVO setIsActive(String isActive) {
		this.isActive = isActive;
		return this;
	}
}
