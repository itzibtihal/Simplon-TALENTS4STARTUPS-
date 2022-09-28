package com.example.app.controller;

import java.util.HashMap;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import com.example.app.model.Admin;
import com.example.app.model.Client;
import com.example.app.repository.ClientRepository;
import com.example.app.service.AdminService;
import com.example.app.service.ClientService;

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
@RequestMapping(value = "/User") 
public class UserController { 
	 
    @Autowired
    private ClientService clientService;
    
    @Autowired
    private AdminService adminService;
    
    
    
    
    //REGISTER
	@PostMapping("/registerAdmin")
	public ResponseEntity<String> AddAdmin(@Valid @RequestBody Admin admin) {
		adminService.save(admin);
		return ResponseEntity.ok("Admin is valid");
	}
	@PostMapping("/registerClient")
	public ResponseEntity<String> AddResponsableBillets(@Valid @RequestBody Client client) {
		clientService.save(client);
		return ResponseEntity.ok("Client is valid");
	}
	
	
	
	
	//DELETE
    @DeleteMapping("/deleteAdmin/{roll}")
    public ResponseEntity<String> deleteAdmin(@PathVariable long roll) {
        adminService.delete(roll);
        return ResponseEntity.ok("Admin is deleted");
    }
    @DeleteMapping("/deleteClient/{roll}")
    public ResponseEntity<String> deleteClient(@PathVariable long roll) {
        clientService.delete(roll);
        return ResponseEntity.ok("ResponsableBillets is deleted");
    }
    
    
    //UPDATE
	@PostMapping("/updateAdmin/{roll}")
	public ResponseEntity<String> updateAdmin(@RequestBody Admin admin,@PathVariable long roll) {
		adminService.update(admin, roll);
		return ResponseEntity.ok("Admin is updated");
	}  
	@PostMapping("/updateClient/{roll}")
	public ResponseEntity<String> updateResponsableBillets(@RequestBody Client client,@PathVariable long roll) {
		clientService.update(client, roll);
		return ResponseEntity.ok("ResponsableBillets is updated");
	}
	
	
	
	
	//SHOW LIST
	@GetMapping("/listAdmins")
    public List<Admin> List() {
		return adminService.getAll();
    }
	@GetMapping("/listClient")
    public List<Client> List1() {
		return clientService.getAll();
    }
	
	
	
	
	//SHOW LISTS
    @GetMapping("/listAdmin/{roll}")
    public ResponseEntity<Admin> getAdmin(@PathVariable long roll) {
    	Admin admin = adminService.getById(roll);   
    	 return ResponseEntity.ok(admin);
    }
    @GetMapping("/listClient/{roll}")
    public ResponseEntity<Client> getClient(@PathVariable long roll) {
    	Client client = clientService.getById(roll);   
    	 return ResponseEntity.ok(client);
    }
    
    
    //////////////
    @GetMapping({"/forAdmin"})
    public String forAdmin() {
		return "This URL is only accessible to ADMIN";
    }

}

