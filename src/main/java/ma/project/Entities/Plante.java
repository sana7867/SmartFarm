package ma.project.Entities;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Plante implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nom;
	private Long humiditeLimiteMin;
	private Long humiditeLimiteMax;
	
	
	public Plante() {
		super();
	}
	


	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public Long getHumiditeLimiteMin() {
		return humiditeLimiteMin;
	}
	public void setHumiditeLimiteMin(Long humiditeLimiteMin) {
		this.humiditeLimiteMin = humiditeLimiteMin;
	}
	public Long getHumiditeLimiteMax() {
		return humiditeLimiteMax;
	}
	public void setHumiditeLimiteMax(Long humiditeLimiteMax) {
		this.humiditeLimiteMax = humiditeLimiteMax;
	}
	
	

}
