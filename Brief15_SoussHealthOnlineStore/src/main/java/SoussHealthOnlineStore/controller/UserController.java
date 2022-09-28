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

import SoussHealthOnlineStore.entity.Admin;
import SoussHealthOnlineStore.entity.Client;
import SoussHealthOnlineStore.service.AdminService;
import SoussHealthOnlineStore.service.ClientService;



@RestController 
@EnableAutoConfiguration
@RequestMapping(value = "/user") 
public class UserController { 
	 
 
    @Autowired
    private AdminService adminService;
    @Autowired
    private ClientService clientService;
    
    //register
    @PreAuthorize("hasRole('ADMIN')")
	@PostMapping("/registerNewAdmin") 
	public ResponseEntity<String> AddAdmin(@Valid @RequestBody Admin admin) {
		adminService.save(admin);
		return ResponseEntity.ok("Admin is valid");
	}
    @PreAuthorize("hasRole('ADMIN')")
	@PostMapping("/registerNewClient")
	public ResponseEntity<String> AddClient(@Valid @RequestBody Client client) {
		clientService.save(client);
		return ResponseEntity.ok("Client is valid");
	}
	//delete
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/deleteNewAdmin/{roll}")
    public ResponseEntity<String> deleteAdmin(@Valid @PathVariable long roll) {
        adminService.delete(roll);
        return ResponseEntity.ok("Admin is deleted");
    }
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/deleteNewClient/{roll}")
    public ResponseEntity<String> deleteClient(@Valid @PathVariable long roll) {
        clientService.delete(roll);
        return ResponseEntity.ok("Client is deleted");
    }
    //update
    @PreAuthorize("hasRole('ADMIN')")
	@PostMapping("/updateNewAdmin/{roll}")
	public ResponseEntity<String> updateAdmin(@RequestBody Admin admin,@PathVariable long roll) {
		adminService.update(admin, roll);
		return ResponseEntity.ok("Admin is updated");
	}
    @PreAuthorize("hasRole('ADMIN')")
	@PostMapping("/updateNewClient/{roll}")
	public ResponseEntity<String> updateClient(@RequestBody Client client,@PathVariable long roll) {
		clientService.update(client, roll);
		return ResponseEntity.ok("Client is updated");
	}
	//lists
    @PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/listAdmins")
    public List<Admin> List1() {
		return adminService.getAll();
    }
    @PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/listClients")
    public List<Client> List2() {
		return clientService.getAll();
    }
	//list
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/listAdmin/{roll}")
    public ResponseEntity<Admin> getAdmin(@PathVariable long roll) {
    	 Admin admin = adminService.getById(roll);   
    	 return ResponseEntity.ok(admin);
    }
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/listClient/{roll}")
    public ResponseEntity<Client> getClient(@PathVariable long roll) {
    	 Client client = clientService.getById(roll);   
    	 return ResponseEntity.ok(client);
    }

}
