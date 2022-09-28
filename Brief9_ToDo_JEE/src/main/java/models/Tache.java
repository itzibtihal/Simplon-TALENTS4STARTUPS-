<<<<<<< HEAD
package models;



public class Tache  {
	 
	private String titre;
	private String description;
	private String statut; 
	public  String deadline; 
	private String nom_category;
	 
	public Tache(String nom_category, String titre, String description, String statut, String deadline) {
		this.nom_category=nom_category;
		this.titre = titre;
		this.description = description;
		this.statut = statut; 
		this.deadline = deadline; 
	} 

	  

	public Tache() {
 
	}

 
	public Tache(String titre) {
		this.titre = titre;
	}



	public String getNom_category() {
		return nom_category;
	}



	public void setNom_category(String nom_category) {
		this.nom_category = nom_category;
	}



	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getStatut() {
		return statut;
	}
	public void setStatut(String statut) {
		this.statut = statut;
	}
	public String getDeadline() {
		return deadline;
	}
	public void setDeadline(String deadline) {
		this.deadline = deadline;
	}  
	@Override
	public String toString() {
		return "Tache [titre=" + titre + ", description=" + description + ", statut=" + statut + ", deadline="
				+ deadline + ", nom_category=" + nom_category + "]"; 
	}
	 
	
	
}
=======
package models;



public class Tache  {
	 
	private String titre;
	private String description;
	private String statut; 
	public  String deadline; 
	private String nom_category;
	 
	public Tache(String nom_category, String titre, String description, String statut, String deadline) {
		this.nom_category=nom_category;
		this.titre = titre;
		this.description = description;
		this.statut = statut; 
		this.deadline = deadline; 
	} 

	  

	public Tache() {
 
	}

 
	public Tache(String titre) {
		this.titre = titre;
	}



	public String getNom_category() {
		return nom_category;
	}



	public void setNom_category(String nom_category) {
		this.nom_category = nom_category;
	}



	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getStatut() {
		return statut;
	}
	public void setStatut(String statut) {
		this.statut = statut;
	}
	public String getDeadline() {
		return deadline;
	}
	public void setDeadline(String deadline) {
		this.deadline = deadline;
	}  
	@Override
	public String toString() {
		return "Tache [titre=" + titre + ", description=" + description + ", statut=" + statut + ", deadline="
				+ deadline + ", nom_category=" + nom_category + "]"; 
	}
	 
	
	
}
>>>>>>> fbf558e1d5a02f2cb34c27c924b1e54a4f44962a
