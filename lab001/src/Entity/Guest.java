package Entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the guest database table.
 * 
 */
@Entity
@NamedQuery(name="Guest.findAll", query="SELECT g FROM Guest g")
public class Guest implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="enduser_id")
	private Long enduserId;

	//bi-directional one-to-one association to Enduser
	@OneToOne
	@JoinColumn(name="enduser_id")
	private Enduser enduser;

	//bi-directional many-to-one association to Payment
	@OneToMany(mappedBy="guest")
	private List<Payment> payments;

	public Guest() {
	}

	public Long getEnduserId() {
		return this.enduserId;
	}

	public void setEnduserId(Long enduserId) {
		this.enduserId = enduserId;
	}

	public Enduser getEnduser() {
		return this.enduser;
	}

	public void setEnduser(Enduser enduser) {
		this.enduser = enduser;
	}

	public List<Payment> getPayments() {
		return this.payments;
	}

	public void setPayments(List<Payment> payments) {
		this.payments = payments;
	}

	public Payment addPayment(Payment payment) {
		getPayments().add(payment);
		payment.setGuest(this);

		return payment;
	}

	public Payment removePayment(Payment payment) {
		getPayments().remove(payment);
		payment.setGuest(null);

		return payment;
	}

}