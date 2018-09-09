package Entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the chargelist database table.
 * 
 */
@Entity
@NamedQuery(name="Chargelist.findAll", query="SELECT c FROM Chargelist c")
public class Chargelist implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	private double amount;

	@Column(name="user_id")
	private Long userId;

	//bi-directional many-to-one association to Professor
	@ManyToOne
	@JoinColumn(name="professor_id")
	private Professor professor;

	public Chargelist() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public double getAmount() {
		return this.amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Long getUserId() {
		return this.userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Professor getProfessor() {
		return this.professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

}