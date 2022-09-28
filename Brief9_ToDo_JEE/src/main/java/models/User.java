<<<<<<< HEAD
package models;

public class User {

	private String username,name,password;

	public User(String username, String name, String password) {
		this.username = username;
		this.name = name;
		this.password = password;
	}

	public User() {

	} 
	
	public User(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}
 
	public void setUsername(String username) {
		this.username = username;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", name=" + name + ", password=" + password + "]";
	}

	public void afficher() {
		System.out.println(toString());
	} 
	

=======
package models;

public class User {

	private String username,name,password;

	public User(String username, String name, String password) {
		this.username = username;
		this.name = name;
		this.password = password;
	}

	public User() {

	} 
	
	public User(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}
 
	public void setUsername(String username) {
		this.username = username;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", name=" + name + ", password=" + password + "]";
	}

	public void afficher() {
		System.out.println(toString());
	} 
	

>>>>>>> fbf558e1d5a02f2cb34c27c924b1e54a4f44962a
}