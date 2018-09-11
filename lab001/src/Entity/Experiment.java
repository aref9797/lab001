package Entity;

import java.io.Serializable;
import javax.persistence.*;


import java.util.List;


/**
 * The persistent class for the experiment database table.
 * 
 */

@Entity
@NamedQueries({@NamedQuery(name="Experiment.findAll", query="SELECT l FROM Experiment l") ,
@NamedQuery(name = "Experiment.findbyname" , query = "SELECT l FROM Experiment l where(l.name =:name)"),
})
public class Experiment implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	private String details;

	private String labholder;

	private String labname;

	private String name;

	private String page;

	private String photo;

	private Integer price;

	
	//bi-directional many-to-one association to ExpReservaion
	@OneToMany(mappedBy="experiment")
	private List<ExpReservaion> expReservaions;

	//bi-directional many-to-one association to Laboratory
	@ManyToOne
	@JoinColumn(name="lab_id")
	private Laboratory laboratory;

	//bi-directional many-to-one association to ListExpEqu
	@OneToMany(mappedBy="experiment")
	private List<ListExpEqu> listExpEqus;

	public Experiment() {
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

	public String getLabholder() {
		return this.labholder;
	}

	public void setLabholder(String labholder) {
		this.labholder = labholder;
	}

	public String getLabname() {
		return this.labname;
	}

	public void setLabname(String labname) {
		this.labname = labname;
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

	public Integer getPrice() {
		return this.price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public List<ExpReservaion> getExpReservaions() {
		return this.expReservaions;
	}

	public void setExpReservaions(List<ExpReservaion> expReservaions) {
		this.expReservaions = expReservaions;
	}

	public ExpReservaion addExpReservaion(ExpReservaion expReservaion) {
		getExpReservaions().add(expReservaion);
		expReservaion.setExperiment(this);

		return expReservaion;
	}

	public ExpReservaion removeExpReservaion(ExpReservaion expReservaion) {
		getExpReservaions().remove(expReservaion);
		expReservaion.setExperiment(null);

		return expReservaion;
	}

	public Laboratory getLaboratory() {
		return this.laboratory;
	}

	public void setLaboratory(Laboratory laboratory) {
		this.laboratory = laboratory;
	}

	public List<ListExpEqu> getListExpEqus() {
		return this.listExpEqus;
	}

	public void setListExpEqus(List<ListExpEqu> listExpEqus) {
		this.listExpEqus = listExpEqus;
	}

	public ListExpEqu addListExpEqus(ListExpEqu listExpEqus) {
		getListExpEqus().add(listExpEqus);
		listExpEqus.setExperiment(this);

		return listExpEqus;
	}

	public ListExpEqu removeListExpEqus(ListExpEqu listExpEqus) {
		getListExpEqus().remove(listExpEqus);
		listExpEqus.setExperiment(null);

		return listExpEqus;
	}

}