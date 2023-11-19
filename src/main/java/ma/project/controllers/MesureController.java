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

import ma.project.Entities.Mesure;
import ma.project.services.MesureService;

@RestController
@RequestMapping("/api/mesures")
public class MesureController {
	@Autowired
	private MesureService msrs;
	@GetMapping("/all")
	public ResponseEntity<Object> findAllMesures() {
        List<Mesure> mesures = msrs.findAll();
        if (mesures.isEmpty()) {
            return new ResponseEntity<>("Aucun msricle est trouvé", HttpStatus.NOT_FOUND);
        } else {
            return ResponseEntity.ok(mesures);
        }
    }

	@PostMapping("/save")
	public ResponseEntity<Mesure> saveMesuree(@RequestBody Mesure mesure){
		return new  ResponseEntity<Mesure>(msrs.create(mesure),HttpStatus.CREATED);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Object> findById(@PathVariable long id) {
		Mesure bat = msrs.findById(id);
		if (bat == null) {
			return new ResponseEntity<Object>("Mesure avec ID = " + id + " n'existe pas", HttpStatus.BAD_REQUEST);
		} else {
			return ResponseEntity.ok(bat);
		}
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Object> updateMesure(@PathVariable long id, @RequestBody Mesure newMesure) {
		Mesure oldMesure = msrs.findById(id);
		if (oldMesure == null) {
			return new ResponseEntity<Object>("Mesure avec ID = " + id + " n'existe pas", HttpStatus.BAD_REQUEST);
		} else {
			newMesure.setId(id);
			return ResponseEntity.ok(msrs.update(newMesure));
		}
	}



	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteMesure(@PathVariable long id) {
		Mesure bat = msrs.findById(id);
		if (bat == null) {
			return new ResponseEntity<Object>("Mesure avec ID = " + id + " n'existe pas", HttpStatus.BAD_REQUEST);
		} else {
			msrs.delete(bat);
			return ResponseEntity.ok("Mesure est  supprimée");
		}
	}


}