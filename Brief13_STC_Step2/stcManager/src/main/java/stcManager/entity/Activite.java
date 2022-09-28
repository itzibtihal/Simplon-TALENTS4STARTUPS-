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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

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
@Getter
@Setter
@ToString
@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "ref_activite")
@Table(name = "activite")
public class Activite {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long ref_activite;
	
	@NonNull
	@Size(min = 3, max = 50)
	@Column(name = "titreActivite")
	private String titreActivite;
	
	@NonNull
	@Size(min = 3, max = 50)
	@Column(name = "descriptif")
	private String descriptif;
	
	@NonNull
	@Size(min = 3, max = 50)
	@Column(name = "type")
	private String type;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd-mm-yyyy")
	@Column(name = "dateDebut")
	private Date dateDebut;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd-mm-yyyy")	
	@Column(name = "dateFin")
	private Date  dateFin;
	
	@NonNull
	@Size(min = 3, max = 50)
	@Column(name = "etat")
	private String etat;

	@ManyToOne
	@JoinColumn(name = "fk_idresponsable")
	private Responsable responsable;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_ref_exercice")
	private Exercice exercice;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "participent_activite",
		joinColumns = @JoinColumn(name = "ref_activite"),
		inverseJoinColumns = @JoinColumn(name = "idparticipent")
	)
	private List<Participent> participent = new ArrayList<>();

	public long getRef_activite() {
		return ref_activite;
	}

	public void setRef_activite(long ref_activite) {
		this.ref_activite = ref_activite;
	}

	public String getTitreActivite() {
		return titreActivite;
	}

	public void setTitreActivite(String titreActivite) {
		this.titreActivite = titreActivite;
	}

	public String getDescriptif() { 
		return descriptif;
	}

	public void setDescriptif(String descriptif) {
		this.descriptif = descriptif;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Date getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}

	public Date getDateFin() {
		return dateFin;
	}

	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}

	public String getEtat() {
		return etat;
	}

	public void setEtat(String etat) {
		this.etat = etat;
	}

	public Responsable getResponsable() {
		return responsable;
	}

	public void setResponsable(Responsable responsable) {
		this.responsable = responsable;
	}

	public Exercice getExercice() {
		return exercice;
	}

	public void setExercice(Exercice exercice) {
		this.exercice = exercice;
	}

	public List<Participent> getParticipent() {
		return participent;
	}

	public void setParticipent(List<Participent> participent) {
		this.participent = participent;
	}
	
	
}
