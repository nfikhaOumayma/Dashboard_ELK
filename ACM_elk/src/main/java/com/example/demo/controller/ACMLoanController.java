package com.example.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.ACMLoanService;

import lombok.NoArgsConstructor;


@RestController
@RequestMapping("/apis")
@NoArgsConstructor
public class ACMLoanController {

	@Autowired
	private ACMLoanService s;
	

	@GetMapping("/totalLoans")
	public ResponseEntity<Void> getTotalLoans(){
		s.IndexTotalLoan();
		return ResponseEntity.ok().build();
	}
	
	@GetMapping("/totalIssuedApplyAmount")
	public ResponseEntity<Void> getTotalssuedApplyAmount(){
		s.IndexTotalIssuedApplyAmount();
		return ResponseEntity.ok().build();
	}
	
	@GetMapping("/LoanDistributionByProduct")
	public ResponseEntity<Void> getLoanDistributionByProduct(){
		s.IndexLoanDistributionById();
		return ResponseEntity.ok().build();
	}
	
	@GetMapping("/AllCustomers")
	public ResponseEntity<Void> getAllCustomers(){
		s.IndexTotalActiveCustomers();
		return ResponseEntity.ok().build();
	}
	

	@GetMapping("/AllCustomersPerMonth")
	public ResponseEntity<Void> getAllCustomersPerMonth(){
		s.IndexTotalCustomersPerMonth();
		return ResponseEntity.ok().build();
	}

	/*@GetMapping("/deletedLoans")
	public ResponseEntity<Void> getDeletedLoans(){
		s.IndexeDeletedLoans();
		return ResponseEntity.ok().build();
	}*/

	@GetMapping("/demandeParStatut")
	public ResponseEntity<Void> getdemandeParStatut(){
		s.IndexVoletLoanByStatut();
		return ResponseEntity.ok().build();
	}
	@GetMapping("/demandeParBranche")
	public ResponseEntity<Void> getdemandeParBranche(){
		s.IndexVoletLoanByBranche();
		return ResponseEntity.ok().build();
	}
	@GetMapping("/demandeParPortfolio")
	public ResponseEntity<Void> getdemandeParPortfolio(){
		s.IndexVoletLoanByPortfolio();
		return ResponseEntity.ok().build();
	}
	@GetMapping("/expiredLoans")
	public ResponseEntity<Void> getExpiredLoans(){
		s.IndexeExpiredLoans();
		return ResponseEntity.ok().build();
	}





	
	
}
