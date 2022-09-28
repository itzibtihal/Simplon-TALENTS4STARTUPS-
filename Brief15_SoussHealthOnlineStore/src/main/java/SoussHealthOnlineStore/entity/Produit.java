package SoussHealthOnlineStore.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "numProduit")
@Table(name = "produit")
public class Produit {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long numProduit;
	
	@NonNull
	@Size(min = 2, max = 50, message="MIN 2 MAX 50")
	@Column(name = "nomProduit")
	private String nomProduit;
	
	@NonNull
	@Size(min = 2, max = 50, message="MIN 2 MAX 50")
	@Column(name = "company")
	private String company;
	
	@NonNull
	@Column(name = "prix")
	private Double prix;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "dateExpiration")
	private Date dateExpiration;
	
	@ManyToOne
	@JoinColumn(name = "id_admin")
	private Admin admin;
	
	@ManyToOne
	@JoinColumn(name = "numCategorie")
	private Categorie categorie;
	
//    @OneToMany(mappedBy = "client")
//    private Set<Commande> commande = new HashSet<>();

//	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
//	@JoinTable(name = "commande",
//		joinColumns = @JoinColumn(name = "numProduit"),
//		inverseJoinColumns = @JoinColumn(name = "id")
//	)
//	private Set<Client> client = new HashSet<>();
////	private List<Client> client = new ArrayList<>();
	
}
