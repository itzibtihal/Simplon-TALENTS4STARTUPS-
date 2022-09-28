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

import SoussHealthOnlineStore.entity.Commande;
import SoussHealthOnlineStore.service.CommandeService;



@RestController 
@EnableAutoConfiguration
@RequestMapping(value = "/commande") 
public class CommandeController { 
	 
 
    @Autowired
    private CommandeService CommandeService;

    
    //register
    @PreAuthorize("hasRole('CLIENT')")
	@PostMapping("/registerNewCommande") 
	public ResponseEntity<String> AddCommande(@Valid @RequestBody Commande Commande) {
		CommandeService.save(Commande);
		return ResponseEntity.ok("Commande is valid");
	}


	//delete
    @PreAuthorize("hasRole('CLIENT')")
    @DeleteMapping("/deleteNewCommande/{roll}")
    public ResponseEntity<String> deleteCommande(@PathVariable long roll) {
        CommandeService.delete(roll);
        return ResponseEntity.ok("Commande is deleted");
    }

    //update
    @PreAuthorize("hasRole('CLIENT')")
	@PostMapping("/updateNewCommande/{roll}")
	public ResponseEntity<String> updateCommande(@RequestBody Commande Commande,@PathVariable long roll) {
		CommandeService.update(Commande, roll);
		return ResponseEntity.ok("Commande is updated");
	}

	//lists
    @PreAuthorize("hasRole('CLIENT')")
	@GetMapping("/listCommandes")
    public List<Commande> List1() {
		return CommandeService.getAll();
    }

	//list
    @PreAuthorize("hasRole('CLIENT')")
    @GetMapping("/listCommande/{roll}")
    public ResponseEntity<Commande> getCommande(@PathVariable long roll) {
    	 Commande Commande = CommandeService.getById(roll);   
    	 return ResponseEntity.ok(Commande);
    }


}
