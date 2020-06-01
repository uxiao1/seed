package com.company.project.model;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.List;

@Table(name = "user")
public class User   {
	@Id
	@Column(name = "id")
	private Integer id;
	@Column(name = "cnname")
	private String cnname;
	@Column(name = "username")
	private String username;
	@Column(name = "salt")
	private String salt;
	@Column(name = "password")
	private String password;
	@Column(name = "email")
	private String email;
	@Column(name = "telephone")
	private String telephone;
	@Column(name = "mobilePhone")
	private String mobilePhone;
	@Column(name = "wechatId")
	private String wechatId;
	@Column(name = "skill")
	private String skill;
	@Column(name = "departmentId")
	private Integer departmentId;
	@Column(name = "loginCount")
	private Integer loginCount;
	@Transient
	private List<Role> roles;

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCnname() {
		return cnname;
	}

	public void setCnname(String cnname) {
		this.cnname = cnname;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getMobilePhone() {
		return mobilePhone;
	}

	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}

	public String getWechatId() {
		return wechatId;
	}

	public void setWechatId(String wechatId) {
		this.wechatId = wechatId;
	}

	public String getSkill() {
		return skill;
	}

	public void setSkill(String skill) {
		this.skill = skill;
	}

	public Integer getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Integer departmentId) {
		this.departmentId = departmentId;
	}

	public Integer getLoginCount() {
		return loginCount;
	}

	public void setLoginCount(Integer loginCount) {
		this.loginCount = loginCount;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	@Override
	public String toString() {
		return "User{" +
			"id=" + id +
			", cnname=" + cnname +
			", username=" + username +
			", password=" + password +
			", email=" + email +
			", telephone=" + telephone +
			", mobilePhone=" + mobilePhone +
			", wechatId=" + wechatId +
			", skill=" + skill +
			", departmentId=" + departmentId +
			", loginCount=" + loginCount +
			'}';
		}
}