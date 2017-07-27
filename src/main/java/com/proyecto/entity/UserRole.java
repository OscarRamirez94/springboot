package com.proyecto.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "userRoles", uniqueConstraints = @UniqueConstraint(columnNames = { "role", "username" }))
public class UserRole {
	@Id
	@GeneratedValue
	@Column(name = "userRoldeID")
	private Integer userRoldeID;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "username")
	private User user;
	@Column(name = "role")
	private String role;

	public UserRole() {
	}

	public UserRole(User user, String role) {
		super();
		this.user = user;
		this.role = role;
	}

	public Integer getUserRoldeID() {
		return userRoldeID;
	}

	public void setUserRoldeID(Integer userRoldeID) {
		this.userRoldeID = userRoldeID;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

}
