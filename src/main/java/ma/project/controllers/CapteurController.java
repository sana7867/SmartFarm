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

import ma.project.Entities.Capteur;
import ma.project.services.CapteurService;

@RestController
@RequestMapping("/api/capteurs")
public class CapteurController {
	@Autowired
	private CapteurService capts;
	@GetMapping("/all")
	public ResponseEntity<Object> findAllCapteurs() {
        List<Capteur> capteurs = capts.findAll();
        if (capteurs.isEmpty()) {
            return new ResponseEntity<>("Aucun capticle est trouvé", HttpStatus.NOT_FOUND);
        } else {
            return ResponseEntity.ok(capteurs);
        }
    }

	@PostMapping("/save")
	public ResponseEntity<Capteur> saveCapteure(@RequestBody Capteur capteur){
		return new  ResponseEntity<Capteur>(capts.create(capteur),HttpStatus.CREATED);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Object> findById(@PathVariable long id) {
		Capteur bat = capts.findById(id);
		if (bat == null) {
			return new ResponseEntity<Object>("Capteur avec ID = " + id + " n'existe pas", HttpStatus.BAD_REQUEST);
		} else {
			return ResponseEntity.ok(bat);
		}
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Object> updateCapteur(@PathVariable long id, @RequestBody Capteur newCapteur) {
		Capteur oldCapteur = capts.findById(id);
		if (oldCapteur == null) {
			return new ResponseEntity<Object>("Capteur avec ID = " + id + " n'existe pas", HttpStatus.BAD_REQUEST);
		} else {
			newCapteur.setId(id);
			return ResponseEntity.ok(capts.update(newCapteur));
		}
	}



	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteCapteur(@PathVariable long id) {
		Capteur bat = capts.findById(id);
		if (bat == null) {
			return new ResponseEntity<Object>("Capteur avec ID = " + id + " n'existe pas", HttpStatus.BAD_REQUEST);
		} else {
			capts.delete(bat);
			return ResponseEntity.ok("Capteur est  supprimée");
		}
	}


}