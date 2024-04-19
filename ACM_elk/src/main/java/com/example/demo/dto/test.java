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
	    private long count;

	    public test(int month, String productDescription, long count) {
	        this.month = month;
	        this.productDescription = productDescription;
	        this.count = count;
	    }
}
