package com.example.demo.dto;

import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CanceledLoans {
	@Id
    private long idLoan; 
	
	 private long cancellationPercentage;

	public CanceledLoans(long idLoan, long cancellationPercentage) {

		super();
		this.idLoan = idLoan;
		this.cancellationPercentage = cancellationPercentage;
	}

}
