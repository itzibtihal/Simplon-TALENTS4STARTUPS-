package model;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table
public class Prof {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	private long id;
	@Column(name="NOM")
	private String nom;
	@Column(name="PRENOM")
	private String prenom;
	@Column(name="EMAIL")
	private String email;
	@Column(name="SALAIRE")
	private double salaire;
	
	@OneToMany(mappedBy = "prof" , fetch = FetchType.EAGER)
	private Collection<Cours> cours = new ArrayList<Cours>();

	public Prof(long id, String nom, String prenom, String email, double salaire, Collection<Cours> cours) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.salaire = salaire;
		this.cours = cours;
	}

	public Prof(String nom, String prenom, String email, double salaire, Collection<Cours> cours) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.salaire = salaire;
		this.cours = cours;
	}

	public Prof() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public double getSalaire() {
		return salaire;
	}

	public void setSalaire(double salaire) {
		this.salaire = salaire;
	}

	public Collection<Cours> getCours() {
		return cours;
	}

	public void setCours(Collection<Cours> cours) {
		this.cours = cours;
	}

	@Override
	public String toString() {
		return "Prof [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", email=" + email + ", salaire=" + salaire
				+ ", cours=" + cours + "]";
	}
	
	
	
	}
	
	
	
	


