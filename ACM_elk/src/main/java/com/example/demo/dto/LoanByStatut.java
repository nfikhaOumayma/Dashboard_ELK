package com.example.demo.dto;

import javax.persistence.Id;

import org.springframework.data.elasticsearch.annotations.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoanByStatut {

	@Id
    private long idLoan;
	
	private String statutLibelle;


	public LoanByStatut(long idLoan, String statutLibelle) {
		this.idLoan = idLoan;
		this.statutLibelle=statutLibelle;
	}

    
}
