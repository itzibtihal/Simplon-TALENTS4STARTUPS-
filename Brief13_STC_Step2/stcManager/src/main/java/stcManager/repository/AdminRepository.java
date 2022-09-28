package stcManager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import stcManager.entity.Admin;
@Repository
public interface AdminRepository extends JpaRepository<Admin, Long>{

}
