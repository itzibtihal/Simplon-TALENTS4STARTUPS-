package stcManager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import stcManager.entity.Exercice;
import stcManager.repository.ExerciceRepository;
import stcManager.serviceInterface.interfaceDao;
@Service
@Transactional
public class ExerciceService implements interfaceDao<Exercice>{
	@Autowired  
	ExerciceRepository exerciceRepository; 
	
	@Override
	public void save(Exercice exercice) {
		exerciceRepository.save(exercice);
	}

	@Override
	public List<Exercice> getAll() {
		return exerciceRepository.findAll();
	}

	@Override
	public Exercice getById(long id) {
		return exerciceRepository.findById(id).get();  
		
	}

	@Override
	public void update(Exercice exercice, long id) {
		exerciceRepository.save(exercice);
	}

	@Override
	public void delete(long id) {
		exerciceRepository.deleteById(id); 
		
	}
}
