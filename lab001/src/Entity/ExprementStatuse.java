package Entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the exprement_statuse database table.
 * 
 */
@Entity
@Table(name="exprement_statuse")
@NamedQuery(name="ExprementStatuse.findAll", query="SELECT e FROM ExprementStatuse e")
public class ExprementStatuse implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	private String details;

	//bi-directional many-to-one association to ExpReservaion
	@OneToMany(mappedBy="exprementStatuse")
	private List<ExpReservaion> expReservaions;

	public ExprementStatuse() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDetails() {
		return this.details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public List<ExpReservaion> getExpReservaions() {
		return this.expReservaions;
	}

	public void setExpReservaions(List<ExpReservaion> expReservaions) {
		this.expReservaions = expReservaions;
	}

	public ExpReservaion addExpReservaion(ExpReservaion expReservaion) {
		getExpReservaions().add(expReservaion);
		expReservaion.setExprementStatuse(this);

		return expReservaion;
	}

	public ExpReservaion removeExpReservaion(ExpReservaion expReservaion) {
		getExpReservaions().remove(expReservaion);
		expReservaion.setExprementStatuse(null);

		return expReservaion;
	}

}