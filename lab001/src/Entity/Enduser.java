package Entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the enduser database table.
 * 
 */
@Entity
@NamedQuery(name="Enduser.findAll", query="SELECT e FROM Enduser e")
public class Enduser implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="user_id")
	private Long userId;

	@Column(name="code_meli")
	private Integer codeMeli;

	private String field;

	private Long hitpass;

	private Boolean isactive;

	//bi-directional one-to-one association to Guest
	@OneToOne(mappedBy="enduser")
	private Guest guest;

	//bi-directional one-to-one association to Professor
	@OneToOne(mappedBy="enduser")
	private Professor professor;

	public Enduser() {
	}

	public Long getUserId() {
		return this.userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Integer getCodeMeli() {
		return this.codeMeli;
	}

	public void setCodeMeli(Integer codeMeli) {
		this.codeMeli = codeMeli;
	}

	public String getField() {
		return this.field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public Long getHitpass() {
		return this.hitpass;
	}

	public void setHitpass(Long hitpass) {
		this.hitpass = hitpass;
	}

	public Boolean getIsactive() {
		return this.isactive;
	}

	public void setIsactive(Boolean isactive) {
		this.isactive = isactive;
	}

	public Guest getGuest() {
		return this.guest;
	}

	public void setGuest(Guest guest) {
		this.guest = guest;
	}

	public Professor getProfessor() {
		return this.professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

}