package com.example.app.service;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.app.model.*;
import com.example.app.repository.*;
import com.example.app.serviceInterface.*;

@Service
@Transactional
public class RendezvousService implements InterfaceService<Rendezvous> {
	@Autowired   
	 RendezVousRepository rendezVousRepository;  
	
	@Override
	public void save(Rendezvous Rendezvous) {
		rendezVousRepository.save(Rendezvous);
		// TODO Auto-generated method stub
	}

	
	
	@Override
	public List<Rendezvous> getAll() {
		// TODO Auto-generated method stub
		return rendezVousRepository.findAll();
	}

	@Override
	public Rendezvous getById(long id) {
		// TODO Auto-generated method stub
		return rendezVousRepository.findById(id).get();
	}

	@Override
	public void update(Rendezvous Rendezvous, long id) {
		Rendezvous  Rendezvous1 =  rendezVousRepository.findById(id).get();
		Rendezvous1.setDateRendezvous(Rendezvous.getDateRendezvous());
		Rendezvous1.setSubject(Rendezvous.getSubject());
		Rendezvous1.setMethoderendezvoust(Rendezvous.getMthoderendezvous());
		Rendezvous1.setFullname(Rendezvous.getFullname());
		Rendezvous1.setMail(Rendezvous.getMail());
		rendezVousRepository.save(Rendezvous1);
	}

	@Override
	public void delete(long id) {
		rendezVousRepository.deleteById(id);
		// TODO Auto-generated method stub
		
	}
	
	

}
