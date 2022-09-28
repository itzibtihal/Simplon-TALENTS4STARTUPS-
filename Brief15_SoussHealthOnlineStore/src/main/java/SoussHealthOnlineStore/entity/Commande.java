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
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "numCommande")

@Table(name = "commande")
public class Commande {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long numCommande;
    
	@Temporal(TemporalType.DATE)
	@Column(name = "dateCommande")
	private Date dateCommande;
	
	@NonNull
	@Column(name = "prix_total")
	private Double prix_total;
	
	@Column(name = "quantite")
	private Long quantite;
	
    @ManyToOne
	@JoinColumn(name = "id_client")
    private Client client;

    @ManyToOne
	@JoinColumn(name = "numProduit")
    private Produit produit;
    
}
