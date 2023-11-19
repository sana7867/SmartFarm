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

import ma.project.Entities.Ferme;
import ma.project.services.FermeService;

@RestController
@RequestMapping("/api/fermes")
public class FermeController {
	@Autowired
	private FermeService ferms;
	@GetMapping("/all")
	public ResponseEntity<Object> findAllFermes() {
        List<Ferme> fermes = ferms.findAll();
        if (fermes.isEmpty()) {
            return new ResponseEntity<>("Aucun fermicle est trouvé", HttpStatus.NOT_FOUND);
        } else {
            return ResponseEntity.ok(fermes);
        }
    }

	@PostMapping("/save")
	public ResponseEntity<Ferme> saveFermee(@RequestBody Ferme ferme){
		return new  ResponseEntity<Ferme>(ferms.create(ferme),HttpStatus.CREATED);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Object> findById(@PathVariable long id) {
		Ferme bat = ferms.findById(id);
		if (bat == null) {
			return new ResponseEntity<Object>("Ferme avec ID = " + id + " n'existe pas", HttpStatus.BAD_REQUEST);
		} else {
			return ResponseEntity.ok(bat);
		}
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Object> updateFerme(@PathVariable long id, @RequestBody Ferme newFerme) {
		Ferme oldFerme = ferms.findById(id);
		if (oldFerme == null) {
			return new ResponseEntity<Object>("Ferme avec ID = " + id + " n'existe pas", HttpStatus.BAD_REQUEST);
		} else {
			newFerme.setId(id);
			return ResponseEntity.ok(ferms.update(newFerme));
		}
	}



	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteFerme(@PathVariable long id) {
		Ferme bat = ferms.findById(id);
		if (bat == null) {
			return new ResponseEntity<Object>("Ferme avec ID = " + id + " n'existe pas", HttpStatus.BAD_REQUEST);
		} else {
			ferms.delete(bat);
			return ResponseEntity.ok("Ferme est  supprimée");
		}
	}


}