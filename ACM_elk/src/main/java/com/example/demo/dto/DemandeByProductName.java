package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DemandeByProductName {
	
	private long nbDemande;
	private String description;
	public DemandeByProductName(long nbDemande, String description) {

		super();
		this.nbDemande = nbDemande;
		this.description = description;
	}


	
	
	
}
