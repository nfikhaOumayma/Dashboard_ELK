package com.example.demo.dto;

import java.math.BigDecimal;
import java.util.Date;

public class TotalOfIssuedLoansPerMonth {
	
	private int issueDate;
    private BigDecimal totalAmount;

    public TotalOfIssuedLoansPerMonth(int issueDate, BigDecimal totalAmount) {
        this.issueDate = issueDate;
        this.totalAmount = totalAmount;
    }
	
}
