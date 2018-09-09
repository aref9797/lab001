package Entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the laboratory database table.
 * 
 */
@Entity
@NamedQueries({@NamedQuery(name="Laboratory.findAll", query="SELECT l FROM Laboratory l") ,
@NamedQuery(name = "Laboratory.findbyname" , query = "SELECT l FROM Laboratory l where(l.name =:name)"),
})

public class Laboratory implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	private String detailes;

	private String name;

	private String page;

	private String photo;

	private String responsible;

	//bi-directional many-to-one association to Equipment
	@OneToMany(mappedBy="laboratory")
	private List<Equipment> equipments;

	//bi-directional many-to-one association to Experiment
	@OneToMany(mappedBy="laboratory")
	private List<Experiment> experiments;

	//bi-directional many-to-one association to MUser
	@ManyToOne
	@JoinColumn(name="responsible_id")
	private MUser MUser;

	//bi-directional many-to-one association to MUser
	@OneToMany(mappedBy="laboratory")
	private List<MUser> MUsers;

	public Laboratory() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDetailes() {
		return this.detailes;
	}

	public void setDetailes(String detailes) {
		this.detailes = detailes;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPage() {
		return this.page;
	}

	public void setPage(String page) {
		this.page = page;
	}

	public String getPhoto() {
		return this.photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getResponsible() {
		return this.responsible;
	}

	public void setResponsible(String responsible) {
		this.responsible = responsible;
	}

	public List<Equipment> getEquipments() {
		return this.equipments;
	}

	public void setEquipments(List<Equipment> equipments) {
		this.equipments = equipments;
	}

	public Equipment addEquipment(Equipment equipment) {
		getEquipments().add(equipment);
		equipment.setLaboratory(this);

		return equipment;
	}

	public Equipment removeEquipment(Equipment equipment) {
		getEquipments().remove(equipment);
		equipment.setLaboratory(null);

		return equipment;
	}

	public List<Experiment> getExperiments() {
		return this.experiments;
	}

	public void setExperiments(List<Experiment> experiments) {
		this.experiments = experiments;
	}

	public Experiment addExperiment(Experiment experiment) {
		getExperiments().add(experiment);
		experiment.setLaboratory(this);

		return experiment;
	}

	public Experiment removeExperiment(Experiment experiment) {
		getExperiments().remove(experiment);
		experiment.setLaboratory(null);

		return experiment;
	}

	public MUser getMUser() {
		return this.MUser;
	}

	public void setMUser(MUser MUser) {
		this.MUser = MUser;
	}

	public List<MUser> getMUsers() {
		return this.MUsers;
	}

	public void setMUsers(List<MUser> MUsers) {
		this.MUsers = MUsers;
	}

	public MUser addMUser(MUser MUser) {
		getMUsers().add(MUser);
		MUser.setLaboratory(this);

		return MUser;
	}

	public MUser removeMUser(MUser MUser) {
		getMUsers().remove(MUser);
		MUser.setLaboratory(null);

		return MUser;
	}

}