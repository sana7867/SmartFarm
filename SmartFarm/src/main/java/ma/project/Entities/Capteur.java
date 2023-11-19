package ma.project.Entities;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToMany;

@Entity
public class Capteur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;

    @Lob // Cette annotation indique à Hibernate de traiter le champ comme un objet
         // binaire volumineux (BLOB)
    private byte[] photo;

    @ManyToMany
    @JoinTable(
        name = "boitier_capteur", // Assurez-vous que le nom de la table de jointure correspond à votre base de données
        joinColumns = @JoinColumn(name = "capteur_id"), // Correction ici, "capteur_id" est la colonne de jointure pour Capteur
        inverseJoinColumns = @JoinColumn(name = "boitier_id")
    )
    private List<Boitier> boitiers;

    public Capteur() {
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
