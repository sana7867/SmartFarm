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

import ma.projet.entities.Limite;
import ma.projet.services.LimiteService;

@RestController
@RequestMapping("/api/limites")
public class LimiteController {
	@Autowired
	private LimiteService lmts;
	@GetMapping("/all")
	public ResponseEntity<Object> findAllLimites() {
        List<Limite> lmtmins = lmts.findAll();
        if (lmtmins.isEmpty()) {
            return new ResponseEntity<>("Aucun lmticle est trouvé", HttpStatus.NOT_FOUND);
        } else {
            return ResponseEntity.ok(lmtmins);
        }
    }

	@PostMapping("/save")
	public ResponseEntity<Limite> saveLimitee(@RequestBody Limite lmtmin){
		return new  ResponseEntity<Limite>(lmts.create(lmtmin),HttpStatus.CREATED);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Object> findById(@PathVariable long id) {
		Limite bat = lmts.findById(id);
		if (bat == null) {
			return new ResponseEntity<Object>("Limite avec ID = " + id + " n'existe pas", HttpStatus.BAD_REQUEST);
		} else {
			return ResponseEntity.ok(bat);
		}
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Object> updateLimite(@PathVariable long id, @RequestBody Limite newLimite) {
		Limite oldLimite = lmts.findById(id);
		if (oldLimite == null) {
			return new ResponseEntity<Object>("Limite avec ID = " + id + " n'existe pas", HttpStatus.BAD_REQUEST);
		} else {
			newLimite.setId(id);
			return ResponseEntity.ok(lmts.update(newLimite));
		}
	}



	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteLimite(@PathVariable long id) {
		Limite bat = lmts.findById(id);
		if (bat == null) {
			return new ResponseEntity<Object>("Limite avec ID = " + id + " n'existe pas", HttpStatus.BAD_REQUEST);
		} else {
			lmts.delete(bat);
			return ResponseEntity.ok("Limite est  supprimée");
		}
	}


}
