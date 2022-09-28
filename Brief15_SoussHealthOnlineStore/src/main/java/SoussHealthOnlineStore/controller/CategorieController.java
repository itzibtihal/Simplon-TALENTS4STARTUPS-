package SoussHealthOnlineStore.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import SoussHealthOnlineStore.entity.Categorie;
import SoussHealthOnlineStore.service.CategorieService;



@RestController 
@EnableAutoConfiguration
@RequestMapping(value = "/categorie") 
public class CategorieController { 
	 
 
    @Autowired
    private CategorieService CategorieService;

    
    //register
    @PreAuthorize("hasRole('ADMIN')")
	@PostMapping("/registerNewCategorie") 
	public ResponseEntity<String> AddCategorie(@Valid @RequestBody Categorie Categorie) {
		CategorieService.save(Categorie);
		return ResponseEntity.ok("Categorie is valid");
	}


	//delete
	@PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/deleteNewCategorie/{roll}")
    public ResponseEntity<String> deleteCategorie(@Valid @PathVariable long roll) {
        CategorieService.delete(roll);
        return ResponseEntity.ok("Categorie is deleted");
    }
    
    //update
    @PreAuthorize("hasRole('ADMIN')")
	@PostMapping("/updateNewCategorie/{roll}")
	public ResponseEntity<String> updateCategorie(@RequestBody Categorie Categorie,@PathVariable long roll) {
		CategorieService.update(Categorie, roll);
		return ResponseEntity.ok("Categorie is updated");
	}

	//lists
	@PreAuthorize("hasRole('ADMIN') or hasRole('CLIENT')")
	@GetMapping("/listCategories")
    public List<Categorie> List1() {
		return CategorieService.getAll();
    }

	//list
	@PreAuthorize("hasRole('ADMIN') or hasRole('CLIENT')")
    @GetMapping("/listCategorie/{roll}")
    public ResponseEntity<Categorie> getCategorie(@PathVariable long roll) {
    	 Categorie Categorie = CategorieService.getById(roll);   
    	 return ResponseEntity.ok(Categorie);
    }


}
