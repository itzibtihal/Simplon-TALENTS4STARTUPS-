package com.example.springboot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "Admin")
public class Admin {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idadmin;
	@Column(name = "username", nullable=false)
	private String username;
	@Column(name = "password")
	private String password;
	
	
	
	public Admin() {
		super();
	}
	
	
	public Admin(long idadmin, String username, String password) {
		super();
		this.idadmin = idadmin;
		this.username = username;
		this.password = password;
	}


	public long getIdadmin() {
		return idadmin;
	}


	public void setIdadmin(long idadmin) {
		this.idadmin = idadmin;
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


	@Override
	public String toString() {
		return "Admin [idadmin=" + idadmin + ", username=" + username + ", password=" + password + "]";
	}
	
	
	
}
