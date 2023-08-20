package com.wellsfargo.training.loanEzz.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.wellsfargo.training.loanEzz.model.Item;
import com.wellsfargo.training.loanEzz.model.LoanCard;

/**
 * 

 * JPA Repository is mainly used for managing the data in a Spring Boot Application. 
 * JpaRepository is particularly a JPA specific extension for Repository.
 * Jpa Repository contains the APIs for basic CRUD operations, the APIS for 
 * pagination, and the APIs for sorting.
 * This Layer interacts with Database
 */


public interface ProductRepository extends JpaRepository<Item, Long> {
    
    //Long is data type of id field of Product class
    /*
     * This interface has save(),findAll(),findById(),deleteById(),count()
       etc.. inbuilt methods of jpa repository for various database operations.
       This interface will be implemented by class automatically
    */  
	
//	@Query("SELECT * FROM item WHERE ")
	@Query("SELECT * FROM item WHERE pid IN (SELECT item_id FROM employee_issue_details WHERE employee_id = :eid)")
	public List<Item> findAllItemsForEmployee(@Param("eid") Long eId);
}
