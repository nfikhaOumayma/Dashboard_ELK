package com.example.demo.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.IndexOperations;
import org.springframework.data.elasticsearch.core.mapping.IndexCoordinates;
import org.springframework.stereotype.Service;

import com.example.demo.dto.CustomersName;
import com.example.demo.repo.ACMCustomerRep;

@Service
public class ACMCustomerServiceImpl implements ACMCustomerService{

	@Autowired
	private ACMCustomerRep rep;

	@Autowired
	private ElasticsearchRestTemplate elasticsearchRestTemplate;
	
	private List<CustomersName> findAllCustomers() {

		List<CustomersName> result = rep.findAllCustomers();
		return result;
	}

	@Override
	public void TotalCustomers() {

		// Retrieve existing data from Elasticsearch
		List<CustomersName> existingData = findAllCustomers();

		// Retrieve new data
		List<CustomersName> newData = findAllCustomers(); // Assuming you retrieve new data in the
															// same way

		// Check if the index exists
		IndexCoordinates indexCoordinates = IndexCoordinates.of("all_customers");
		IndexOperations indexOperations = elasticsearchRestTemplate.indexOps(indexCoordinates);

		if (!indexOperations.exists()) {
			// Create the index if it doesn't exist
			indexOperations.create();
			System.out.println("Index created");
		}

		// Compare new data with existing data
		boolean dataChanged = false;
		for (CustomersName newLoan : newData) {
			boolean exists = false;
			for (CustomersName existingLoan : existingData) {
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
			String historicalIndexName = "all_customers" + LocalDate.now().toString();
			IndexCoordinates historicalIndexCoordinates = IndexCoordinates.of(historicalIndexName);
			elasticsearchRestTemplate.save(existingData, historicalIndexCoordinates);

			// Save new data
			elasticsearchRestTemplate.save(newData, indexCoordinates);

			// Optionally, you may delete and recreate the index to ensure consistency
			// indexOperations.delete();
			// indexOperations.create();

			System.out.println("Index AllCustomers updated with new data");
		}
	}
}
