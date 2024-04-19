package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomersName {
	
	private Long id;

	public CustomersName(Long id) {

		super();
		this.id = id;
	}

    
}
