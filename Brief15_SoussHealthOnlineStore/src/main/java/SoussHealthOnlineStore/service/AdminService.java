package SoussHealthOnlineStore.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import SoussHealthOnlineStore.entity.Admin;
import SoussHealthOnlineStore.repository.AdminRepository;
import SoussHealthOnlineStore.serviceInterface.InterfaceService;




@Service
@Transactional
public class AdminService implements InterfaceService<Admin> {
	
	@Autowired   
	AdminRepository AdminRepository; 
	
	@Override
	public void save(Admin Admin) {
		AdminRepository.save(Admin); 
	}
  
	@Override  
	public List<Admin> getAll() {
		return AdminRepository.findAll();
	}

	@Override
	public Admin getById(long id) {
		return AdminRepository.findById(id).get();  
		
	}

	@Override
    public void update(Admin admin, long id) {
		Admin admin1 = AdminRepository.findById(id).get();
		  admin1.setEmail(admin.getEmail());
		  admin1.setFullName(admin.getFullName());
		  admin1.setPassword(admin.getPassword());
		  admin1.setRoles(admin.getRoles());
		  AdminRepository.save(admin1);	
		  
    }
 
	@Override
	public void delete(long id) {
		AdminRepository.deleteById(id); 
		
	}
	
}
