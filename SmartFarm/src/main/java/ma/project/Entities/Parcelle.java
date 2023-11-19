package ma.project.Entities;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

@Entity
public class Parcelle {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nom;
	
	@Lob // Cette annotation indique à Hibernate de traiter le champ comme un objet binaire volumineux (BLOB)
	private byte[] photo;
	
	@ManyToOne
	private Ferme ferme;
	
	@ManyToMany
	private List<Plante> plantes;
	
	@ManyToMany(mappedBy = "parcelles")
	private List<Boitier> boitiers;

	public Parcelle() {
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

	public byte[] getPhoto() {
		return photo;
	}

	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}
	

}
