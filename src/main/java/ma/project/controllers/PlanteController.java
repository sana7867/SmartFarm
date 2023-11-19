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

import ma.project.Entities.Plante;
import ma.project.services.PlanteService;

@RestController
@RequestMapping("/api/plantes")
public class PlanteController {
	@Autowired
	private PlanteService pltns;
	@GetMapping("/all")
	public ResponseEntity<Object> findAllPlantes() {
        List<Plante> plantes = pltns.findAll();
        if (plantes.isEmpty()) {
            return new ResponseEntity<>("Aucun pltnicle est trouvé", HttpStatus.NOT_FOUND);
        } else {
            return ResponseEntity.ok(plantes);
        }
    }

	@PostMapping("/save")
	public ResponseEntity<Plante> savePlantee(@RequestBody Plante plante){
		return new  ResponseEntity<Plante>(pltns.create(plante),HttpStatus.CREATED);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Object> findById(@PathVariable long id) {
		Plante bat = pltns.findById(id);
		if (bat == null) {
			return new ResponseEntity<Object>("Plante avec ID = " + id + " n'existe pas", HttpStatus.BAD_REQUEST);
		} else {
			return ResponseEntity.ok(bat);
		}
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Object> updatePlante(@PathVariable long id, @RequestBody Plante newPlante) {
		Plante oldPlante = pltns.findById(id);
		if (oldPlante == null) {
			return new ResponseEntity<Object>("Plante avec ID = " + id + " n'existe pas", HttpStatus.BAD_REQUEST);
		} else {
			newPlante.setId(id);
			return ResponseEntity.ok(pltns.update(newPlante));
		}
	}



	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deletePlante(@PathVariable long id) {
		Plante bat = pltns.findById(id);
		if (bat == null) {
			return new ResponseEntity<Object>("Plante avec ID = " + id + " n'existe pas", HttpStatus.BAD_REQUEST);
		} else {
			pltns.delete(bat);
			return ResponseEntity.ok("Plante est  supprimée");
		}
	}


}
