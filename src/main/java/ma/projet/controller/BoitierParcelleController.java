package ma.projet.controller;

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

import ma.projet.entities.BoitierParcelle;
import ma.projet.services.BoitierParcelleService;

@RestController
@RequestMapping("/api/botPrcmins")
public class BoitierParcelleController {
	@Autowired
	private BoitierParcelleService botPrcs;
	@GetMapping("/all")
	public ResponseEntity<Object> findAllBoitierParcelles() {
        List<BoitierParcelle> botPrcmins = botPrcs.findAll();
        if (botPrcmins.isEmpty()) {
            return new ResponseEntity<>("Aucun botPrcicle est trouvé", HttpStatus.NOT_FOUND);
        } else {
            return ResponseEntity.ok(botPrcmins);
        }
    }

	@PostMapping("/save")
	public ResponseEntity<BoitierParcelle> saveBoitierParcellee(@RequestBody BoitierParcelle botPrcmin){
		return new  ResponseEntity<BoitierParcelle>(botPrcs.create(botPrcmin),HttpStatus.CREATED);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Object> findById(@PathVariable long id) {
		BoitierParcelle bat = botPrcs.findById(id);
		if (bat == null) {
			return new ResponseEntity<Object>("BoitierParcelle avec ID = " + id + " n'existe pas", HttpStatus.BAD_REQUEST);
		} else {
			return ResponseEntity.ok(bat);
		}
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Object> updateBoitierParcelle(@PathVariable long id, @RequestBody BoitierParcelle newBoitierParcelle) {
		BoitierParcelle oldBoitierParcelle = botPrcs.findById(id);
		if (oldBoitierParcelle == null) {
			return new ResponseEntity<Object>("BoitierParcelle avec ID = " + id + " n'existe pas", HttpStatus.BAD_REQUEST);
		} else {
			newBoitierParcelle.setId(id);
			return ResponseEntity.ok(botPrcs.update(newBoitierParcelle));
		}
	}



	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteBoitierParcelle(@PathVariable long id) {
		BoitierParcelle bat = botPrcs.findById(id);
		if (bat == null) {
			return new ResponseEntity<Object>("BoitierParcelle avec ID = " + id + " n'existe pas", HttpStatus.BAD_REQUEST);
		} else {
			botPrcs.delete(bat);
			return ResponseEntity.ok("BoitierParcelle est  supprimée");
		}
	}


}