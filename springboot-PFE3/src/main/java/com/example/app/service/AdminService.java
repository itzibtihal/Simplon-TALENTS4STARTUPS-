package com.example.app.service;

import java.util.List;

import com.example.app.model.Admin;
import com.example.app.serviceInterface.InterfaceService;
import com.example.app.repository.AdminRepository;


import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
@Transactional

public class AdminService implements InterfaceService<Admin> {
     
	@Autowired   
	AdminRepository AdminRepository;  
	
	@Override
	public void save(Admin Admin) {
		AdminRepository.save(Admin);
		// TODO Auto-generated method stub
	}

	
	
	@Override
	public List<Admin> getAll() {
		// TODO Auto-generated method stub
		return AdminRepository.findAll();
	}

	@Override
	public Admin getById(long id) {
		// TODO Auto-generated method stub
		return AdminRepository.findById(id).get();
	}

	@Override
	public void update(Admin admin, long id) {
		Admin admin1 = AdminRepository.findById(id).get();
		admin1.setNom(admin.getNom());
		admin1.setPrenom(admin.getPrenom());
		admin1.setEmail(admin.getEmail());
		admin1.setTelephone(admin.getTelephone());
		admin1.setUsername(admin.getUsername());
		admin1.setPassword(admin.getPassword());
		admin1.setRoles(admin.getRoles());
		AdminRepository.save(admin1);
	}

	@Override
	public void delete(long id) {
		AdminRepository.deleteById(id);
		// TODO Auto-generated method stub
		
	}

}
