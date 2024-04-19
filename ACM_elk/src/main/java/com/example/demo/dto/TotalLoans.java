package com.example.demo.dto;

import javax.persistence.Id;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
 public class TotalLoans {
	@Id
    private long idLoan;

	public TotalLoans(long idLoan) {
		this.idLoan = idLoan;
	}
	
}
