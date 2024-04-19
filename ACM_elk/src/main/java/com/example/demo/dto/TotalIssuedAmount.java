package com.example.demo.dto;

import java.math.BigDecimal;

import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TotalIssuedAmount {
	
	@Id
    private long idLoan;
	
	private String statutLibelle;
	
	private BigDecimal applyAmountTotal;

	public TotalIssuedAmount( BigDecimal applyAmountTotal) {

	
		this.applyAmountTotal = applyAmountTotal;
	}
	
	

}
