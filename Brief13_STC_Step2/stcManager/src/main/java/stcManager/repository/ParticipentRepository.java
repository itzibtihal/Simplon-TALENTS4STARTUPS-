package stcManager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import stcManager.entity.Participent;
@Repository
public interface ParticipentRepository extends JpaRepository<Participent, Long> {

}
