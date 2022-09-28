package SoussHealthOnlineStore.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import SoussHealthOnlineStore.entity.ERole;
import SoussHealthOnlineStore.entity.Role;





@Repository
public interface RoleRepository extends JpaRepository<Role, Long>{
	Optional<Role> findByName(ERole name);
}
