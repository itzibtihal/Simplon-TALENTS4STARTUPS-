package stcManager.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.ToString;


@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
@Builder
@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idadmin")

@Table(name = "admin")
public class Admin {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idadmin;
	
	@NonNull
	@Size(min = 3, max = 50)
	@Column(name = "nom")
	private String nom;
	
	@NonNull
	@Size(min = 3, max = 50)
	@Column(name = "prenom")
	private String prenom;
	
	@NonNull
	@Size(min = 10, max = 50)
	@Column(name = "email")
	private String email;
	
	@NonNull
	@Size(min = 3, max = 50)
	@Column(name = "login")
	private String login;
	
	@NonNull
	@Size(min = 3, max = 50)
	@Column(name = "password")
	private String password;
	
	@NonNull
	@Size(min = 3, max = 10)
	@Column(name = "telephone")
	private String telephone;
	
	@NonNull
	@Size(min = 3, max = 50)
	@Column(name = "etat")
	private String etat;
	
}
