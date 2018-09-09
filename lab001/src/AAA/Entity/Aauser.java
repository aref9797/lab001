package AAA.Entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the aauser database table.
 * 
 */
@Entity
@NamedQueries({ @NamedQuery(name = "Aauser.findAll", query = "SELECT a FROM Aauser a"),
@NamedQuery(name = "Aauser.findbyname", query = "SELECT a FROM Aauser a WHERE (a.name=:name)"),
@NamedQuery(name = "Aauser.findbyUsername", query = "SELECT a FROM Aauser a WHERE (a.username=:username)"),
@NamedQuery(name = "Aauser.findbyUserPass", query = "SELECT a FROM Aauser a WHERE (a.username=:username AND a.hpassword=:password)"),
@NamedQuery(name = "Aauser.findbyUserEmail", query = "SELECT a FROM Aauser a WHERE (a.username=:username AND a.email=:email)"),
@NamedQuery(name = "Aauser.findbyEmail", query = "SELECT a FROM Aauser a WHERE (a.email=:email)"),
@NamedQuery(name = "Aauser.findbyUserPassDeactives", query = "SELECT a FROM Aauser a WHERE (a.username=:username AND a.hpassword=:password)"),
@NamedQuery(name = "Aauser.findbyHit", query = "SELECT a FROM Aauser a WHERE (a.hit=:hit)"),
})

public class Aauser implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	private String email;

	private String family;

	private String hit;

	private String hpassword;

	private Boolean isaccept;

	@Column(name="\"isActive\"")
	private Boolean isActive;

	private String mellicode;

	private String mobile;

	private String name;

	private String stdcode;

	private String type;

	private String username;

	//bi-directional many-to-one association to Aasession
	@OneToMany(mappedBy="aauser")
	private List<Aasession> aasessions;

	//bi-directional many-to-one association to Aarole
	@ManyToOne
	@JoinColumn(name="roleid")
	private Aarole aarole;

	public Aauser() {
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

	public String getHit() {
		return this.hit;
	}

	public void setHit(String hit) {
		this.hit = hit;
	}

	public String getHpassword() {
		return this.hpassword;
	}

	public void setHpassword(String hpassword) {
		this.hpassword = hpassword;
	}

	public Boolean getIsaccept() {
		return this.isaccept;
	}

	public void setIsaccept(Boolean isaccept) {
		this.isaccept = isaccept;
	}

	public Boolean getIsActive() {
		return this.isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public String getMellicode() {
		return this.mellicode;
	}

	public void setMellicode(String mellicode) {
		this.mellicode = mellicode;
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

	public String getStdcode() {
		return this.stdcode;
	}

	public void setStdcode(String stdcode) {
		this.stdcode = stdcode;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<Aasession> getAasessions() {
		return this.aasessions;
	}

	public void setAasessions(List<Aasession> aasessions) {
		this.aasessions = aasessions;
	}

	public Aasession addAasession(Aasession aasession) {
		getAasessions().add(aasession);
		aasession.setAauser(this);

		return aasession;
	}

	public Aasession removeAasession(Aasession aasession) {
		getAasessions().remove(aasession);
		aasession.setAauser(null);

		return aasession;
	}

	public Aarole getAarole() {
		return this.aarole;
	}

	public void setAarole(Aarole aarole) {
		this.aarole = aarole;
	}

}