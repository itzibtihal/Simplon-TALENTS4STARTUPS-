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
public class Etudiant {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	private long id;
	@Column(name="NOM")
	private String nom;
	@Column(name="PRENOM")
	private String prenom;
	@Column(name="CLASSETUDIANT")
	private String classEtudiant;
	@Column(name="NBHORAIRE")
	private double nbHoraire;
	
	@OneToMany(mappedBy = "etudiant" , fetch = FetchType.EAGER)
	private Collection<Cours> cours = new ArrayList<Cours>();

	public Etudiant(long id, String nom, String prenom, String classEtudiant, double nbHoraire,
			Collection<Cours> cours) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.classEtudiant = classEtudiant;
		this.nbHoraire = nbHoraire;
		this.cours = cours;
	}

	public Etudiant(String nom, String prenom, String classEtudiant, double nbHoraire, Collection<Cours> cours) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.classEtudiant = classEtudiant;
		this.nbHoraire = nbHoraire;
		this.cours = cours;
	}

	public Etudiant() {
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

	public String getClassEtudiant() {
		return classEtudiant;
	}

	public void setClassEtudiant(String classEtudiant) {
		this.classEtudiant = classEtudiant;
	}

	public double getNbHoraire() {
		return nbHoraire;
	}

	public void setNbHoraire(double nbHoraire) {
		this.nbHoraire = nbHoraire;
	}

	public Collection<Cours> getCours() {
		return cours;
	}

	public void setCours(Collection<Cours> cours) {
		this.cours = cours;
	}

	@Override
	public String toString() {
		return "Etudiant [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", classEtudiant=" + classEtudiant
				+ ", nbHoraire=" + nbHoraire + ", cours=" + cours + "]";
	}
	
	
	
	
	
	
	

	
	
	
	
	
	

	
	
	
	
	
	
	

}
