package com.wellsfargo.training.loanEzz.model;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name="employee_card_details")
public class EmployeeCardDetails {
	

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public LoanCard getLoanCard() {
		return loanCard;
	}

	public void setLoanCard(LoanCard loanCard) {
		this.loanCard = loanCard;
	}

	public Date getCardIssueDate() {
		return cardIssueDate;
	}

	public void setCardIssueDate(Date cardIssueDate) {
		this.cardIssueDate = cardIssueDate;
	}

	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "ecard_id")
    private Long employeeCardId;

	@ManyToOne
	@JoinColumn(name="employee_id", referencedColumnName="employee_id")
	private Employee employee;
	
	@ManyToOne
	@JoinColumn(name="loan_id", referencedColumnName="loan_id")
	private LoanCard loanCard;
	
	Date cardIssueDate;
	
}
