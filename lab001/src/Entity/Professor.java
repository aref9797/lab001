package Entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the professor database table.
 * 
 */
@Entity
@NamedQuery(name="Professor.findAll", query="SELECT p FROM Professor p")
public class Professor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="enduser_id")
	private Long enduserId;

	private double charge;

	private Boolean isbroken;

	@Column(name="professor_n")
	private Long professorN;

	//bi-directional many-to-one association to Chargelist
	@OneToMany(mappedBy="professor")
	private List<Chargelist> chargelists;

	//bi-directional one-to-one association to Enduser
	@OneToOne
	@JoinColumn(name="enduser_id")
	private Enduser enduser;

	//bi-directional many-to-one association to StudentReservation
	@OneToMany(mappedBy="professor")
	private List<StudentReservation> studentReservations;

	public Professor() {
	}

	public Long getEnduserId() {
		return this.enduserId;
	}

	public void setEnduserId(Long enduserId) {
		this.enduserId = enduserId;
	}

	public double getCharge() {
		return this.charge;
	}

	public void setCharge(double charge) {
		this.charge = charge;
	}

	public Boolean getIsbroken() {
		return this.isbroken;
	}

	public void setIsbroken(Boolean isbroken) {
		this.isbroken = isbroken;
	}

	public Long getProfessorN() {
		return this.professorN;
	}

	public void setProfessorN(Long professorN) {
		this.professorN = professorN;
	}

	public List<Chargelist> getChargelists() {
		return this.chargelists;
	}

	public void setChargelists(List<Chargelist> chargelists) {
		this.chargelists = chargelists;
	}

	public Chargelist addChargelist(Chargelist chargelist) {
		getChargelists().add(chargelist);
		chargelist.setProfessor(this);

		return chargelist;
	}

	public Chargelist removeChargelist(Chargelist chargelist) {
		getChargelists().remove(chargelist);
		chargelist.setProfessor(null);

		return chargelist;
	}

	public Enduser getEnduser() {
		return this.enduser;
	}

	public void setEnduser(Enduser enduser) {
		this.enduser = enduser;
	}

	public List<StudentReservation> getStudentReservations() {
		return this.studentReservations;
	}

	public void setStudentReservations(List<StudentReservation> studentReservations) {
		this.studentReservations = studentReservations;
	}

	public StudentReservation addStudentReservation(StudentReservation studentReservation) {
		getStudentReservations().add(studentReservation);
		studentReservation.setProfessor(this);

		return studentReservation;
	}

	public StudentReservation removeStudentReservation(StudentReservation studentReservation) {
		getStudentReservations().remove(studentReservation);
		studentReservation.setProfessor(null);

		return studentReservation;
	}

}