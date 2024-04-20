package com.example.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.dto.CustomersName;
import com.example.demo.entity.AcmCustomer;

public interface ACMCustomerRep extends JpaRepository<AcmCustomer, Long> {

	@Query("SELECT  new com.example.demo.dto.CustomersName( c.id) " + "FROM  AcmCustomer c ")
	List<CustomersName> findAllCustomers();
	
	
	/*find all customers by gender
	
	SELECT count(*)  as  clientActif, [GENDER]
			  FROM [ACM].[dbo].[ACM_CUSTOMER] c
			  INNER JOIN [ACM].[dbo].[ACM_LOAN] l
			  ON c.ID_ACM_CUSTOMER =l.CUSTOMER_ID
			  group by gender*/


			
	/*find all active customers by gender
	  SELECT count(*) as clients, [GENDER]
			  FROM [ACM].[dbo].[ACM_CUSTOMER] 
			  group by gender*/
}
