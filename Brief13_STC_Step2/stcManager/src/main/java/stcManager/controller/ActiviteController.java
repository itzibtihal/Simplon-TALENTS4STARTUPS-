package stcManager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import stcManager.entity.Activite;
import stcManager.service.ActiviteService;

@RestController
@EnableAutoConfiguration
@RequestMapping(value = "/Activite")
public class ActiviteController {
	
    @Autowired
    private ActiviteService activiteService;
	
	@PostMapping("/save")
	public Activite AddActivite(@RequestBody Activite activite) {
		activiteService.save(activite);
		return activite;
	}
    @DeleteMapping("/delete/{roll}")
    public long deleteActivite(@PathVariable long roll) {
        activiteService.delete(roll);
        return roll;
    }
	@PostMapping("/edit/{roll}")
	public Activite updateActivite(@RequestBody Activite activite,@PathVariable long roll) {
		activiteService.update(activite, roll);
		return activite;
	}
    @GetMapping("/list")
    public List<Activite> List() {
    	return activiteService.getAll();
    }
    
    @GetMapping("/list/{roll}")
    public Activite getActivite(@PathVariable long roll) {
    	return activiteService.getById(roll);   
    } 
}
