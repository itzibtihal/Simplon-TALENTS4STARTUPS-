package SoussHealthOnlineStore.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import SoussHealthOnlineStore.entity.Produit;
import SoussHealthOnlineStore.repository.ProduitRepository;
import SoussHealthOnlineStore.serviceInterface.InterfaceService;




@Service
@Transactional
public class ProduitService implements InterfaceService<Produit> {
	
	@Autowired   
	ProduitRepository ProduitRepository; 
	
	@Override
	public void save(Produit Produit) {
		ProduitRepository.save(Produit); 
	}
  
	@Override  
	public List<Produit> getAll() {
		return ProduitRepository.findAll();
	}

	@Override
	public Produit getById(long id) {
		return ProduitRepository.findById(id).get();  
		
	}

	@Override
	public void update(Produit produit, long id) {
		Produit Produit1 = ProduitRepository.findById(id).get();
		Produit1.setCompany(produit.getCompany());
		Produit1.setDateExpiration(produit.getDateExpiration());
		Produit1.setNomProduit(produit.getNomProduit());
		Produit1.setPrix(produit.getPrix());
		Produit1.setCategorie(produit.getCategorie());
		ProduitRepository.save(Produit1);
	}

	@Override
	public void delete(long id) {
		ProduitRepository.deleteById(id); 
		
	}
	
}
