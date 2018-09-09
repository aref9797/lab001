package Entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the m_user database table.
 * 
 */
@Entity
@Table(name="m_user")
@NamedQuery(name="MUser.findAll", query="SELECT m FROM MUser m")
public class MUser implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="user_id")
	private Long userId;

	//bi-directional many-to-one association to Equipment
	@OneToMany(mappedBy="MUser")
	private List<Equipment> equipments;

	//bi-directional many-to-one association to Laboratory
	@OneToMany(mappedBy="MUser")
	private List<Laboratory> laboratories;

	//bi-directional many-to-one association to Laboratory
	@ManyToOne
	@JoinColumn(name="lab_id")
	private Laboratory laboratory;

	public MUser() {
	}

	public Long getUserId() {
		return this.userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public List<Equipment> getEquipments() {
		return this.equipments;
	}

	public void setEquipments(List<Equipment> equipments) {
		this.equipments = equipments;
	}

	public Equipment addEquipment(Equipment equipment) {
		getEquipments().add(equipment);
		equipment.setMUser(this);

		return equipment;
	}

	public Equipment removeEquipment(Equipment equipment) {
		getEquipments().remove(equipment);
		equipment.setMUser(null);

		return equipment;
	}

	public List<Laboratory> getLaboratories() {
		return this.laboratories;
	}

	public void setLaboratories(List<Laboratory> laboratories) {
		this.laboratories = laboratories;
	}

	public Laboratory addLaboratory(Laboratory laboratory) {
		getLaboratories().add(laboratory);
		laboratory.setMUser(this);

		return laboratory;
	}

	public Laboratory removeLaboratory(Laboratory laboratory) {
		getLaboratories().remove(laboratory);
		laboratory.setMUser(null);

		return laboratory;
	}

	public Laboratory getLaboratory() {
		return this.laboratory;
	}

	public void setLaboratory(Laboratory laboratory) {
		this.laboratory = laboratory;
	}

}