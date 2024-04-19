package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VoletCollectionByOwnerName {

	private long nbdossier;
	 
	private String ownerName;

	public VoletCollectionByOwnerName(long nbdossier, String ownerName) {

		super();
		this.nbdossier = nbdossier;
		this.ownerName = ownerName;
	}
	
	
}