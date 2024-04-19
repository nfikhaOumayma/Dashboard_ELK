package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExpiredLoans {
	private long nbexpiredLoans;
	

	public ExpiredLoans(long nbexpiredLoans) {

		super();
		this.nbexpiredLoans = nbexpiredLoans;
	}



}
