package stcManager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import stcManager.entity.Activite;
import stcManager.repository.ActiviteRepository;
import stcManager.serviceInterface.interfaceDao;
@Service
@Transactional
public class ActiviteService implements interfaceDao<Activite> {
	
	@Autowired  
	ActiviteRepository activiteRepository; 
	
	@Override
	public void save(Activite activite) {
		activiteRepository.save(activite);
	}

	@Override
	public List<Activite> getAll() {
		return activiteRepository.findAll();
	}

	@Override
	public Activite getById(long id) {
		return activiteRepository.findById(id).get();  
		
	}

	@Override
	public void update(Activite activite, long id) {
		activiteRepository.save(activite);
	}

	@Override
	public void delete(long id) {
		activiteRepository.deleteById(id); 
		
	}

}
