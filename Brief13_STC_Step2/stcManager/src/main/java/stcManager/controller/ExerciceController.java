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

import stcManager.entity.Exercice;
import stcManager.service.ExerciceService;

@RestController
@EnableAutoConfiguration
@RequestMapping(value = "/Exercice")
public class ExerciceController {
	
    @Autowired
    private ExerciceService exerciceService;
	
	@PostMapping("/save")
	public Exercice AddExercice(@RequestBody Exercice exercice) {
		exerciceService.save(exercice);
		return exercice;
	}
    @DeleteMapping("/delete/{roll}")
    public long deleteExercice(@PathVariable long roll) {
    	exerciceService.delete(roll);
        return roll;
    }
	@PostMapping("/editExercice/{roll}")
	public Exercice updateExercice(@RequestBody Exercice exercice,@PathVariable long roll) {
		exerciceService.update(exercice, roll);
		return exercice;
	}
    @GetMapping("/list")
    public List<Exercice> List() {
    	return exerciceService.getAll();
    }

    @GetMapping("/list/{roll}")
    public Exercice getExercice(@PathVariable long roll) {
    	return exerciceService.getById(roll);     
    } 
}
