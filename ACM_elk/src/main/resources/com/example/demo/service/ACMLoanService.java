package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.IndexOperations;
import org.springframework.data.elasticsearch.core.mapping.IndexCoordinates;
import org.springframework.stereotype.Service;

import com.example.demo.dto.LoanByStatus;
import com.example.demo.repo.ACMLoanElasticSearchRepository;

@Service
public class ACMLoanService implements ACMLoanServiceImp {

	@Autowired
	private ACMLoanElasticSearchRepository ACMloanRep;

	private ElasticsearchRestTemplate elasticsearchRestTemplate;


	private List<LoanByStatus> findLoansByStatus() {

		List<LoanByStatus> result = ACMloanRep.getLoanByStatus();
		return result;
	}

	@Override
	public void IndexLoanByStatus() {

		List<LoanByStatus> result = findLoansByStatus();
		IndexCoordinates indexCoordinates = IndexCoordinates.of("byStatus");
		IndexOperations indexoperations = elasticsearchRestTemplate.indexOps(indexCoordinates);
		if (indexoperations.exists())
			indexoperations.delete();
		indexoperations.create();
		elasticsearchRestTemplate.save(result, indexCoordinates);
		System.out.println("done");
	}

}
