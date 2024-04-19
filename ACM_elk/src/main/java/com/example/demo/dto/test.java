package com.example.demo.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class test {
	  private int month;
	    private String productDescription;
	   

	    public test(int month, String productDescription) {
	        this.month = month;
	        this.productDescription = productDescription;
	    }
}
