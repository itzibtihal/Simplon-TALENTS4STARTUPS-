package stcManager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import stcManager.entity.Activite;


@Repository
public interface ActiviteRepository extends JpaRepository<Activite, Long> {

}
