package com.example.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.dto.CustomersName;
import com.example.demo.entity.AcmCustomer;

public interface ACMCustomerRep extends JpaRepository<AcmCustomer, Long> {

	@Query("SELECT  new com.example.demo.dto.CustomersName( c.id) " + "FROM  AcmCustomer c ")
	List<CustomersName> findAllCustomers();
}
