package com.example.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.app.model.Admin;

@Repository

public interface AdminRepository extends JpaRepository<Admin, Long>{

}
