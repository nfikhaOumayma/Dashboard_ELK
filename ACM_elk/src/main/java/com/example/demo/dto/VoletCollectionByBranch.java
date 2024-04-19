package com.example.demo.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VoletCollectionByBranch {
	
	private long nbdossier;
	private String branchDescription;
	public VoletCollectionByBranch(long nbdossier, String branchDescription) {

		super();
		this.nbdossier = nbdossier;
		this.branchDescription = branchDescription;
	}
 


}
