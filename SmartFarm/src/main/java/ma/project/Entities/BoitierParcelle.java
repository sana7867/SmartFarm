package ma.project.Entities;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
public class BoitierParcelle {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Temporal(TemporalType.DATE)
	private Date dateDebut;
	@Temporal(TemporalType.DATE)
	private Date dateFin;
	@ManyToOne
	private Boitier boiter;
	@ManyToOne
	private Parcelle parcelle;
	public BoitierParcelle() {
		super();
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Date getDateDebut() {
		return dateDebut;
	}
	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}
	public Date getDateFin() {
		return dateFin;
	}
	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}
	public Boitier getBoiter() {
		return boiter;
	}
	public void setBoiter(Boitier boiter) {
		this.boiter = boiter;
	}
	public Parcelle getParcelle() {
		return parcelle;
	}
	public void setParcelle(Parcelle parcelle) {
		this.parcelle = parcelle;
	}
	

}
