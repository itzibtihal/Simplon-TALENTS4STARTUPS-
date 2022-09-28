package SoussHealthOnlineStore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import SoussHealthOnlineStore.entity.Commande;




@Repository
public interface CommandeRepository extends JpaRepository<Commande, Long>{

}
