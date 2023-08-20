package com.wellsfargo.training.loanEzz.model;

import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name="loan_card_master")
public class LoanCard {

	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "loan_id")
    private Long loanId;
	
	private String loanType;
	
	private int durationInYears;
	
//	@OneToMany(cascade=CascadeType.ALL)
//	private List<EmployeeCardDetails> employeeCardDetails;

	public LoanCard(Long loanId, String loanType, int durationInYears) {
		this.loanId = loanId;
		this.loanType = loanType;
		this.durationInYears = durationInYears;
	}
	
	public LoanCard() {
		
	}

	public Long getLoanId() {
		return loanId;
	}

	public void setLoanId(Long loanId) {
		this.loanId = loanId;
	}

	public String getLoanType() {
		return loanType;
	}

	public void setLoanType(String loanType) {
		this.loanType = loanType;
	}

	public int getDurationInYears() {
		return durationInYears;
	}

	public void setDurationInYears(int durationInYears) {
		this.durationInYears = durationInYears;
	}
	
}
