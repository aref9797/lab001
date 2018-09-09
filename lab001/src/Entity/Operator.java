package Entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the operator database table.
 * 
 */
@Entity
@NamedQueries({
@NamedQuery(name="Operator.findAll", query="SELECT o FROM Operator o"),
@NamedQuery(name="Operator.findbyusername", query="SELECT o FROM Operator o where (o.username=:username)"),
@NamedQuery(name="Operator.findbyemail", query="SELECT o FROM Operator o where (o.email=:email)"),
})

public class Operator implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	private String email;

	private String family;

	private String mobile;

	private String name;

	private String password;

	private String username;

	public Operator() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFamily() {
		return this.family;
	}

	public void setFamily(String family) {
		this.family = family;
	}

	public String getMobile() {
		return this.mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}