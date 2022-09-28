package stcManager.security;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class Users {
		@Id
		private Long userId;

		@NotEmpty
		@Size(min = 4, max = 40)
		@Column(unique = true)
		private String login;

		@NotEmpty
		@Size(min = 4, max = 40)
		private String email;

		@NotEmpty
		@Size(min = 4, max = 40)
		private String username;

		@NotEmpty
		@Size(min = 4, max = 40)
		private String password;

		private boolean active;
		
		@Enumerated(EnumType.STRING) 
		private Role role;
}
