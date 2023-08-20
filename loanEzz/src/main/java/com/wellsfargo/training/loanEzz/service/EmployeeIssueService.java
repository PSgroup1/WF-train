package com.wellsfargo.training.loanEzz.service;

import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wellsfargo.training.loanEzz.model.Item;
import com.wellsfargo.training.loanEzz.model.LoanCard;
import com.wellsfargo.training.loanEzz.model.Employee;
import com.wellsfargo.training.loanEzz.model.EmployeeIssueDetails;
import com.wellsfargo.training.loanEzz.repository.EmployeeIssueRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class EmployeeIssueService {
	@Autowired // dependency injection
    private EmployeeIssueRepository eirepo;
	
	public EmployeeIssueDetails saveLoanCard(Employee e, Item i, LoanCard c) {
    
		EmployeeIssueDetails d = new EmployeeIssueDetails();
		d.setEmployee(e);
		d.setItem(i);
		Date today = new Date();
		d.setIssueDate(today);
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.YEAR, c.getDurationInYears());
		Date returnDate = cal.getTime();
		d.setReturnDate(returnDate);
		return eirepo.save(d);
	}
	
}
