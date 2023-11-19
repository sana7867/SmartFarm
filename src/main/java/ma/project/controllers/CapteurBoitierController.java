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

import ma.project.Entities.CapteurBoitier;
import ma.project.services.CapteurBoitierService;
@RestController
@RequestMapping("/api/capteurBoitier")
public class CapteurBoitierController {
	@Autowired
	private CapteurBoitierService captBoits;
	@GetMapping("/all")
	public ResponseEntity<Object> findAllCapteurBoitiers() {
        List<CapteurBoitier> captBoitmins = captBoits.findAll();
        if (captBoitmins.isEmpty()) {
            return new ResponseEntity<>("Aucun captBoiticle est trouvé", HttpStatus.NOT_FOUND);
        } else {
            return ResponseEntity.ok(captBoitmins);
        }
    }

	@PostMapping("/save")
	public ResponseEntity<CapteurBoitier> saveCapteurBoitiere(@RequestBody CapteurBoitier captBoitmin){
		return new  ResponseEntity<CapteurBoitier>(captBoits.create(captBoitmin),HttpStatus.CREATED);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Object> findById(@PathVariable long id) {
		CapteurBoitier bat = captBoits.findById(id);
		if (bat == null) {
			return new ResponseEntity<Object>("CapteurBoitier avec ID = " + id + " n'existe pas", HttpStatus.BAD_REQUEST);
		} else {
			return ResponseEntity.ok(bat);
		}
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Object> updateCapteurBoitier(@PathVariable long id, @RequestBody CapteurBoitier newCapteurBoitier) {
		CapteurBoitier oldCapteurBoitier = captBoits.findById(id);
		if (oldCapteurBoitier == null) {
			return new ResponseEntity<Object>("CapteurBoitier avec ID = " + id + " n'existe pas", HttpStatus.BAD_REQUEST);
		} else {
			newCapteurBoitier.setId(id);
			return ResponseEntity.ok(captBoits.update(newCapteurBoitier));
		}
	}



	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteCapteurBoitier(@PathVariable long id) {
		CapteurBoitier bat = captBoits.findById(id);
		if (bat == null) {
			return new ResponseEntity<Object>("CapteurBoitier avec ID = " + id + " n'existe pas", HttpStatus.BAD_REQUEST);
		} else {
			captBoits.delete(bat);
			return ResponseEntity.ok("CapteurBoitier est  supprimée");
		}
	}


}
