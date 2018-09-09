package Entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the guest_resrevation database table.
 * 
 */
@Entity
@Table(name="guest_resrevation")
@NamedQuery(name="GuestResrevation.findAll", query="SELECT g FROM GuestResrevation g")
public class GuestResrevation implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="exp_resrv_id")
	private Long expResrvId;

	//bi-directional one-to-one association to ExpReservaion
	@OneToOne
	@JoinColumn(name="exp_resrv_id")
	private ExpReservaion expReservaion;

	//bi-directional many-to-one association to Payment
	@ManyToOne
	private Payment payment;

	//bi-directional many-to-one association to Payment
	@OneToMany(mappedBy="guestResrevation")
	private List<Payment> payments;

	public GuestResrevation() {
	}

	public Long getExpResrvId() {
		return this.expResrvId;
	}

	public void setExpResrvId(Long expResrvId) {
		this.expResrvId = expResrvId;
	}

	public ExpReservaion getExpReservaion() {
		return this.expReservaion;
	}

	public void setExpReservaion(ExpReservaion expReservaion) {
		this.expReservaion = expReservaion;
	}

	public Payment getPayment() {
		return this.payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	public List<Payment> getPayments() {
		return this.payments;
	}

	public void setPayments(List<Payment> payments) {
		this.payments = payments;
	}

	public Payment addPayment(Payment payment) {
		getPayments().add(payment);
		payment.setGuestResrevation(this);

		return payment;
	}

	public Payment removePayment(Payment payment) {
		getPayments().remove(payment);
		payment.setGuestResrevation(null);

		return payment;
	}

}