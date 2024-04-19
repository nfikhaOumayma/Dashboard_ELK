package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VoletLoanApplicationByBranche {
	
	private long NBdemande;
	
	private String branchName;

	public VoletLoanApplicationByBranche(long nBdemande, String branchName) {

		super();
		this.NBdemande = nBdemande;
		this.branchName = branchName;
	}
	
	
	
}
