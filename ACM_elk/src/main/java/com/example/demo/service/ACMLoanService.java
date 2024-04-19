package com.example.demo.service;


public interface ACMLoanService {

	public void IndexTotalLoan();

	public void IndexTotalIssuedApplyAmount();
	public void IndexTotalIssuedApplyAmountPerMonth();


	public void IndexLoanDistributionById();

	public void IndexTotalActiveCustomers();

	public void IndexTotalCustomersPerMonth();

	public void IndexVoletLoanByStatut();

	public void IndexVoletLoanByBranche();
	
	public void IndexVoletLoanByPortfolio();
	
	public void IndexeExpiredLoans();

	public void IndexeLoansToBeDisbursed();

	// public void IndexeDeletedLoans();

}
