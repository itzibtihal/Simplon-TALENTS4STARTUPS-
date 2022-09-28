package SoussHealthOnlineStore.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import SoussHealthOnlineStore.entity.Client;
import SoussHealthOnlineStore.repository.ClientRepository;
import SoussHealthOnlineStore.serviceInterface.InterfaceService;




@Service
@Transactional
public class ClientService implements InterfaceService<Client> {
	
	@Autowired   
	ClientRepository ClientRepository; 
	
	@Override
	public void save(Client Client) {
		ClientRepository.save(Client); 
	}
  
	@Override  
	public List<Client> getAll() { 
		return ClientRepository.findAll();
	}

	@Override
	public Client getById(long id) {
		return ClientRepository.findById(id).get();  
		
	}

	@Override
	public void update(Client client, long id) {
		Client client1 = ClientRepository.findById(id).get();
		  client1.setEmail(client.getEmail());
		  client1.setPassword(client.getPassword());
		  client1.setRoles(client.getRoles());
		  client1.setNom(client.getNom());
		  client1.setPrenom(client.getPrenom());
		  client1.setTelephone(client.getTelephone());
		  client1.setVille(client.getVille());
		  client1.setCin(client.getCin());
		  client1.setAdresse(client.getAdresse());
		  ClientRepository.save(client1);
	}

	@Override
	public void delete(long id) {
		ClientRepository.deleteById(id); 
		
	}
	
}
