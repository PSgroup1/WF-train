package com.wellsfargo.training.loanEzz.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wellsfargo.training.loanEzz.model.EmployeeIssueDetails;
import com.wellsfargo.training.loanEzz.model.LoanCard;

/**
 * 

 * JPA Repository is mainly used for managing the data in a Spring Boot Application. 
 * JpaRepository is particularly a JPA specific extension for Repository.
 * Jpa Repository contains the APIs for basic CRUD operations, the APIS for 
 * pagination, and the APIs for sorting.
 * This Layer interacts with Database
 */


public interface EmployeeIssueRepository extends JpaRepository<EmployeeIssueDetails, Long> {
    
    //Long is data type of id field of Product class
    /*
     * This interface has save(),findAll(),findById(),deleteById(),count()
       etc.. inbuilt methods of jpa repository for various database operations.
       This interface will be implemented by class automatically
    */  
    
}
