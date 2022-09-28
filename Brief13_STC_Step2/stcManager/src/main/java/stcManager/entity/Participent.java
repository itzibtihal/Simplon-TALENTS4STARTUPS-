package stcManager.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
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
@Table(name = "participent")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idparticipent")


public class Participent {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idparticipent;
	
	@NonNull
	@Size(min = 3, max = 50)
	@Column(name = "fullname")
	private String fullname;
	
	@NonNull
	@Size(max = 50)
	@Column(name = "domaine")
	private String domaine;
	
	@NonNull
	@Size(max = 50)
	@Column(name = "email")
	private String email;
	
	@NonNull
	@Size(max = 50)
	@Column(name = "structure")
	private String structure;
	
	@ManyToMany(mappedBy = "participent" ,cascade = CascadeType.ALL)
    private List<Activite> activite = new ArrayList<>();

}
