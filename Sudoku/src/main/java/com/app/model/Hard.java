package com.app.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Hard {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer hId;
	private String grid;
}
