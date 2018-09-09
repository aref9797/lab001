package Entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the student_reservation database table.
 * 
 */
@Entity
@Table(name="student_reservation")
@NamedQuery(name="StudentReservation.findAll", query="SELECT s FROM StudentReservation s")
public class StudentReservation implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="exp_res_id")
	private Long expResId;

	//bi-directional one-to-one association to ExpReservaion
	@OneToOne
	@JoinColumn(name="exp_res_id")
	private ExpReservaion expReservaion;

	//bi-directional many-to-one association to Professor
	@ManyToOne
	@JoinColumn(name="proffesor_id")
	private Professor professor;

	public StudentReservation() {
	}

	public Long getExpResId() {
		return this.expResId;
	}

	public void setExpResId(Long expResId) {
		this.expResId = expResId;
	}

	public ExpReservaion getExpReservaion() {
		return this.expReservaion;
	}

	public void setExpReservaion(ExpReservaion expReservaion) {
		this.expReservaion = expReservaion;
	}

	public Professor getProfessor() {
		return this.professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

}