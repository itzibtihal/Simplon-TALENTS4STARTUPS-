package com.example.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.springboot.model.Employee;
import com.example.springboot.repository.EmployeeRepository;

//@SpringBootApplication
//public class Brief11Application implements CommandLineRunner{
//    @Autowired
//	private EmployeeRepository rep;
//	
//	public static void main(String[] args) {
//		SpringApplication.run(Brief11Application.class, args);
//	}
//
//	@Override
//	public void run(String... args) throws Exception {
//		
//		//rep.save(new Employee(1,"ayoub@2000","ayoub","oudor","Admin"));
//		
//	}
 


@SpringBootApplication
public class Brief11Application {
 
	public static void main(String[] args) {
		SpringApplication.run(Brief11Application.class, args);
	}

}