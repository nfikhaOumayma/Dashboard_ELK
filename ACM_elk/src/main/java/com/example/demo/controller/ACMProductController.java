package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.ACMProductService;

import lombok.NoArgsConstructor;

@RestController
@RequestMapping("/apis")
@NoArgsConstructor
public class ACMProductController {
	@Autowired
	private ACMProductService s;
	

	@GetMapping("/demandeParProduit")
	public ResponseEntity<Void> getTotalLoans(){
		s.IndexDemandeParProduit();
		return ResponseEntity.ok().build();
	}
	
}
