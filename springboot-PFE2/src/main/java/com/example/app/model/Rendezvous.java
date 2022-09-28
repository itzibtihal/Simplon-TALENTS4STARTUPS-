package com.example.app.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "rendezvous")
public class Rendezvous {
	@Id
	@Column(columnDefinition = "serial")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
    private String mail;
    private String fullname;
	

	
	
	// Current Date
	//@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = false)
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	
	
	private String Subject;
	private String methoderendezvous;
	
	
	private Date daterendezvous;
	@Column(name = "client_id")
	private Integer clientId;

	@ManyToOne(targetEntity = Client.class, fetch = FetchType.LAZY)
	@JoinColumn(name = "client_id", insertable = false, updatable = false)
	@JsonIgnore
	private Client clients;
	
	@PrePersist
	private void onCreate() {
		daterendezvous = new Date();
	}
	

	// @ManyToOne(fetch = FetchType.LAZY)
	// @JoinColumn(name = "client_id")
	// private Client clients;

	


    
	
	public Date getDateRendezvous() {
		return daterendezvous;
	}

	public String getMail() {
		return mail;
	}


	public void setMail(String mail) {
		this.mail = mail;
	}


	public String getFullname() {
		return fullname;
	}


	public void setFullname(String fullname) {
		this.fullname = fullname;
	}


	public void setDateRendezvous(Date dateRendezvous) {
		this.daterendezvous = dateRendezvous;
	}
	
	public void setSubject(String Subject) {
		this.Subject = Subject;
	}
	
	public String getSubject() {
		return Subject;
	}
	
	public void setMethoderendezvoust(String methoderendezvous) {
		this.methoderendezvous = methoderendezvous;
	}
	
	public String getMthoderendezvous() {
		return methoderendezvous;
	}
	
	
}
