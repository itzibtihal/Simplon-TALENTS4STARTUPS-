package SoussHealthOnlineStore.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
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
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "numCategorie")
@Table(name = "categorie")
public class Categorie {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long numCategorie;
	@NonNull
	@Size(min = 2, max = 50, message="MIN 2 MAX 50")
	@Column(name = "type")
	private String type;
	
	@ManyToOne
	@JoinColumn(name = "id_admin")
	private Admin admin;
	
//	@OneToMany(cascade = CascadeType.ALL)
//	@JoinColumn(name="numProduit",referencedColumnName ="numCategorie")
//	private List<Produit> produit = new ArrayList <Produit> ();
}
