package stcManager.entity;

import java.util.ArrayList;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
@Entity
@Table(name = "exercice")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "ref_exercice")

public class Exercice {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long ref_exercice;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy")
	@Column(name = "annee")
	private Date annee ;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd-mm-yyyy")
	@Column(name = "dateDebut")
	private Date dateDebut;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd-mm-yyyy")
	@Column(name = "dateFin")
	private Date dateFin;
	
	@NonNull
	@Size(min = 3, max = 50)
	@Column(name = "statut")
	private String statut;
		
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="fk_ref_exercice",referencedColumnName ="ref_exercice")
	private List<Activite> activite = new ArrayList <Activite> ();
}
