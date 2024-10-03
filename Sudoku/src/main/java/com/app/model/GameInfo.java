package com.app.model;

import java.util.Set;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class GameInfo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer gId;
	private String currentGameType;
	private Integer curInd = 0;
	private String grid;
	private String solution;  
	@ElementCollection
	private Set<String> emptyGridPositions;
	
	
	
	
}
