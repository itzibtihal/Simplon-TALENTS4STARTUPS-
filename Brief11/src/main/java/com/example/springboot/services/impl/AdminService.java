package com.example.springboot.services.impl;

import com.example.springboot.model.Admin;
import com.example.springboot.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

	@Service
	public class AdminService {

	    @Autowired
	    private AdminRepository adminRepo;

	    public Admin login(String username, String password) {
	        Admin admin = adminRepo.findByUsernameAndPassword(username, password);
	        return admin ;  
	    }

	} 
	
