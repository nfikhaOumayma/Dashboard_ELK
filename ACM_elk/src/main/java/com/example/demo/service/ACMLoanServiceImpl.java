package com.example.demo.service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.elasticsearch.index.query.QueryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.client.elc.QueryBuilders;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.IndexOperations;
import org.springframework.data.elasticsearch.core.SearchHit;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.mapping.IndexCoordinates;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.stereotype.Service;

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
import com.example.demo.repo.ACMLoanElasticSearchRepository;

@Service
public class ACMLoanServiceImpl implements ACMLoanService {

	@Autowired
	private ACMLoanElasticSearchRepository rep;

	@Autowired
	private ElasticsearchRestTemplate elasticsearchRestTemplate;

	/* indexe 1 */

	private List<TotalLoans> findTotalLoans() {

		List<TotalLoans> result = rep.getTotalLoans();
		return result;
	}

	public void IndexTotalLoan() {

		// Retrieve existing data from Elasticsearch
		List<TotalLoans> existingData = findTotalLoans();

		// Retrieve new data
		List<TotalLoans> newData = findTotalLoans(); // Assuming you retrieve new data in the same
														// way

		// Check if the index exists
		IndexCoordinates indexCoordinates = IndexCoordinates.of("acm_total_loan");
		IndexOperations indexOperations = elasticsearchRestTemplate.indexOps(indexCoordinates);

		if (!indexOperations.exists()) {
			// Create the index if it doesn't exist
			indexOperations.create();
			System.out.println("Index created");
		}

		// Compare new data with existing data
		boolean dataChanged = false;
		for (TotalLoans newLoan : newData) {
			boolean exists = false;
			for (TotalLoans existingLoan : existingData) {
				if (existingLoan.equals(newLoan)) {
					exists = true;
					break;
				}
			}
			if (!exists) {
				dataChanged = true;
				break;
			}
		}

		// If there are changes, update the index
		if (dataChanged) {
			// Save existing data as historical data
			// Save to another index with a timestamp appended to its name
			String historicalIndexName = "acm_total_loan_" + LocalDate.now().toString();
			IndexCoordinates historicalIndexCoordinates = IndexCoordinates.of(historicalIndexName);
			elasticsearchRestTemplate.save(existingData, historicalIndexCoordinates);

			// Save new data
			elasticsearchRestTemplate.save(newData, indexCoordinates);

			// Optionally, you may delete and recreate the index to ensure consistency
			// indexOperations.delete();
			// indexOperations.create();

			System.out.println("Index updated with new data");
		}
	}

	/* indexe2 */

	private List<TotalIssuedAmount> findTotalIssuedApplyAmount() {

		List<TotalIssuedAmount> result = rep.getIssuedapplyAmountTotal();
		return result;
	}

	public void IndexTotalIssuedApplyAmount() {

		// Retrieve existing data from Elasticsearch
		List<TotalIssuedAmount> existingData = findTotalIssuedApplyAmount();

		// Retrieve new data
		List<TotalIssuedAmount> newData = findTotalIssuedApplyAmount(); // Assuming you retrieve new
																		// data in the same way

		// Check if the index exists
		IndexCoordinates indexCoordinates = IndexCoordinates.of("acm_total_issued_amount");
		IndexOperations indexOperations = elasticsearchRestTemplate.indexOps(indexCoordinates);

		if (!indexOperations.exists()) {
			// Create the index if it doesn't exist
			indexOperations.create();
			System.out.println("Index created");
		}

		// Compare new data with existing data
		boolean dataChanged = false;
		for (TotalIssuedAmount newLoan : newData) {
			boolean exists = false;
			for (TotalIssuedAmount existingLoan : existingData) {
				if (existingLoan.equals(newLoan)) {
					exists = true;
					break;
				}
			}
			if (!exists) {
				dataChanged = true;
				break;
			}
		}

		// If there are changes, update the index
		if (dataChanged) {
			// Save existing data as historical data
			// Save to another index with a timestamp appended to its name
			String historicalIndexName = "acm_total_issued_amount" + LocalDate.now().toString();
			IndexCoordinates historicalIndexCoordinates = IndexCoordinates.of(historicalIndexName);
			elasticsearchRestTemplate.save(existingData, historicalIndexCoordinates);

			// Save new data
			elasticsearchRestTemplate.save(newData, indexCoordinates);

			// Optionally, you may delete and recreate the index to ensure consistency
			// indexOperations.delete();
			// indexOperations.create();

			System.out.println("Index updated with new data");

		}
	}

	private List<LoanDistributionByProduct> findLoanDistributionByProduct() {

		List<LoanDistributionByProduct> result = rep.getLoanDistributionByProduct();
		return result;
	}

	@Override
	public void IndexLoanDistributionById() {

		// Retrieve existing data from Elasticsearch
		List<LoanDistributionByProduct> existingData = findLoanDistributionByProduct();

		// Retrieve new data
		List<LoanDistributionByProduct> newData = findLoanDistributionByProduct(); // Assuming you
																					// retrieve new
																					// data in the
																					// same way

		// Check if the index exists
		IndexCoordinates indexCoordinates = IndexCoordinates.of("loan_distribution_by_product");
		IndexOperations indexOperations = elasticsearchRestTemplate.indexOps(indexCoordinates);

		if (!indexOperations.exists()) {
			// Create the index if it doesn't exist
			indexOperations.create();
			System.out.println("Index created");
		}

		// Compare new data with existing data
		boolean dataChanged = false;
		for (LoanDistributionByProduct newLoan : newData) {
			boolean exists = false;
			for (LoanDistributionByProduct existingLoan : existingData) {
				if (existingLoan.equals(newLoan)) {
					exists = true;
					break;
				}
			}
			if (!exists) {
				dataChanged = true;
				break;
			}
		}

		// If there are changes, update the index
		if (dataChanged) {
			// Save existing data as historical data
			// Save to another index with a timestamp appended to its name
			String historicalIndexName =
					"loan_distribution_by_product" + LocalDate.now().toString();
			IndexCoordinates historicalIndexCoordinates = IndexCoordinates.of(historicalIndexName);
			elasticsearchRestTemplate.save(existingData, historicalIndexCoordinates);

			// Save new data
			elasticsearchRestTemplate.save(newData, indexCoordinates);

			// Optionally, you may delete and recreate the index to ensure consistency
			// indexOperations.delete();
			// indexOperations.create();

			System.out.println("Index updated with new data");
		}

	}

	private List<TotalCustomers> findAllCustomers() {

		List<TotalCustomers> result = rep.getTotalCustomers();
		return result;
	}

	@Override
	public void IndexTotalActiveCustomers() {

		// Retrieve existing data from Elasticsearch
		List<TotalCustomers> existingData = findAllCustomers();

		// Retrieve new data
		List<TotalCustomers> newData = findAllCustomers(); // Assuming you retrieve new data in the
															// same way

		// Check if the index exists
		IndexCoordinates indexCoordinates = IndexCoordinates.of("all_active_customers");
		IndexOperations indexOperations = elasticsearchRestTemplate.indexOps(indexCoordinates);

		if (!indexOperations.exists()) {
			// Create the index if it doesn't exist
			indexOperations.create();
			System.out.println("Index created");
		}

		// Compare new data with existing data
		boolean dataChanged = false;
		for (TotalCustomers newLoan : newData) {
			boolean exists = false;
			for (TotalCustomers existingLoan : existingData) {
				if (existingLoan.equals(newLoan)) {
					exists = true;
					break;
				}
			}
			if (!exists) {
				dataChanged = true;
				break;
			}
		}

		// If there are changes, update the index
		if (dataChanged) {
			// Save existing data as historical data
			// Save to another index with a timestamp appended to its name
			String historicalIndexName = "all_active_customers" + LocalDate.now().toString();
			IndexCoordinates historicalIndexCoordinates = IndexCoordinates.of(historicalIndexName);
			elasticsearchRestTemplate.save(existingData, historicalIndexCoordinates);

			// Save new data
			elasticsearchRestTemplate.save(newData, indexCoordinates);

			// Optionally, you may delete and recreate the index to ensure consistency
			// indexOperations.delete();
			// indexOperations.create();

			System.out.println("Index updated with new data");
		}
	}

	private List<TotalCustomersPerMonth> findAllCustomersPerMonth() {

		List<TotalCustomersPerMonth> result = rep.getTotalCustomersPerMonth();
		return result;
	}

	@Override
	public void IndexTotalCustomersPerMonth() {

		// Retrieve existing data from Elasticsearch
		List<TotalCustomersPerMonth> existingData = findAllCustomersPerMonth();

		// Retrieve new data
		List<TotalCustomersPerMonth> newData = findAllCustomersPerMonth(); // Assuming you retrieve
																			// new data in the same
																			// way

		// Check if the index exists
		IndexCoordinates indexCoordinates = IndexCoordinates.of("all_customers_per_month");
		IndexOperations indexOperations = elasticsearchRestTemplate.indexOps(indexCoordinates);

		if (!indexOperations.exists()) {
			// Create the index if it doesn't exist
			indexOperations.create();
			System.out.println("Index created");
		}

		// Compare new data with existing data
		boolean dataChanged = false;
		for (TotalCustomersPerMonth newLoan : newData) {
			boolean exists = false;
			for (TotalCustomersPerMonth existingLoan : existingData) {
				if (existingLoan.equals(newLoan)) {
					exists = true;
					break;
				}
			}
			if (!exists) {
				dataChanged = true;
				break;
			}
		}

		// If there are changes, update the index
		if (dataChanged) {
			// Save existing data as historical data
			// Save to another index with a timestamp appended to its name
			String historicalIndexName = "all_customers_per_month" + LocalDate.now().toString();
			IndexCoordinates historicalIndexCoordinates = IndexCoordinates.of(historicalIndexName);
			elasticsearchRestTemplate.save(existingData, historicalIndexCoordinates);

			// Save new data
			elasticsearchRestTemplate.save(newData, indexCoordinates);

			// Optionally, you may delete and recreate the index to ensure consistency
			// indexOperations.delete();
			// indexOperations.create();

			System.out.println("Index updated with new data");

		}
	}

	/*
	 * private long findCancellationPercentage() { long result =rep.getCancellationPercentage();
	 * return result; } public void IndexeDeletedLoans() { // Retrieve existing cancellation
	 * percentage from Elasticsearch long existingCancellationPercentage =
	 * findCancellationPercentage(); // Retrieve new cancellation percentage long
	 * newCancellationPercentage = findCancellationPercentage(); // Assuming you have a method to
	 * retrieve the new cancellation percentage // Check if the index exists IndexCoordinates
	 * indexCoordinates = IndexCoordinates.of("deleted_loans_index"); IndexOperations
	 * indexOperations = elasticsearchRestTemplate.indexOps(indexCoordinates); if
	 * (!indexOperations.exists()) { // Create the index if it doesn't exist
	 * indexOperations.create(); System.out.println("Index created"); } // If there are changes in
	 * the cancellation percentage, update the index if (existingCancellationPercentage !=
	 * newCancellationPercentage) { // Save existing cancellation percentage as historical data //
	 * Save to another index with a timestamp appended to its name String historicalIndexName =
	 * "deleted_loans_index" + LocalDate.now().toString(); IndexCoordinates
	 * historicalIndexCoordinates = IndexCoordinates.of(historicalIndexName);
	 * elasticsearchRestTemplate.save(existingCancellationPercentage, historicalIndexCoordinates);
	 * // Save new cancellation percentage elasticsearchRestTemplate.save(newCancellationPercentage,
	 * indexCoordinates); // Optionally, you may delete and recreate the index to ensure consistency
	 * // indexOperations.delete(); // indexOperations.create();
	 * System.out.println("Index updated with new cancellation percentage"); } }
	 */

	private List<VoletLoanApplicatioByStatut> findNbDemandeByStatut() {

		List<VoletLoanApplicatioByStatut> result = rep.getNombreDemandeByStatut();
		return result;
	}

	@Override
	public void IndexVoletLoanByStatut() {

		// Retrieve existing data from Elasticsearch
		List<VoletLoanApplicatioByStatut> existingData = findNbDemandeByStatut();

		// Retrieve new data
		List<VoletLoanApplicatioByStatut> newData = findNbDemandeByStatut(); // Assuming you
																				// retrieve new data
																				// in the same way

		// Check if the index exists
		IndexCoordinates indexCoordinates = IndexCoordinates.of("demande_par_statut");
		IndexOperations indexOperations = elasticsearchRestTemplate.indexOps(indexCoordinates);

		if (!indexOperations.exists()) {
			// Create the index if it doesn't exist
			indexOperations.create();
			System.out.println("Index created");
		}

		// Compare new data with existing data
		boolean dataChanged = false;
		for (VoletLoanApplicatioByStatut newLoan : newData) {
			boolean exists = false;
			for (VoletLoanApplicatioByStatut existingLoan : existingData) {
				if (existingLoan.equals(newLoan)) {
					exists = true;
					break;
				}
			}
			if (!exists) {
				dataChanged = true;
				break;
			}
		}

		// If there are changes, update the index
		if (dataChanged) {
			// Save existing data as historical data
			// Save to another index with a timestamp appended to its name
			String historicalIndexName = "demande_par_statut" + LocalDate.now().toString();
			IndexCoordinates historicalIndexCoordinates = IndexCoordinates.of(historicalIndexName);
			elasticsearchRestTemplate.save(existingData, historicalIndexCoordinates);

			// Save new data
			elasticsearchRestTemplate.save(newData, indexCoordinates);

			// Optionally, you may delete and recreate the index to ensure consistency
			// indexOperations.delete();
			// indexOperations.create();

			System.out.println("Index updated with new data");

		}
	}

	private List<VoletLoanApplicationByBranche> findRequestByBranche() {

		List<VoletLoanApplicationByBranche> result = rep.getNombreDemandeByBranche();
		return result;
	}

	@Override
	public void IndexVoletLoanByBranche() {

		// Retrieve existing data from Elasticsearch
		List<VoletLoanApplicationByBranche> existingData = findRequestByBranche();

		// Retrieve new data
		List<VoletLoanApplicationByBranche> newData = findRequestByBranche(); // Assuming you
																				// retrieve new data
																				// in the same way

		// Check if the index exists
		IndexCoordinates indexCoordinates = IndexCoordinates.of("demande_par_branche");
		IndexOperations indexOperations = elasticsearchRestTemplate.indexOps(indexCoordinates);

		if (!indexOperations.exists()) {
			// Create the index if it doesn't exist
			indexOperations.create();
			System.out.println("Index created");
		}

		// Compare new data with existing data
		boolean dataChanged = false;
		for (VoletLoanApplicationByBranche newLoan : newData) {
			boolean exists = false;
			for (VoletLoanApplicationByBranche existingLoan : existingData) {
				if (existingLoan.equals(newLoan)) {
					exists = true;
					break;
				}
			}
			if (!exists) {
				dataChanged = true;
				break;
			}
		}

		// If there are changes, update the index
		if (dataChanged) {
			// Save existing data as historical data
			// Save to another index with a timestamp appended to its name
			String historicalIndexName = "demande_par_branche" + LocalDate.now().toString();
			IndexCoordinates historicalIndexCoordinates = IndexCoordinates.of(historicalIndexName);
			elasticsearchRestTemplate.save(existingData, historicalIndexCoordinates);

			// Save new data
			elasticsearchRestTemplate.save(newData, indexCoordinates);

			// Optionally, you may delete and recreate the index to ensure consistency
			// indexOperations.delete();
			// indexOperations.create();

	        System.out.println("Méthode IndexVoletLoanByBranche exécutée");


		}
	}

	
	private List<VoletLoanApplicationByPortfolio> findRequestByPortfolio() {

		List<VoletLoanApplicationByPortfolio> result = rep.getNombreDemandeByPortfolio();
		return result;
	}

	
	@Override
	public void IndexVoletLoanByPortfolio() {

		// Retrieve existing data from Elasticsearch
		List<VoletLoanApplicationByPortfolio> existingData = findRequestByPortfolio();

		// Retrieve new data
		List<VoletLoanApplicationByPortfolio> newData = findRequestByPortfolio(); // Assuming you
																				// retrieve new data
																				// in the same way

		// Check if the index exists
		IndexCoordinates indexCoordinates = IndexCoordinates.of("demande_par_portfolio");
		IndexOperations indexOperations = elasticsearchRestTemplate.indexOps(indexCoordinates);

		if (!indexOperations.exists()) {
			// Create the index if it doesn't exist
			indexOperations.create();
			System.out.println("Index created");
		}

		// Compare new data with existing data
		boolean dataChanged = false;
		for (VoletLoanApplicationByPortfolio newLoan : newData) {
			boolean exists = false;
			for (VoletLoanApplicationByPortfolio existingLoan : existingData) {
				if (existingLoan.equals(newLoan)) {
					exists = true;
					break;
				}
			}
			if (!exists) {
				dataChanged = true;
				break;
			}
		}

		// If there are changes, update the index
		if (dataChanged) {
			// Save existing data as historical data
			// Save to another index with a timestamp appended to its name
			String historicalIndexName = "demande_par_portfolio" + LocalDate.now().toString();
			IndexCoordinates historicalIndexCoordinates = IndexCoordinates.of(historicalIndexName);
			elasticsearchRestTemplate.save(existingData, historicalIndexCoordinates);

			// Save new data
			elasticsearchRestTemplate.save(newData, indexCoordinates);

			// Optionally, you may delete and recreate the index to ensure consistency
			// indexOperations.delete();
			// indexOperations.create();

			System.out.println("Index updated with new data");

		}
	}

	private List<ExpiredLoans> findExpiredLoans() {

		List<ExpiredLoans> result = rep.getExpiredLoans();
		return result;
	}

	
	@Override
	public void IndexeExpiredLoans() {

		// Retrieve existing data from Elasticsearch
		List<ExpiredLoans> existingData = findExpiredLoans();

		// Retrieve new data
		List<ExpiredLoans> newData = findExpiredLoans(); // Assuming you
																				// retrieve new data
																				// in the same way

		// Check if the index exists
		IndexCoordinates indexCoordinates = IndexCoordinates.of("expired_loans");
		IndexOperations indexOperations = elasticsearchRestTemplate.indexOps(indexCoordinates);

		if (!indexOperations.exists()) {
			// Create the index if it doesn't exist
			indexOperations.create();
			System.out.println("Index created");
		}

		// Compare new data with existing data
		boolean dataChanged = false;
		for (ExpiredLoans newLoan : newData) {
			boolean exists = false;
			for (ExpiredLoans existingLoan : existingData) {
				if (existingLoan.equals(newLoan)) {
					exists = true;
					break;
				}
			}
			if (!exists) {
				dataChanged = true;
				break;
			}
		}

		// If there are changes, update the index
		if (dataChanged) {
			// Save existing data as historical data
			// Save to another index with a timestamp appended to its name
			String historicalIndexName = "expired_loans" + LocalDate.now().toString();
			IndexCoordinates historicalIndexCoordinates = IndexCoordinates.of(historicalIndexName);
			elasticsearchRestTemplate.save(existingData, historicalIndexCoordinates);

			// Save new data
			elasticsearchRestTemplate.save(newData, indexCoordinates);

			// Optionally, you may delete and recreate the index to ensure consistency
			// indexOperations.delete();
			// indexOperations.create();

			System.out.println("Index updated with new data");

		}
		
	}

	private List<ExpiredLoans> findLoansToBeDisbursed() {

		List<ExpiredLoans> result = rep.getLoansToBeDisbursed();
		return result;
	}

	@Override
	public void IndexeLoansToBeDisbursed() {


		// Retrieve existing data from Elasticsearch
		List<ExpiredLoans> existingData = findLoansToBeDisbursed();

		// Retrieve new data
		List<ExpiredLoans> newData = findLoansToBeDisbursed(); // Assuming you
																				// retrieve new data
																				// in the same way

		// Check if the index exists
		IndexCoordinates indexCoordinates = IndexCoordinates.of("loans_to_be_disbursed");
		IndexOperations indexOperations = elasticsearchRestTemplate.indexOps(indexCoordinates);

		if (!indexOperations.exists()) {
			// Create the index if it doesn't exist
			indexOperations.create();
			System.out.println("Index loans_to_be_disbursed created");
		}

		// Compare new data with existing data
		boolean dataChanged = false;
		for (ExpiredLoans newLoan : newData) {
			boolean exists = false;
			for (ExpiredLoans existingLoan : existingData) {
				if (existingLoan.equals(newLoan)) {
					exists = true;
					break;
				}
			}
			if (!exists) {
				dataChanged = true;
				break;
			}
		}

		// If there are changes, update the index
		if (dataChanged) {
			// Save existing data as historical data
			// Save to another index with a timestamp appended to its name
			String historicalIndexName = "loans_to_be_disbursed" + LocalDate.now().toString();
			IndexCoordinates historicalIndexCoordinates = IndexCoordinates.of(historicalIndexName);
			elasticsearchRestTemplate.save(existingData, historicalIndexCoordinates);

			// Save new data
			elasticsearchRestTemplate.save(newData, indexCoordinates);

			// Optionally, you may delete and recreate the index to ensure consistency
			// indexOperations.delete();
			// indexOperations.create();

			System.out.println("Index updated with new data");

		}		
	}
	private List<TotalOfIssuedLoansPerMonth> findTotalOfIssuedLoansPerMonth() {

		List<TotalOfIssuedLoansPerMonth> result = rep.getTotalOfIssuedLoansPerMonth();
		return result;
	}

	@Override
	public void IndexTotalIssuedApplyAmountPerMonth() {


		// Retrieve existing data from Elasticsearch
		List<TotalOfIssuedLoansPerMonth> existingData = findTotalOfIssuedLoansPerMonth();

		// Retrieve new data
		List<TotalOfIssuedLoansPerMonth> newData = findTotalOfIssuedLoansPerMonth(); // Assuming you
																				// retrieve new data
																				// in the same way

		// Check if the index exists
		IndexCoordinates indexCoordinates = IndexCoordinates.of("total_amount_isued_loans_permonth");
		IndexOperations indexOperations = elasticsearchRestTemplate.indexOps(indexCoordinates);

		if (!indexOperations.exists()) {
			// Create the index if it doesn't exist
			indexOperations.create();
			System.out.println("Index loans_to_be_disbursed created");
		}

		// Compare new data with existing data
		boolean dataChanged = false;
		for (TotalOfIssuedLoansPerMonth newLoan : newData) {
			boolean exists = false;
			for (TotalOfIssuedLoansPerMonth existingLoan : existingData) {
				if (existingLoan.equals(newLoan)) {
					exists = true;
					break;
				}
			}
			if (!exists) {
				dataChanged = true;
				break;
			}
		}

		// If there are changes, update the index
		if (dataChanged) {
			// Save existing data as historical data
			// Save to another index with a timestamp appended to its name
			String historicalIndexName = "total_amount_isued_loans_permonth" + LocalDate.now().toString();
			IndexCoordinates historicalIndexCoordinates = IndexCoordinates.of(historicalIndexName);
			elasticsearchRestTemplate.save(existingData, historicalIndexCoordinates);

			// Save new data
			elasticsearchRestTemplate.save(newData, indexCoordinates);

			// Optionally, you may delete and recreate the index to ensure consistency
			// indexOperations.delete();
			// indexOperations.create();

			System.out.println("Index updated with new data");

		}		
	}
}
