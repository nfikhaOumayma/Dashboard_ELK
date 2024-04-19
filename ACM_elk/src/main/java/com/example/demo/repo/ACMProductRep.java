package com.example.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.dto.DemandeByProductName;
import com.example.demo.entity.Product;
import com.example.demo.entity.Loan; // Ajout de l'import de l'entité Loan

@Repository
public interface ACMProductRep extends JpaRepository<Product, Long> {

    @Query("SELECT NEW com.example.demo.dto.DemandeByProductName(count(*), p.description) " +
           "FROM Product p INNER JOIN Loan l ON p.id = l.productId "
           + "GROUP BY (p.description)"
          )
    List<DemandeByProductName> getDemandeByProductName();
}
