package SoussHealthOnlineStore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import SoussHealthOnlineStore.entity.Produit;




@Repository
public interface ProduitRepository extends JpaRepository<Produit, Long>{

}
