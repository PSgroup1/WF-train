package com.wellsfargo.training.loanEzz.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wellsfargo.training.loanEzz.model.Item;
import com.wellsfargo.training.loanEzz.model.LoanCard;
import com.wellsfargo.training.loanEzz.repository.LoanCardRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class LoanCardService {
	@Autowired // dependency injection
    private LoanCardRepository lrepo;
	
	public LoanCard saveLoanCard(LoanCard p) {
        return lrepo.save(p);
    }
	 
	public List<LoanCard> getAllLoans() {
		return lrepo.findAll();
	}
	
	public List<LoanCard> getAllLoanCardsForEmployee (Long eid) {
		return lrepo.findAllLoanCardsForEmployee(eid);
	}
	public Optional<LoanCard> getLoanCardByType(String loanType) {
		return lrepo.findByLoanType(loanType);
	}
}
