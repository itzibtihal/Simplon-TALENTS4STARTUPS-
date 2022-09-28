package com.example.app.model;

import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name = "admins")

public class Admin extends User {

	public Admin() {
		super();
		//TODO Auto-generated constructor stub
	}

	public Admin(String nom, String prenom, String telephone, String email, String username, String password) {
		super(nom, prenom, telephone, email, username, password);
		//TODO Auto-generated constructor stub
	}	

}
