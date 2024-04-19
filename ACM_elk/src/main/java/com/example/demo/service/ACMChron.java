package com.example.demo.service;


import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;



@Component
public class ACMChron {

	private final ACMLoanService loanService;
	
	private final AcmCollectionService CollectionService;
	private final ACMProductService ProductService;
	private final ACMCustomerService CustomerService;

	



	@Autowired
	public ACMChron(ACMLoanService loanService, AcmCollectionService collectionService,
			ACMProductService productService, ACMCustomerService customerService) {

		super();
		this.loanService = loanService;
		CollectionService = collectionService;
		ProductService = productService;
		CustomerService = customerService;
	}


//	@Scheduled(fixedRate = 1000) // Execute every 24 hours

	@Scheduled(fixedRate = 24 * 60 * 60 * 1000) // Execute every 24 hours
	public void startChronometer() {
	    System.out.println("Scheduled task started at: " + LocalDateTime.now());
			loanService.IndexTotalLoan();
			loanService.IndexTotalIssuedApplyAmount();
			loanService.IndexLoanDistributionById();
			loanService.IndexTotalActiveCustomers();
			loanService.IndexTotalCustomersPerMonth();
			loanService.IndexVoletLoanByStatut();
			loanService.IndexVoletLoanByBranche();
			loanService.IndexVoletLoanByPortfolio();
			loanService.IndexeExpiredLoans();
			loanService.IndexeLoansToBeDisbursed();
			loanService.IndexTotalIssuedApplyAmountPerMonth();
			CollectionService.indexVoletCollectionByBranch();
			CollectionService.indexVoletCollectionByCollectionType();
			CollectionService.indexVoletCollectionByCustomerName();
			CollectionService.indexVoletCollectionByOwnerName();
			CollectionService.indexVoletCollectionByStatut();
			ProductService.IndexDemandeParProduit();
			CustomerService.TotalCustomers();
}







	
}
