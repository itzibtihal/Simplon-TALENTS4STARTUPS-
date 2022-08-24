package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class Cours {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	private long id;
	@Column(name="COURSNOM")
	private String coursNom;
	@Column(name="TYPE")
	private String type;
	
	@ManyToOne
	private Prof prof;
	
	@ManyToOne
	private Etudiant etudiant;

	public Cours(long id, String coursNom, String type, Prof prof, Etudiant etudiant) {
		super();
		this.id = id;
		this.coursNom = coursNom;
		this.type = type;
		this.prof = prof;
		this.etudiant = etudiant;
	}

	public Cours(String coursNom, String type, Prof prof, Etudiant etudiant) {
		super();
		this.coursNom = coursNom;
		this.type = type;
		this.prof = prof;
		this.etudiant = etudiant;
	}
	

	public Cours() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCoursNom() {
		return coursNom;
	}

	public void setCoursNom(String coursNom) {
		this.coursNom = coursNom;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Prof getProf() {
		return prof;
	}

	public void setProf(Prof prof) {
		this.prof = prof;
	}

	public Etudiant getEtudiant() {
		return etudiant;
	}

	public void setEtudiant(Etudiant etudiant) {
		this.etudiant = etudiant;
	}

	@Override
	public String toString() {
		return "Cours [id=" + id + ", coursNom=" + coursNom + ", type=" + type + ", prof=" + prof + ", etudiant="
				+ etudiant + "]";
	}
	
	
	
	
	

}
