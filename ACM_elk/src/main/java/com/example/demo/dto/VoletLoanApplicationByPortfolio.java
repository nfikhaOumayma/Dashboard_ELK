package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VoletLoanApplicationByPortfolio {
	private long NBdemande;
	
	private Long portfolioId;

	public VoletLoanApplicationByPortfolio(long nBdemande, Long portfolioId) {

		super();
		NBdemande = nBdemande;
		this.portfolioId = portfolioId;
	}

}
