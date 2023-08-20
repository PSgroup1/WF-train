package com.wellsfargo.training.loanEzz.controller;

import java.util.List;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wellsfargo.training.loanEzz.model.Employee;
import com.wellsfargo.training.loanEzz.model.EmployeeCardDetails;
import com.wellsfargo.training.loanEzz.model.EmployeeIssueDetails;
import com.wellsfargo.training.loanEzz.model.InputLoan;
import com.wellsfargo.training.loanEzz.model.LoanCard;
import com.wellsfargo.training.loanEzz.service.EmployeeCardService;
import com.wellsfargo.training.loanEzz.service.EmployeeIssueService;
import com.wellsfargo.training.loanEzz.service.EmployeeService;
import com.wellsfargo.training.loanEzz.service.LoanCardService;
import com.wellsfargo.training.loanEzz.exception.ResourceNotFoundException;

@RestController
@RequestMapping(value = "/api")
public class LoanCardController {
	
	private LoanCardService ls;
	private EmployeeService es;
	private EmployeeCardService ecs;
	private EmployeeIssueService eis;
	
	@PostMapping("/apply-loan")
	public EmployeeCardDetails applyLoan(@Validated @RequestBody InputLoan inputLoan) throws ResourceNotFoundException
    {
            
		LoanCard lc = ls.getLoanCardByType(inputLoan.getItemCategory()).orElseThrow(() ->
        new ResourceNotFoundException("Loan Card not found :: "));
		
		Employee e = es.findEmployeeById(inputLoan.getEmployeeId()).orElseThrow(() ->
        new ResourceNotFoundException("Employee not found :: "));
        
        EmployeeCardDetails c = ecs.saveLoanCard(inputLoan, lc, e);        
//        EmployeeIssueDetails ei = eis.saveLoanCard(e, , lc)
        return c;
    }
	
	@GetMapping("/loans")
	public List<LoanCard> getLoans() {
		return ls.getAllLoans();
	}
	
	@GetMapping("/loans/{eid}")
	public List<LoanCard> getLoansForEmployee(@PathVariable(value = "eid") Long eId) {
		return ls.getAllLoanCardsForEmployee(eId);
	}
}
