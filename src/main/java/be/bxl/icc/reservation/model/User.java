package be.bxl.icc.reservation.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

<<<<<<< HEAD
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@Entity
@Table(name="users")
public class User  {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable=false,unique=true,length=20)
	private String login;
	
	@Column(nullable=false,unique=true)
	private String password;
	
	@Column(nullable=false,length=40)
	private String firstname;
	
	@Column(nullable=false,length=40)
	private String lastname;
	
	@Column(nullable=false,unique=true,length=20)
    private String email;
	
	@Column(nullable=false,length=2)
	private String langue;
	
	
	public User( String login, String password) {
		super();
	
		this.login = login;
		this.password = password;
	
	}


	private LocalDateTime created_at;
	
	@ManyToMany(mappedBy = "users",fetch = FetchType.EAGER,cascade= CascadeType.ALL)
	private List<Role> roles = new ArrayList<>();
	
	@ManyToMany(mappedBy = "users")
	private List<Representation> representations = new ArrayList<>();


	public User() {}
=======
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="users")
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String login;
	private String password;
	private String firstname;
	private String lastname;
private String email;
	private String langue;
	private LocalDateTime created_at;
	
	@ManyToMany(mappedBy = "users")
	private List<Role> roles = new ArrayList<>();

	@ManyToMany(mappedBy = "users")
	private List<Representation> representations = new ArrayList<>();

	protected User() {}
>>>>>>> c7157af6537b517182225d6af80df4e914770d67

	public User(String login, String firstname, String lastname) {
		this.login = login;
		this.firstname = firstname;
		this.lastname = lastname;
		this.created_at = LocalDateTime.now();
	}

	public Long getId() {
		return id;
	}	
	
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
<<<<<<< HEAD

=======
>>>>>>> c7157af6537b517182225d6af80df4e914770d67
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	 
        public String getLangue() {
		return langue;
	}

	public void setLangue(String langue) {
		this.langue = langue;
	}

	public List<Role> getRoles() {
		return roles;
	}
<<<<<<< HEAD
=======
	public List<Representation> getRepresentations() {
		return representations;
	}

	public User addRepresentation(Representation representation) {
		if(!this.representations.contains(representation)) {
			this.representations.add(representation);
			representation.addUser(this);
		}
		
		return this;
	}
	
	public User removeRepresentation(Representation representation) {
		if(this.representations.contains(representation)) {
			this.representations.remove(representation);
			representation.getUsers().remove(this);
		}
		
		return this;
	}

>>>>>>> c7157af6537b517182225d6af80df4e914770d67

	public LocalDateTime getCreated_at() {
		return created_at;
	}
	
	public User addRole(Role role) {
		if(!this.roles.contains(role)) {
			this.roles.add(role);
			role.addUser(this);
		}
		
		return this;
	}
	
	public User removeRole(Role role) {
		if(this.roles.contains(role)) {
			this.roles.remove(role);
			role.getUsers().remove(this);
		}
		
		return this;
	}
<<<<<<< HEAD
	public void setCreated_at(LocalDateTime created_at) {
		this.created_at = created_at;
	}

	public List<Representation> getRepresentations() {
		return representations;
	}

public User addRepresentation(Representation representation) {
		if(!this.representations.contains(representation)) {
			this.representations.add(representation);
			representation.addUser(this);
		}
		
		return this;
	}
	
	public User removeRepresentation(Representation representation) {
		if(this.representations.contains(representation)) {
			this.representations.remove(representation);
			representation.getUsers().remove(this);
		}
		
		return this;
	}

=======
>>>>>>> c7157af6537b517182225d6af80df4e914770d67

	@Override
	public String toString() {
		return login + "(" + firstname + " " + lastname + ")";
	}
<<<<<<< HEAD

	
	
=======
>>>>>>> c7157af6537b517182225d6af80df4e914770d67
}
