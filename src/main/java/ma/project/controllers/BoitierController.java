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

import ma.project.Entities.Boitier;
import ma.project.services.BoitierService;

@RestController
@RequestMapping("/api/boitmins")
public class BoitierController {
	@Autowired
	private BoitierService boits;
	@GetMapping("/all")
	public ResponseEntity<Object> findAllBoitiers() {
        List<Boitier> boitmins = boits.findAll();
        if (boitmins.isEmpty()) {
            return new ResponseEntity<>("Aucun boiticle est trouvé", HttpStatus.NOT_FOUND);
        } else {
            return ResponseEntity.ok(boitmins);
        }
    }

	@PostMapping("/save")
	public ResponseEntity<Boitier> saveBoitiere(@RequestBody Boitier boitmin){
		return new  ResponseEntity<Boitier>(boits.create(boitmin),HttpStatus.CREATED);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Object> findById(@PathVariable long id) {
		Boitier bat = boits.findById(id);
		if (bat == null) {
			return new ResponseEntity<Object>("Boitier avec ID = " + id + " n'existe pas", HttpStatus.BAD_REQUEST);
		} else {
			return ResponseEntity.ok(bat);
		}
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Object> updateBoitier(@PathVariable long id, @RequestBody Boitier newBoitier) {
		Boitier oldBoitier = boits.findById(id);
		if (oldBoitier == null) {
			return new ResponseEntity<Object>("Boitier avec ID = " + id + " n'existe pas", HttpStatus.BAD_REQUEST);
		} else {
			newBoitier.setId(id);
			return ResponseEntity.ok(boits.update(newBoitier));
		}
	}



	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteBoitier(@PathVariable long id) {
		Boitier bat = boits.findById(id);
		if (bat == null) {
			return new ResponseEntity<Object>("Boitier avec ID = " + id + " n'existe pas", HttpStatus.BAD_REQUEST);
		} else {
			boits.delete(bat);
			return ResponseEntity.ok("Boitier est  supprimée");
		}
	}


}
