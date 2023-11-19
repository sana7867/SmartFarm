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

import ma.project.Entities.Agriculture;
import ma.project.services.AgricultureService;

@RestController
@RequestMapping("/api/agricultures")
public class AgricultureController {
	@Autowired
	private AgricultureService agrs;
	@GetMapping("/all")
	public ResponseEntity<Object> findAllAgricultures() {
        List<Agriculture> agricultures = agrs.findAll();
        if (agricultures.isEmpty()) {
            return new ResponseEntity<>("Aucun agricle est trouvé", HttpStatus.NOT_FOUND);
        } else {
            return ResponseEntity.ok(agricultures);
        }
    }

	@PostMapping("/save")
	public ResponseEntity<Agriculture> saveAgriculturee(@RequestBody Agriculture agriculture){
		return new  ResponseEntity<Agriculture>(agrs.create(agriculture),HttpStatus.CREATED);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Object> findById(@PathVariable long id) {
		Agriculture bat = agrs.findById(id);
		if (bat == null) {
			return new ResponseEntity<Object>("Agriculture avec ID = " + id + " n'existe pas", HttpStatus.BAD_REQUEST);
		} else {
			return ResponseEntity.ok(bat);
		}
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Object> updateAgriculture(@PathVariable long id, @RequestBody Agriculture newAgriculture) {
		Agriculture oldAgriculture = agrs.findById(id);
		if (oldAgriculture == null) {
			return new ResponseEntity<Object>("Agriculture avec ID = " + id + " n'existe pas", HttpStatus.BAD_REQUEST);
		} else {
			newAgriculture.setId(id);
			return ResponseEntity.ok(agrs.update(newAgriculture));
		}
	}



	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteAgriculture(@PathVariable long id) {
		Agriculture bat = agrs.findById(id);
		if (bat == null) {
			return new ResponseEntity<Object>("Agriculture avec ID = " + id + " n'existe pas", HttpStatus.BAD_REQUEST);
		} else {
			agrs.delete(bat);
			return ResponseEntity.ok("Agriculture est  supprimée");
		}
	}


}