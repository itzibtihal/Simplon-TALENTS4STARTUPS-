package SoussHealthOnlineStore.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@Table(name = "client")
public class Client extends User{
	
	@NonNull
	@Size(min = 3, max = 50 ,message="MIN 3 MAX 50")
	@Column(name = "nom")
	private String nom;
	
	@NonNull
	@Size(min = 3, max = 50, message="MIN 3 MAX 50")
	@Column(name = "prenom")
	private String prenom;
	
	@NonNull
	@Size(min = 3, max = 50, message="MIN 3 MAX 50")
	@Column(name = "cin")
	private String cin;
	
	@NonNull
	@Size(min = 3, max = 50, message="MIN 3 MAX 50")
	@Column(name = "ville")
	private String ville;
	
	@NonNull
	@Size(min = 3, max = 50, message="MIN 3 MAX 50")
	@Column(name = "telephone")
	private String telephone;
	
	@NonNull
	@Size(min = 3, max = 50, message="MIN 3 MAX 50")
	@Column(name = "adresse")
	private String adresse;

	public Client(String email, String password, String nom, String prenom, String cin, String ville, String telephone, String adresse) {
		super(email, password);
		this.nom = nom;
		this.prenom = prenom;
		this.cin = cin;
		this.ville = ville;
		this.telephone = telephone;
		this.adresse = adresse;
	}
	
	
//    @OneToMany(mappedBy = "produit")
//    private Set<Commande> commande = new HashSet<>();
    
    
//	@ManyToMany(mappedBy = "produit" ,cascade = CascadeType.ALL)
//    private List<Produit> produit = new ArrayList<>();
	
	
}
