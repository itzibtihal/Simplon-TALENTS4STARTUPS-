package stcManager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import stcManager.entity.Exercice;
@Repository
public interface ExerciceRepository extends JpaRepository<Exercice, Long>{

}
