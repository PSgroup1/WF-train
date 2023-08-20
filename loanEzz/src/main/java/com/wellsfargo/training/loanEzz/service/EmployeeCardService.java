package com.wellsfargo.training.loanEzz.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wellsfargo.training.loanEzz.model.Item;
import com.wellsfargo.training.loanEzz.model.LoanCard;
import com.wellsfargo.training.loanEzz.model.Employee;
import com.wellsfargo.training.loanEzz.model.EmployeeCardDetails;
import com.wellsfargo.training.loanEzz.model.InputLoan;
import com.wellsfargo.training.loanEzz.repository.EmployeeCardRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class EmployeeCardService {
	@Autowired // dependency injection
    private EmployeeCardRepository ecrepo;
	
	public EmployeeCardDetails saveLoanCard(InputLoan l, LoanCard c, Employee e) {
		EmployeeCardDetails card = new EmployeeCardDetails();
		card.setLoanCard(c);
		card.setEmployee(e);
		Date today = new Date();
		card.setCardIssueDate(today);
        return ecrepo.save(card);
    }
}
