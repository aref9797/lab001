package Entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the equipment database table.
 * 
 */
@Entity
@NamedQueries({@NamedQuery(name="Equipment.findAll", query="SELECT l FROM Equipment l") ,
@NamedQuery(name = "Equipment.findbyname" , query = "SELECT l FROM Equipment l where(l.name =:name)")
})
public class Equipment implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	private String labname;

	private String name;

	private String page;

	private String photo;

	@Temporal(TemporalType.DATE)
	private Date pyear;

	//bi-directional many-to-one association to Laboratory
	@ManyToOne
	@JoinColumn(name="lab_id")
	private Laboratory laboratory;

	//bi-directional many-to-one association to MUser
	@ManyToOne
	@JoinColumn(name="muser_id")
	private MUser MUser;

	//bi-directional many-to-one association to ListExpEqu
	@OneToMany(mappedBy="equipment")
	private List<ListExpEqu> listExpEqus;

	public Equipment() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Date getPyear() {
		return this.pyear;
	}

	public void setPyear(Date pyear) {
		this.pyear = pyear;
	}

	public Laboratory getLaboratory() {
		return this.laboratory;
	}

	public void setLaboratory(Laboratory laboratory) {
		this.laboratory = laboratory;
	}

	public MUser getMUser() {
		return this.MUser;
	}

	public void setMUser(MUser MUser) {
		this.MUser = MUser;
	}

	public List<ListExpEqu> getListExpEqus() {
		return this.listExpEqus;
	}

	public void setListExpEqus(List<ListExpEqu> listExpEqus) {
		this.listExpEqus = listExpEqus;
	}

	public ListExpEqu addListExpEqus(ListExpEqu listExpEqus) {
		getListExpEqus().add(listExpEqus);
		listExpEqus.setEquipment(this);

		return listExpEqus;
	}

	public ListExpEqu removeListExpEqus(ListExpEqu listExpEqus) {
		getListExpEqus().remove(listExpEqus);
		listExpEqus.setEquipment(null);

		return listExpEqus;
	}

}