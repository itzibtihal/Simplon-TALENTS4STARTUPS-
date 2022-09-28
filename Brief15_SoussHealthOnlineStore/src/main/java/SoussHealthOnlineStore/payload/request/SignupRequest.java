package SoussHealthOnlineStore.payload.request;

import java.util.Set;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
public class SignupRequest {



	@NonNull
	@Size(min = 3, max = 50, message="MIN 3 MAX 50")
	@Email
	private String email;

	private Set<String> role;

	@NonNull
	@Size(min = 3, max = 50, message="MIN 3 MAX 50")
	private String password;
	
	@NonNull
	@Size(min = 3, max = 50, message="MIN 3 MAX 50")
	private String fullName;
	
	@NonNull
	@Size(min = 3, max = 50 ,message="MIN 3 MAX 50")
	private String nom;
	
	@NonNull
	@Size(min = 3, max = 50, message="MIN 3 MAX 50")
	private String prenom;
	
	@NonNull
	@Size(min = 3, max = 50, message="MIN 3 MAX 50")
	private String cin;
	
	@NonNull
	@Size(min = 3, max = 50, message="MIN 3 MAX 50")
	private String ville;
	
	@NonNull
	@Size(min = 3, max = 50, message="MIN 3 MAX 50")
	private String telephone;
	
	@NonNull
	@Size(min = 3, max = 50, message="MIN 3 MAX 50")
	private String adresse;

}
