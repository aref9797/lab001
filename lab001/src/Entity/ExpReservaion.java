package Entity;

import java.io.Serializable;
import javax.persistence.*;

import AAA.Entity.Aauser;


/**
 * The persistent class for the exp_reservaion database table.
 * 
 */
@Entity
@Table(name="exp_reservaion")
@NamedQuery(name="ExpReservaion.findAll", query="SELECT e FROM ExpReservaion e")
public class ExpReservaion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	//bi-directional many-to-one association to Aauser
	@ManyToOne
	@JoinColumn(name="user_id")
	private Aauser user;

	//bi-directional many-to-one association to Experiment
	@ManyToOne
	@JoinColumn(name="exp_id")
	private Experiment experiment;

	//bi-directional many-to-one association to ExprementStatuse
	@ManyToOne
	@JoinColumn(name="statuse_id")
	private ExprementStatuse exprementStatuse;

	//bi-directional one-to-one association to GuestResrevation
	@OneToOne(mappedBy="expReservaion")
	private GuestResrevation guestResrevation;

	//bi-directional one-to-one association to StudentReservation
	@OneToOne(mappedBy="expReservaion")
	private StudentReservation studentReservation;

	public ExpReservaion() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Aauser getAauser() {
		return this.user;
	}

	public void setAauser(Aauser user) {
		this.user = user;
	}

	public Experiment getExperiment() {
		return this.experiment;
	}

	public void setExperiment(Experiment experiment) {
		this.experiment = experiment;
	}

	public ExprementStatuse getExprementStatuse() {
		return this.exprementStatuse;
	}

	public void setExprementStatuse(ExprementStatuse exprementStatuse) {
		this.exprementStatuse = exprementStatuse;
	}

	public GuestResrevation getGuestResrevation() {
		return this.guestResrevation;
	}

	public void setGuestResrevation(GuestResrevation guestResrevation) {
		this.guestResrevation = guestResrevation;
	}

	public StudentReservation getStudentReservation() {
		return this.studentReservation;
	}

	public void setStudentReservation(StudentReservation studentReservation) {
		this.studentReservation = studentReservation;
	}

}