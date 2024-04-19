package com.example.demo.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VoletCollectionByCustomerName {
	private long nbdossier;
	 
	private String customerName;

	public VoletCollectionByCustomerName(long nbdossier, String customerName) {

		super();
		this.nbdossier = nbdossier;
		this.customerName = customerName;
	}
	
	

}
