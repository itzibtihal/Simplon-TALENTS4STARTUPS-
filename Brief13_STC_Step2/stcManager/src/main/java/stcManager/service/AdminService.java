package stcManager.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import stcManager.entity.Admin;
import stcManager.repository.AdminRepository;
import stcManager.serviceInterface.interfaceDao;
@Service
@Transactional
public class AdminService implements interfaceDao<Admin>{
	@Autowired   
	AdminRepository adminRepository; 
	
	@Override
	public void save(Admin admin) {
		adminRepository.save(admin); 
	}
 
	@Override  
	public List<Admin> getAll() {
		return adminRepository.findAll();
	}

	@Override
	public Admin getById(long id) {
		return adminRepository.findById(id).get();  
		
	}

	@Override
	public void update(Admin admin, long id) {
		adminRepository.save(admin);
	}

	@Override
	public void delete(long id) {
		adminRepository.deleteById(id); 
		
	}
}
