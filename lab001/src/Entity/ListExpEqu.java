package Entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the list_exp_equ database table.
 * 
 */
@Entity
@Table(name="list_exp_equ")
@NamedQuery(name="ListExpEqu.findAll", query="SELECT l FROM ListExpEqu l")
public class ListExpEqu implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	//bi-directional many-to-one association to Equipment
	@ManyToOne
	@JoinColumn(name="eqi_id")
	private Equipment equipment;

	//bi-directional many-to-one association to Experiment
	@ManyToOne
	@JoinColumn(name="exp_id")
	private Experiment experiment;

	public ListExpEqu() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Equipment getEquipment() {
		return this.equipment;
	}

	public void setEquipment(Equipment equipment) {
		this.equipment = equipment;
	}

	public Experiment getExperiment() {
		return this.experiment;
	}

	public void setExperiment(Experiment experiment) {
		this.experiment = experiment;
	}

}