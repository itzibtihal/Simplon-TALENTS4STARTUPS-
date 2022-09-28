package stcManager.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.AllArgsConstructor;
import lombok.Data;
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
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idresponsable")

@Table(name = "responsable")
public class Responsable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idresponsable;
	
	@NonNull
	@Size(min = 3, max = 50)
	@Column(name = "nom")
	private String nom;
	
	@NonNull
	@Size(min = 3, max = 50)
	@Column(name = "prenom")
	private String prenom;
	
	@NonNull
	@Size(max = 50)
	@Column(name = "domaine")
	private String domaine;
	
	@NonNull
	@Size(max = 50)
	@Column(name = "type")
	private String type;
	
	@NonNull
	@Size(min = 3, max = 10)
	@Column(name = "telephone")
	private String telephone;
	
	@NonNull
	@Size(min = 3,max = 50)
	@Column(name = "etat")
	private String etat;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="fk_idresponsable",referencedColumnName ="idresponsable")
	private List<Activite> activite = new ArrayList <Activite> ();
 
}
