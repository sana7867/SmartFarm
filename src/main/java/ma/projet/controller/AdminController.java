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

import ma.projet.services.AdminService;
import ma.projet.entities.Admin;
@RestController
@RequestMapping("/api/admins")
public class AdminController {
	@Autowired
	private AdminService ads;
	@GetMapping("/all")
	public ResponseEntity<Object> findAllAdmins() {
        List<Admin> admins = ads.findAll();
        if (admins.isEmpty()) {
            return new ResponseEntity<>("Aucun adicle est trouvé", HttpStatus.NOT_FOUND);
        } else {
            return ResponseEntity.ok(admins);
        }
    }

	@PostMapping("/save")
	public ResponseEntity<Admin> saveAdmine(@RequestBody Admin admin){
		return new  ResponseEntity<Admin>(ads.create(admin),HttpStatus.CREATED);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Object> findById(@PathVariable long id) {
		Admin bat = ads.findById(id);
		if (bat == null) {
			return new ResponseEntity<Object>("Admin avec ID = " + id + " n'existe pas", HttpStatus.BAD_REQUEST);
		} else {
			return ResponseEntity.ok(bat);
		}
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Object> updateAdmin(@PathVariable long id, @RequestBody Admin newAdmin) {
		Admin oldAdmin = ads.findById(id);
		if (oldAdmin == null) {
			return new ResponseEntity<Object>("Admin avec ID = " + id + " n'existe pas", HttpStatus.BAD_REQUEST);
		} else {
			newAdmin.setId(id);
			return ResponseEntity.ok(ads.update(newAdmin));
		}
	}



	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteAdmin(@PathVariable long id) {
		Admin bat = ads.findById(id);
		if (bat == null) {
			return new ResponseEntity<Object>("Admin avec ID = " + id + " n'existe pas", HttpStatus.BAD_REQUEST);
		} else {
			ads.delete(bat);
			return ResponseEntity.ok("Admin est  supprimée");
		}
	}


}