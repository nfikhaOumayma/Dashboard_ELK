package com.example.demo.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TotalCustomersPerMonth {
	  private int month;
	    private long totalCustomers;

	    public TotalCustomersPerMonth(int month, long totalCustomers) {
	        this.month = month;
	        this.totalCustomers = totalCustomers;
	    }

}
