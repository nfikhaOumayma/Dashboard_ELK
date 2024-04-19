package com.example.demo.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.IndexOperations;
import org.springframework.data.elasticsearch.core.mapping.IndexCoordinates;
import org.springframework.stereotype.Service;

import com.example.demo.dto.VoletCollectionByOwnerName;
import com.example.demo.dto.VoletCollectionByStatut;
import com.example.demo.repo.AcmCollectionElasticSearchRepository;
import com.example.demo.dto.VoletCollectionByBranch;
import com.example.demo.dto.VoletCollectionByCollectionType;
import com.example.demo.dto.VoletCollectionByCustomerName;

@Service
public class AcmCollectionServiceImpl implements AcmCollectionService {
	
	@Autowired
	private AcmCollectionElasticSearchRepository rep;

	@Autowired
	private ElasticsearchRestTemplate elasticsearchRestTemplate;
	
	
	

	private List<VoletCollectionByCollectionType> findNombreDossierByCollectionType() {

		List<VoletCollectionByCollectionType> result = rep.getNombreDossierByCollectionType();
		return result;
	}

	public void indexVoletCollectionByCollectionType() {

		// Retrieve existing data from Elasticsearch
		List<VoletCollectionByCollectionType> existingData = findNombreDossierByCollectionType();

		// Retrieve new data
		List<VoletCollectionByCollectionType> newData = findNombreDossierByCollectionType(); // Assuming you retrieve new data in the same
														// way

		// Check if the index exists
		IndexCoordinates indexCoordinates = IndexCoordinates.of("acm_nombre_dossier_by_collection_type");
		IndexOperations indexOperations = elasticsearchRestTemplate.indexOps(indexCoordinates);

		if (!indexOperations.exists()) {
			// Create the index if it doesn't exist
			indexOperations.create();
			System.out.println("Index created");
		}

		// Compare new data with existing data
		boolean dataChanged = false;
		for (VoletCollectionByCollectionType newLoan : newData) {
			boolean exists = false;
			for (VoletCollectionByCollectionType existingLoan : existingData) {
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
			String historicalIndexName = "acm_nombre_dossier_by_collection_type" + LocalDate.now().toString();
			IndexCoordinates historicalIndexCoordinates = IndexCoordinates.of(historicalIndexName);
			elasticsearchRestTemplate.save(existingData, historicalIndexCoordinates);

			// Save new data
			elasticsearchRestTemplate.save(newData, indexCoordinates);

			// Optionally, you may delete and recreate the index to ensure consistency
			// indexOperations.delete();
			// indexOperations.create();

			System.out.println("Index updated with new data");
		
	}}
		
		
	

		private List<VoletCollectionByOwnerName> findNombreDossierByOwnerName() {

			List<VoletCollectionByOwnerName> result = rep.getNombreDossierByOwnerName();
			return result;
		}

		public void indexVoletCollectionByOwnerName() {
			// Retrieve existing data from Elasticsearch
			List<VoletCollectionByOwnerName> existingData = findNombreDossierByOwnerName();

			// Retrieve new data
			List<VoletCollectionByOwnerName> newData = findNombreDossierByOwnerName(); 
														
			// Check if the index exists
			IndexCoordinates indexCoordinates = IndexCoordinates.of("acm_nombre_dossier_by_owner_name");
			IndexOperations indexOperations = elasticsearchRestTemplate.indexOps(indexCoordinates);

			if (!indexOperations.exists()) {
				// Create the index if it doesn't exist
				indexOperations.create();
				System.out.println("Index created");
			}
			// Compare new data with existing data
			boolean dataChanged = false;
			for (VoletCollectionByOwnerName newLoan : newData) {
				boolean exists = false;
				for (VoletCollectionByOwnerName existingLoan : existingData) {
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
				String historicalIndexName = "acm_nombre_dossier_by_owner_name" + LocalDate.now().toString();
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

		
	
		private List<VoletCollectionByCustomerName> findNombreDossierByCustomerName() {

			List<VoletCollectionByCustomerName> result = rep.getNombreDossierByCustomerName();
			return result;
		}

		public void indexVoletCollectionByCustomerName() {
			// Retrieve existing data from Elasticsearch
			List<VoletCollectionByCustomerName> existingData = findNombreDossierByCustomerName();

			// Retrieve new data
			List<VoletCollectionByCustomerName> newData = findNombreDossierByCustomerName(); 
														
			// Check if the index exists
			IndexCoordinates indexCoordinates = IndexCoordinates.of("acm_nombre_dossier_by_customer_name");
			IndexOperations indexOperations = elasticsearchRestTemplate.indexOps(indexCoordinates);

			if (!indexOperations.exists()) {
				// Create the index if it doesn't exist
				indexOperations.create();
				System.out.println("Index created");
			}
			// Compare new data with existing data
			boolean dataChanged = false;
			for (VoletCollectionByCustomerName newLoan : newData) {
				boolean exists = false;
				for (VoletCollectionByCustomerName existingLoan : existingData) {
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
				String historicalIndexName = "acm_nombre_dossier_by_customer_name" + LocalDate.now().toString();
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
		
		
		private List<VoletCollectionByStatut> findNombreDossierByStatut() {

			List<VoletCollectionByStatut> result = rep.getNombreDossierByStatut();
			return result;
		}

		public void indexVoletCollectionByStatut() {
			// Retrieve existing data from Elasticsearch
			List<VoletCollectionByStatut> existingData = findNombreDossierByStatut();

			// Retrieve new data
			List<VoletCollectionByStatut> newData = findNombreDossierByStatut(); 
														
			// Check if the index exists
			IndexCoordinates indexCoordinates = IndexCoordinates.of("acm_nombre_dossier_by_statut");
			IndexOperations indexOperations = elasticsearchRestTemplate.indexOps(indexCoordinates);

			if (!indexOperations.exists()) {
				// Create the index if it doesn't exist
				indexOperations.create();
				System.out.println("Index created");
			}
			// Compare new data with existing data
			boolean dataChanged = false;
			for (VoletCollectionByStatut newLoan : newData) {
				boolean exists = false;
				for (VoletCollectionByStatut existingLoan : existingData) {
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
				String historicalIndexName = "acm_nombre_dossier_by_statut" + LocalDate.now().toString();
				IndexCoordinates historicalIndexCoordinates = IndexCoordinates.of(historicalIndexName);
				elasticsearchRestTemplate.save(existingData, historicalIndexCoordinates);

				// Save new data
				elasticsearchRestTemplate.save(newData, indexCoordinates);

				// Optionally, you may delete and recreate the index to ensure consistency
				// indexOperations.delete();
				// indexOperations.create();
				System.out.println("Index updated with new data");}
			}	

			
			private List<VoletCollectionByBranch> findNombreDossierByBranch() {

				List<VoletCollectionByBranch> result = rep.getNombreDossierByBranch();
				return result;
			}

			public void indexVoletCollectionByBranch() {
				// Retrieve existing data from Elasticsearch
				List<VoletCollectionByBranch> existingData = findNombreDossierByBranch();

				// Retrieve new data
				List<VoletCollectionByBranch> newData = findNombreDossierByBranch(); 
															
				// Check if the index exists
				IndexCoordinates indexCoordinates = IndexCoordinates.of("acm_nombre_dossier_by_branch");
				IndexOperations indexOperations = elasticsearchRestTemplate.indexOps(indexCoordinates);

				if (!indexOperations.exists()) {
					// Create the index if it doesn't exist
					indexOperations.create();
					System.out.println("Index created");
				}
				// Compare new data with existing data
				boolean dataChanged = false;
				for (VoletCollectionByBranch newLoan : newData) {
					boolean exists = false;
					for (VoletCollectionByBranch existingLoan : existingData) {
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
					String historicalIndexName = "acm_nombre_dossier_by_branch" + LocalDate.now().toString();
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