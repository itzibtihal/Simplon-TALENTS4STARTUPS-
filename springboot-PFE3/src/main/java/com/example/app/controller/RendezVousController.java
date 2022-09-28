package com.example.app.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import com.example.app.model.Client;
import com.example.app.model.Rendezvous;
import com.example.app.repository.RendezVousRepository;
import com.example.app.service.RendezvousService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@EnableAutoConfiguration
@RequestMapping(value = "/Billet") 
public class RendezVousController { 
	 
    @Autowired
    private RendezvousService RendezvousService ;
    
    
    //REGISTER
	@PostMapping("/registerNewBillet")
	public ResponseEntity<String> AddBillet(@Valid @RequestBody Rendezvous Rendezvous) {
		RendezvousService.save(Rendezvous);
		return ResponseEntity.ok("rendezvous is valid");
	}

	//DELETE
    @DeleteMapping("/deletet/{roll}")
    public ResponseEntity<String> deleteRendezvous(@PathVariable long roll) {
        RendezvousService.delete(roll);
        return ResponseEntity.ok("rendezvous is deleted");
    }

    //UPDATE
	@PostMapping("/updateRendezvous/{roll}")
	public ResponseEntity<String> updateRendezvous(@RequestBody Rendezvous Rendezvous,@PathVariable long roll) {
		RendezvousService.update(Rendezvous, roll);
		return ResponseEntity.ok("Rendezvous is updated");
	}

	//SHOW LIST
	@GetMapping("/listRendezvous")
    public List<Rendezvous> List1() {
		return RendezvousService.getAll();
    }

	//SHOW LISTS
    @GetMapping("/listResponsableBillet/{roll}")
    public ResponseEntity<Rendezvous> getRendezvous(@PathVariable long roll) {
    	Rendezvous Rendezvous = RendezvousService.getById(roll);   
    	 return ResponseEntity.ok(Rendezvous);
    }

  
}


