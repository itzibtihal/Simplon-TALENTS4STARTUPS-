package stcManager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import stcManager.entity.Responsable;
import stcManager.repository.ResponsableRepository;
import stcManager.serviceInterface.interfaceDao;

@Service
@Transactional
public class ResponsableService implements interfaceDao<Responsable>{
	@Autowired  
	ResponsableRepository responsableRepository; 
	
	@Override
	public void save(Responsable responsable) {
		responsableRepository.save(responsable);
	}

	@Override
	public List<Responsable> getAll() {
		return responsableRepository.findAll();
	}

	@Override
	public Responsable getById(long id) {
		return responsableRepository.findById(id).get();  
		
	}

	@Override
	public void update(Responsable responsable, long id) {
		responsableRepository.save(responsable);
	}

	@Override
	public void delete(long id) {
		responsableRepository.deleteById(id); 
		
	}
}
