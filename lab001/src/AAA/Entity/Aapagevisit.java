package AAA.Entity;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the aapagevisit database table.
 * 
 */
@Entity
@NamedQuery(name="Aapagevisit.findAll", query="SELECT a FROM Aapagevisit a")
public class Aapagevisit implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	private Timestamp indate;

	//bi-directional many-to-one association to Aapage
	@ManyToOne
	@JoinColumn(name="pagefkid")
	private Aapage aapage;

	//bi-directional many-to-one association to Aasession
	@ManyToOne
	@JoinColumn(name="sessionfkid")
	private Aasession aasession;

	public Aapagevisit() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Timestamp getIndate() {
		return this.indate;
	}

	public void setIndate(Timestamp indate) {
		this.indate = indate;
	}

	public Aapage getAapage() {
		return this.aapage;
	}

	public void setAapage(Aapage aapage) {
		this.aapage = aapage;
	}

	public Aasession getAasession() {
		return this.aasession;
	}

	public void setAasession(Aasession aasession) {
		this.aasession = aasession;
	}

}