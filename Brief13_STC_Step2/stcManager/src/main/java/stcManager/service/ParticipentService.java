package stcManager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import stcManager.entity.Participent;
import stcManager.repository.ParticipentRepository;
import stcManager.serviceInterface.interfaceDao;
@Service
@Transactional
public class ParticipentService implements interfaceDao<Participent>{
	@Autowired  
	ParticipentRepository participentRepository; 
	
	@Override
	public void save(Participent participent) {
		participentRepository.save(participent);
	}

	@Override
	public List<Participent> getAll() {
		return participentRepository.findAll();
	}

	@Override
	public Participent getById(long id) {
		return participentRepository.findById(id).get();  
		
	}

	@Override
	public void update(Participent participent, long id) {
		participentRepository.save(participent);
	}

	@Override
	public void delete(long id) {
		participentRepository.deleteById(id); 
		
	}
}
