package ma.project.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ma.project.Entities.Parcelle;
import ma.project.services.ParcelleService;

@RestController
@RequestMapping("/api/parcelles")
public class ParcelleController {
	@Autowired
	private ParcelleService prcs;
	@GetMapping("/all")
	public ResponseEntity<Object> findAllParcelles() {
        List<Parcelle> parcelles = prcs.findAll();
        if (parcelles.isEmpty()) {
            return new ResponseEntity<>("Aucun prcicle est trouvé", HttpStatus.NOT_FOUND);
        } else {
            return ResponseEntity.ok(parcelles);
        }
    }

	@PostMapping("/save")
	public ResponseEntity<Parcelle> saveParcellee(@RequestBody Parcelle parcelle){
		return new  ResponseEntity<Parcelle>(prcs.create(parcelle),HttpStatus.CREATED);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Object> findById(@PathVariable long id) {
		Parcelle bat = prcs.findById(id);
		if (bat == null) {
			return new ResponseEntity<Object>("Parcelle avec ID = " + id + " n'existe pas", HttpStatus.BAD_REQUEST);
		} else {
			return ResponseEntity.ok(bat);
		}
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Object> updateParcelle(@PathVariable long id, @RequestBody Parcelle newParcelle) {
		Parcelle oldParcelle = prcs.findById(id);
		if (oldParcelle == null) {
			return new ResponseEntity<Object>("Parcelle avec ID = " + id + " n'existe pas", HttpStatus.BAD_REQUEST);
		} else {
			newParcelle.setId(id);
			return ResponseEntity.ok(prcs.update(newParcelle));
		}
	}



	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteParcelle(@PathVariable long id) {
		Parcelle bat = prcs.findById(id);
		if (bat == null) {
			return new ResponseEntity<Object>("Parcelle avec ID = " + id + " n'existe pas", HttpStatus.BAD_REQUEST);
		} else {
			prcs.delete(bat);
			return ResponseEntity.ok("Parcelle est  supprimée");
		}
	}


}
