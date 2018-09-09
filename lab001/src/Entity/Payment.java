package Entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the payment database table.
 * 
 */
@Entity
@NamedQuery(name="Payment.findAll", query="SELECT p FROM Payment p")
public class Payment implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@Temporal(TemporalType.DATE)
	private Date date;

	private String details;

	//bi-directional many-to-one association to GuestResrevation
	@OneToMany(mappedBy="payment")
	private List<GuestResrevation> guestResrevations;

	//bi-directional many-to-one association to Guest
	@ManyToOne
	@JoinColumn(name="guest_id")
	private Guest guest;

	//bi-directional many-to-one association to GuestResrevation
	@ManyToOne
	@JoinColumn(name="reserv_guest_id")
	private GuestResrevation guestResrevation;

	public Payment() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getDetails() {
		return this.details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public List<GuestResrevation> getGuestResrevations() {
		return this.guestResrevations;
	}

	public void setGuestResrevations(List<GuestResrevation> guestResrevations) {
		this.guestResrevations = guestResrevations;
	}

	public GuestResrevation addGuestResrevation(GuestResrevation guestResrevation) {
		getGuestResrevations().add(guestResrevation);
		guestResrevation.setPayment(this);

		return guestResrevation;
	}

	public GuestResrevation removeGuestResrevation(GuestResrevation guestResrevation) {
		getGuestResrevations().remove(guestResrevation);
		guestResrevation.setPayment(null);

		return guestResrevation;
	}

	public Guest getGuest() {
		return this.guest;
	}

	public void setGuest(Guest guest) {
		this.guest = guest;
	}

	public GuestResrevation getGuestResrevation() {
		return this.guestResrevation;
	}

	public void setGuestResrevation(GuestResrevation guestResrevation) {
		this.guestResrevation = guestResrevation;
	}

}