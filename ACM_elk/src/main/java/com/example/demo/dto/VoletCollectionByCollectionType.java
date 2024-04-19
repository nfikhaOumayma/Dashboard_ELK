package com.example.demo.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VoletCollectionByCollectionType {

	private long nbcollection;
	 
	private String collectionType;

	public VoletCollectionByCollectionType(long nbcollection, String collectionType) {

		super();
		this.nbcollection = nbcollection;
		this.collectionType = collectionType;
	}
	
	
	
}
