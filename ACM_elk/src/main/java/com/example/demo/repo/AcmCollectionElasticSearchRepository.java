package com.example.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.dto.VoletCollectionByOwnerName;
import com.example.demo.dto.VoletCollectionByStatut;
import com.example.demo.dto.VoletCollectionByBranch;
import com.example.demo.dto.VoletCollectionByCollectionType;
import com.example.demo.dto.VoletCollectionByCustomerName;
import com.example.demo.entity.AcmCollection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.AcmCollection;

@Repository
public interface AcmCollectionElasticSearchRepository extends JpaRepository<AcmCollection, Long> {

	@Query(value = "SELECT new com.example.demo.dto.VoletCollectionByCollectionType(count(*), c.collectionType) "
			+ "FROM AcmCollection c" + " GROUP BY c.collectionType"
			+ " ORDER BY c.collectionType DESC ")
	List<VoletCollectionByCollectionType> getNombreDossierByCollectionType();

	@Query(value = "SELECT new com.example.demo.dto.VoletCollectionByOwnerName(count(*), c.ownerName) "
			+ "FROM AcmCollection c" + " GROUP BY c.ownerName" + " ORDER BY c.ownerName DESC ")

	List<VoletCollectionByOwnerName> getNombreDossierByOwnerName();

	@Query(value = "SELECT new com.example.demo.dto.VoletCollectionByCustomerName(count(*), c.customerName) "
			+ "FROM AcmCollection c" + " GROUP BY c.customerName"
			+ " ORDER BY c.customerName DESC ")
	List<VoletCollectionByCustomerName> getNombreDossierByCustomerName();

	@Query(value = "SELECT new com.example.demo.dto.VoletCollectionByStatut(count(*), c.statutLibelle) "
			+ "FROM AcmCollection c" + " GROUP BY c.statutLibelle"
			+ " ORDER BY c.statutLibelle DESC ")
	List<VoletCollectionByStatut> getNombreDossierByStatut();

	@Query(value = "SELECT new com.example.demo.dto.VoletCollectionByBranch(count(*), c.branchDescription) "
			+ "FROM AcmCollection c" + " GROUP BY c.branchDescription"
			+ " ORDER BY c.branchDescription DESC ")
	List<VoletCollectionByBranch> getNombreDossierByBranch();
}
