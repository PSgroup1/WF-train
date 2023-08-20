package com.wellsfargo.training.loanEzz.model;

import java.util.Date;

import jakarta.persistence.*;


@Entity
@Table(name="employee_issue_details")
public class EmployeeIssueDetails {
	
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "issue_id")
    private Long IssueId;
	
	Date IssueDate;
	Date ReturnDate;
	
	@ManyToOne
	@JoinColumn(name="employee_id", referencedColumnName="employee_id")
	private Employee employee;
	
	@ManyToOne
	@JoinColumn(name="item_id", referencedColumnName="pid")
	private Item item;
	
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	public Item getItem() {
		return item;
	}
	public void setItem(Item item) {
		this.item = item;
	}
	public Long getIssueId() {
		return IssueId;
	}
	public void setIssueId(Long issueId) {
		IssueId = issueId;
	}
	public Date getIssueDate() {
		return IssueDate;
	}
	public void setIssueDate(Date issueDate) {
		IssueDate = issueDate;
	}
	public Date getReturnDate() {
		return ReturnDate;
	}
	public void setReturnDate(Date returnDate) {
		ReturnDate = returnDate;
	}
	
	
}


