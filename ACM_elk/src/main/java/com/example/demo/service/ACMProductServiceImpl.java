package com.example.demo.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.IndexOperations;
import org.springframework.data.elasticsearch.core.mapping.IndexCoordinates;
import org.springframework.stereotype.Service;

import com.example.demo.dto.DemandeByProductName;

import com.example.demo.repo.ACMProductRep;

@Service
public class ACMProductServiceImpl implements ACMProductService {
	@Autowired
	private ACMProductRep rep;

	@Autowired
	private ElasticsearchRestTemplate elasticsearchRestTemplate;
	


	

	
	private List<DemandeByProductName> FindDemandeByProduit() {

		List<DemandeByProductName> result =rep.getDemandeByProductName();
		    return result;		
	}

	
	@Override
	public void IndexDemandeParProduit() {

		  // Retrieve existing data from Elasticsearch
	    List<DemandeByProductName> existingData = FindDemandeByProduit();
	    
	    // Retrieve new data
	    List<DemandeByProductName> newData = FindDemandeByProduit(); // Assuming you retrieve new data in the same way

	    // Check if the index exists
	    IndexCoordinates indexCoordinates = IndexCoordinates.of("demande_par_produit");
	    IndexOperations indexOperations = elasticsearchRestTemplate.indexOps(indexCoordinates);

	    if (!indexOperations.exists()) {
	        // Create the index if it doesn't exist
	        indexOperations.create();
	        System.out.println("Index created");
	    }

	    // Compare new data with existing data
	    boolean dataChanged = false;
	    for (DemandeByProductName newLoan : newData) {
	        boolean exists = false;
	        for (DemandeByProductName existingLoan : existingData) {
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
	        String historicalIndexName = "demande_par_produit" + LocalDate.now().toString();
	        IndexCoordinates historicalIndexCoordinates = IndexCoordinates.of(historicalIndexName);
	        elasticsearchRestTemplate.save(existingData, historicalIndexCoordinates);
	        
	        // Save new data
	        elasticsearchRestTemplate.save(newData, indexCoordinates);

	        // Optionally, you may delete and recreate the index to ensure consistency
	        // indexOperations.delete();
	        // indexOperations.create();
	        
	        System.out.println("Index demande_par_produit updated with new data");
	    
		
	}
	}
}
