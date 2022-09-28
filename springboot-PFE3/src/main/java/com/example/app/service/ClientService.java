package com.example.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.app.model.Client;
import com.example.app.repository.ClientRepository;
import com.example.app.serviceInterface.InterfaceService;


import javax.transaction.Transactional;


import org.springframework.stereotype.Service;


@Service
@Transactional
public class ClientService implements InterfaceService<Client>{
	@Autowired   
	ClientRepository ClientRepository;  
	
	@Override
	public void save(Client client) {
		ClientRepository.save(client);
		// TODO Auto-generated method stub
	}

	
	
	@Override
	public List<Client> getAll() {
		// TODO Auto-generated method stub
		return ClientRepository.findAll();
	}

	@Override
	public Client getById(long id) {
		// TODO Auto-generated method stub
		return ClientRepository.findById(id).get();
	}

	@Override
	public void update(Client client, long id) {
		Client client1 = ClientRepository.findById(id).get();
		client1.setNom(client.getNom());
		client1.setPrenom(client.getPrenom());
		client1.setEmail(client.getEmail());
		client1.setTelephone(client.getTelephone());
		client1.setUsername(client.getUsername());
		client1.setPassword(client.getPassword());
		client1.setRoles(client.getRoles());
		ClientRepository.save(client1);
	}

	@Override
	public void delete(long id) {
		ClientRepository.deleteById(id);
		// TODO Auto-generated method stub
		
	}
}
