package com.example.app.model;


import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "clients") 

public class Client extends User{
	
	private String adresse;
	
	@OneToMany(mappedBy = "clients", cascade = CascadeType.ALL)
    private Set<Rendezvous> rendezvouss;

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public Client() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Client(String nom, String prenom, String telephone, String email, String username, String password) {
		super(nom, prenom, telephone, email, username, password);
		//TODO Auto-generated constructor stub
	}
	
	
}