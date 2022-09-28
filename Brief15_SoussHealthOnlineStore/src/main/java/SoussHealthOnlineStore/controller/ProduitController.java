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

import SoussHealthOnlineStore.entity.Produit;
import SoussHealthOnlineStore.service.ProduitService;

@RestController
@EnableAutoConfiguration
@RequestMapping(value = "/produit")
public class ProduitController {

	@Autowired
	private ProduitService produitService;

	// register
	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping("/registerNewProduit")
	public ResponseEntity<String> AddProduit(@Valid @RequestBody Produit produit) {
		produitService.save(produit);
		return ResponseEntity.ok("produit is valid");
	}

	// delete
	@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping("/deleteNewProduit/{roll}")
	public ResponseEntity<String> deleteProduit(@PathVariable long roll) {
		produitService.delete(roll);
		return ResponseEntity.ok("Produit is deleted");
	}


	// update
	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping("/updateNewProduit/{roll}")
	public ResponseEntity<String> updateProduit(@RequestBody Produit produit, @PathVariable long roll) {
		produitService.update(produit, roll);
		return ResponseEntity.ok("Produit is updated");
	}


	// lists
	@PreAuthorize("hasRole('ADMIN') or hasRole('CLIENT')")
	@GetMapping("/listProduits")
	public List<Produit> List1() {
		return produitService.getAll();
	}


	// list
	@PreAuthorize("hasRole('ADMIN') or hasRole('CLIENT')")
	@GetMapping("/listProduit/{roll}")
	public ResponseEntity<Produit> getProduit(@PathVariable long roll) {
		Produit produit = produitService.getById(roll);
		return ResponseEntity.ok(produit);
	}


}
