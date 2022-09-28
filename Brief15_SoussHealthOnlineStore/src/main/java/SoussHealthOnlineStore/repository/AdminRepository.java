package SoussHealthOnlineStore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import SoussHealthOnlineStore.entity.Admin;





@Repository
public interface AdminRepository extends JpaRepository<Admin, Long>{
	
}
