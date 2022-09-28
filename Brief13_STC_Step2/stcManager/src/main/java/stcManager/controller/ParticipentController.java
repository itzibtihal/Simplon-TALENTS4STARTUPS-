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

import stcManager.entity.Participent;
import stcManager.service.ParticipentService;

@RestController
@EnableAutoConfiguration
@RequestMapping(value = "/Participent")
public class ParticipentController {
	
    @Autowired
    private ParticipentService participentService;
	
	@PostMapping("/STCManager/save")
	public Participent AddParticipent(@RequestBody Participent participent) {
		participentService.save(participent);
		return participent;
	}
    @DeleteMapping("/STCManager/delete/{roll}")
    public long deleteParticipent(@PathVariable long roll) {
    	participentService.delete(roll);
        return roll;
    }
	@PostMapping("/STCManager/update/{roll}")
	public Participent updateParticipent(@RequestBody Participent participent,@PathVariable long roll) {
		participentService.update(participent, roll);
		return participent;
	}
    @GetMapping("/STCManager/list")
    public List<Participent> List() {
    	return participentService.getAll();     
    }
    @GetMapping("/STCManager/list/{roll}")
    public Participent getParticipent(@PathVariable long roll) {
    	return participentService.getById(roll);  
    } 
}
