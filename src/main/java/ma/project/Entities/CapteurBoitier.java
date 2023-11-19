package ma.project.Entities;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class CapteurBoitier implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String branche;
	@ManyToOne
	private Capteur capteur;
	@ManyToOne
	private Boitier boitier;
	public CapteurBoitier() {
		super();
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getBranche() {
		return branche;
	}
	public void setBranche(String branche) {
		this.branche = branche;
	}
	public Capteur getCapteur() {
		return capteur;
	}
	public void setCapteur(Capteur capteur) {
		this.capteur = capteur;
	}
	public Boitier getBoitier() {
		return boitier;
	}
	public void setBoitier(Boitier boitier) {
		this.boitier = boitier;
	}
	

}
