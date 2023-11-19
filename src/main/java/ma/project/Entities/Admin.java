package ma.project.Entities;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Admin extends User implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

    public Admin() {
        super();
    }

	public Long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
    
}
