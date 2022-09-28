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

import stcManager.entity.Responsable;
import stcManager.service.ResponsableService;

@RestController
@EnableAutoConfiguration
@RequestMapping(value = "/Responsable")
public class ResponsableController {
	
    @Autowired
    private ResponsableService responsableService;
	
    
	@PostMapping("/STCManager/save") 
	public Responsable AddResponsable(@RequestBody Responsable responsable) {
		responsableService.save(responsable);
		return responsable;
	} 
    @DeleteMapping("/STCManager/delete/{roll}")
    public long deleteResponsable(@PathVariable long roll) {
        responsableService.delete(roll);
		return roll;    
    }
	@PostMapping("/STCManager/update/{roll}")
	public Responsable updateResponsable(@RequestBody Responsable responsable,@PathVariable long roll) {
		responsableService.update(responsable, roll);
		return responsable;
	}
	@GetMapping("/STCManager/list")
    public List<Responsable> List() {
    	return responsableService.getAll();
    }
    @GetMapping("/STCManager/list/{roll}")
    public Responsable getResponsable(@PathVariable long roll) {
    	return responsableService.getById(roll);
    } 
}
