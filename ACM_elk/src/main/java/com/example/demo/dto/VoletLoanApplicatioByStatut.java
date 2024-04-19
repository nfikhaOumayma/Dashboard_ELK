package com.example.demo.dto;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VoletLoanApplicatioByStatut {


	private long NBdemande;
	
	private String statutLibelle;

	public VoletLoanApplicatioByStatut(long nBdemande, String statutLibelle) {

		super();
		NBdemande = nBdemande;
		this.statutLibelle = statutLibelle;
	}






	

}
