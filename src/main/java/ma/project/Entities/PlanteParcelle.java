package ma.project.Entities;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class PlanteParcelle implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String arbr;
	@ManyToOne
	private Plante plante;
	@ManyToOne
	private Parcelle parcelle;
	public PlanteParcelle() {
		super();
	}
	
	public long getId() {
		return id;
	}
	
	public String getArbr() {
		return arbr;
	}

	public void setArbr(String arbr) {
		this.arbr = arbr;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getBr() {
		return arbr;
	}
	public void setBr(String br) {
		this.arbr = arbr;
	}
	public Plante getPlante() {
		return plante;
	}
	public void setPlante(Plante plante) {
		this.plante = plante;
	}
	public Parcelle getParcelle() {
		return parcelle;
	}
	public void setParcelle(Parcelle parcelle) {
		this.parcelle = parcelle;
	}
	
	
	

}
