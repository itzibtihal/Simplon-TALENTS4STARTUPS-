package br5;

import java.util.Objects;

public class Condidats {
	private int id;
	private String nom;
	private String prenom;
	private String mail;
	private String adress;
	private String ville;
	private String pays; 
	
	
	
	public Condidats() {
		super();
	}
	public Condidats(String nom, String prenom, String mail, String adress, String ville, String pays) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.mail = mail;
		this.adress = adress;
		this.ville = ville;
		this.pays = pays;
		
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	

	public String getnom() {
		return nom;
	}
	public void setnom (String nom ) {
		this.nom = nom;
	}
	
	
	public String getprenom() {
		return prenom;
	}
	public void setprenom (String prenom) {
		this.prenom = prenom;
	}
	
	
	public String getmail() {
		return mail;
	}
	public void setmail (String mail) {
		this.mail = mail;
	}
	
	
	public String getadress() {
		return adress;
	}
	public void setadress (String adress ) {
		this.adress= adress;
	}
	
	
	public String getville() {
		return ville;
	}
	public void setville (String ville ) {
		this.ville = ville;
	}
	
	
	
	public String getpays() {
		return pays;
	}
	public void setpays (String pays ) {
		this.pays = pays;
	}
	
	
//	@Override
//	public int hashCode() {
//		return Objects.hash(adress, id, mail, nom, pays, prenom, ville);
//	}
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		Condidats other = (Condidats) obj;
//		return Objects.equals(adress, other.adress) && id == other.id && Objects.equals(mail, other.mail)
//				&& Objects.equals(nom, other.nom) && Objects.equals(pays, other.pays)
//				&& Objects.equals(prenom, other.prenom) && Objects.equals(ville, other.ville);
//	}
	@Override
	public String toString() {
		return "Condidats [nom=" + nom + ", prenom=" + prenom + ", mail=" + mail + ", adress=" + adress + ", ville="
				+ ville + ", pays=" + pays + "]";
	}
	
	
	
	
}
