package SoussHealthOnlineStore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import SoussHealthOnlineStore.entity.Categorie;




@Repository
public interface CategorieRepository extends JpaRepository<Categorie, Long>{

}
