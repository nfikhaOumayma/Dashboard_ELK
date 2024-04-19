package com.example.demo.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TotalCustomers {

	private Long customerId;

	public TotalCustomers(Long customerId) {

		super();
		this.customerId = customerId;
	}
	

}
