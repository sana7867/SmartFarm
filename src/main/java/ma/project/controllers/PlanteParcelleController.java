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

import ma.project.Entities.PlanteParcelle;
import ma.project.services.PlanteParcelleService;

@RestController
@RequestMapping("/api/planteParcelles")
public class PlanteParcelleController {
	@Autowired
	private PlanteParcelleService plntPrcs;
	@GetMapping("/all")
	public ResponseEntity<Object> findAllPlanteParcelles() {
        List<PlanteParcelle> planteParcelles = plntPrcs.findAll();
        if (planteParcelles.isEmpty()) {
            return new ResponseEntity<>("Aucun plntPrcicle est trouvé", HttpStatus.NOT_FOUND);
        } else {
            return ResponseEntity.ok(planteParcelles);
        }
    }

	@PostMapping("/save")
	public ResponseEntity<PlanteParcelle> savePlanteParcellee(@RequestBody PlanteParcelle planteParcelle){
		return new  ResponseEntity<PlanteParcelle>(plntPrcs.create(planteParcelle),HttpStatus.CREATED);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Object> findById(@PathVariable long id) {
		PlanteParcelle bat = plntPrcs.findById(id);
		if (bat == null) {
			return new ResponseEntity<Object>("PlanteParcelle avec ID = " + id + " n'existe pas", HttpStatus.BAD_REQUEST);
		} else {
			return ResponseEntity.ok(bat);
		}
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Object> updatePlanteParcelle(@PathVariable long id, @RequestBody PlanteParcelle newPlanteParcelle) {
		PlanteParcelle oldPlanteParcelle = plntPrcs.findById(id);
		if (oldPlanteParcelle == null) {
			return new ResponseEntity<Object>("PlanteParcelle avec ID = " + id + " n'existe pas", HttpStatus.BAD_REQUEST);
		} else {
			newPlanteParcelle.setId(id);
			return ResponseEntity.ok(plntPrcs.update(newPlanteParcelle));
		}
	}



	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deletePlanteParcelle(@PathVariable long id) {
		PlanteParcelle bat = plntPrcs.findById(id);
		if (bat == null) {
			return new ResponseEntity<Object>("PlanteParcelle avec ID = " + id + " n'existe pas", HttpStatus.BAD_REQUEST);
		} else {
			plntPrcs.delete(bat);
			return ResponseEntity.ok("PlanteParcelle est  supprimée");
		}
	}


}