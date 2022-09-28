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
@Table(name = "admin")
public class Admin extends User{
	
	@NonNull
	@Size(min = 3, max = 50 ,message="MIN 3 MAX 50")
	@Column(name = "fullname")
	private String fullName;

	public Admin(String fullname, String email, String password) {
		super(email, password);
		this.fullName=fullname;
	}	
	
//	@OneToMany(cascade = CascadeType.ALL)
//	@JoinColumn(name="id_admin",referencedColumnName ="id")
//	private List<Categorie> categorie = new ArrayList <Categorie> ();
//	
//	@OneToMany(cascade = CascadeType.ALL)
//	@JoinColumn(name="id_admin",referencedColumnName ="id")
//	private List<Produit> produit = new ArrayList <Produit> ();

}
