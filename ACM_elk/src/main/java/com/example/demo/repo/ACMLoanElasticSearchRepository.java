package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.dto.CustomersName;
import com.example.demo.dto.ExpiredLoans;
import com.example.demo.dto.LoanDistributionByProduct;
import com.example.demo.dto.TotalCustomers;
import com.example.demo.dto.TotalCustomersPerMonth;
import com.example.demo.dto.TotalIssuedAmount;
import com.example.demo.dto.TotalLoans;
import com.example.demo.dto.TotalOfIssuedLoansPerMonth;
import com.example.demo.dto.VoletLoanApplicatioByStatut;
import com.example.demo.dto.VoletLoanApplicationByBranche;
import com.example.demo.dto.VoletLoanApplicationByPortfolio;
import com.example.demo.entity.Loan;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public interface ACMLoanElasticSearchRepository extends JpaRepository<Loan, Long> {

	@Query(value = "SELECT new com.example.demo.dto.TotalLoans(ACML.idLoan) " + "FROM Loan ACML  ")
	List<TotalLoans> getTotalLoans();

	@Query(value = "SELECT new com.example.demo.dto.TotalIssuedAmount(SUM(a.applyAmountTotal))"
			+ " FROM Loan a " + "WHERE (a.statutLibelle = 'Issued') ")
	List<TotalIssuedAmount> getIssuedapplyAmountTotal();

	@Query(value = "SELECT new com.example.demo.dto.TotalOfIssuedLoansPerMonth(MONTH(a.issueDate), SUM(a.applyAmountTotal))"
			+ " FROM Loan a WHERE (a.statutLibelle = 'Issued')" + " GROUP BY MONTH(a.issueDate)")
	List<TotalOfIssuedLoansPerMonth> getTotalOfIssuedLoansPerMonth();

	@Query(value = "SELECT new com.example.demo.dto.LoanDistributionByProduct(MONTH(l.applyDate), l.productDescription, COUNT(*)) "
			+ "FROM Loan l " + "GROUP BY MONTH(l.applyDate), l.productDescription")
	List<LoanDistributionByProduct> getLoanDistributionByProduct();


	@Query(value = "SELECT new com.example.demo.dto.TotalCustomers(COUNT(DISTINCT ACML.customerId)) "
			+ "FROM Loan ACML")
	List<TotalCustomers> getTotalCustomers();

	@Query(value = "SELECT  new com.example.demo.dto.TotalCustomersPerMonth(MONTH(ACML.applyDate), COUNT(DISTINCT ACML.customerId)) "
			+ "FROM Loan ACML  GROUP BY MONTH(ACML.applyDate)")
	List<TotalCustomersPerMonth> getTotalCustomersPerMonth();

	/*
	 * @Query(value =
	 * "SELECT new com.example.demo.dto.CanceledLoans((COUNT(CASE WHEN ACML.statutLibelle = 'Canceled' THEN 1 END) * 100) / COUNT(*) * 100)"
	 * + " FROM Loan ACML") long getCancellationPercentage();
	 */

	// nombre de demande dans le volet loan application

	// by statutLibelle
	@Query(value = "SELECT new com.example.demo.dto.VoletLoanApplicatioByStatut(count(*), a.statutLibelle) "
			+ "FROM Loan a" + " GROUP BY a.statutLibelle" + " ORDER BY a.statutLibelle DESC ")
	List<VoletLoanApplicatioByStatut> getNombreDemandeByStatut();

	// ByBranche
	@Query(value = "SELECT new com.example.demo.dto.VoletLoanApplicationByBranche(count(*), a.branchName) "
			+ "FROM Loan a" + " GROUP BY a.branchName" + " ORDER BY a.branchName DESC ")
	List<VoletLoanApplicationByBranche> getNombreDemandeByBranche();

	// ByPortfolio
	@Query(value = "SELECT new com.example.demo.dto.VoletLoanApplicationByPortfolio(count(*), a.portfolioId) "
			+ "FROM Loan a" + " GROUP BY a.portfolioId" + " ORDER BY a.portfolioId DESC ")
	List<VoletLoanApplicationByPortfolio> getNombreDemandeByPortfolio();

	// expiredLoans
	@Query(value = "SELECT new com.example.demo.dto.ExpiredLoans(count(*))"
			+ " FROM Loan a WHERE( a.statut=8) ")
	List<ExpiredLoans> getExpiredLoans();

	// LoansToBeDisbursed
	@Query(value = "SELECT new com.example.demo.dto.ExpiredLoans(count(*))"
			+ " FROM Loan a WHERE( a.readyForDisb=1) ")
	List<ExpiredLoans> getLoansToBeDisbursed();

	//test 2 de pull

}
