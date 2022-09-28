package com.example.app.model;

import javax.persistence.*;

@Entity
@Table(name = "roles")

public class Role {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
	@Enumerated(EnumType.STRING)
    private ERole name;
	
	
	
	public Role() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	
	public ERole getName() {
		return name;
	}

	public void setName(ERole name) {
		this.name = name;
	}

}
