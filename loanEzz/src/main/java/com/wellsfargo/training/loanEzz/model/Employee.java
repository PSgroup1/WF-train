package com.wellsfargo.training.loanEzz.model;

import java.nio.charset.StandardCharsets;
import java.sql.Date;
import java.util.Base64;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.*;

@Entity
@Table(name = "employee_master")
public class Employee {
		
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "employee_id")
	private Long employeeId;
	
	@Column(name = "employee_name")
	private String employeeName;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "password")
	private String password;
	
	private String designation;
	private String department;
	private char gender;
	
	@Column(name = "date_of_birth")
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date dob;
	
	@Column(name = "date_of_joining")
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date doj;
	
//	@OneToMany(cascade=CascadeType.ALL)
//	private List<EmployeeIssueDetails> employeeIssueDetails;
	
//	@OneToMany(cascade=CascadeType.ALL)
//	private List<EmployeeCardDetails> employeeCardDetails;

	public Employee() {
	}

	public Employee(Long employeeId, String employeeName, String email, String password, String designation, String department,
			char gender, Date dob, Date doj) {
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.email = email;
		
//		Base64.Encoder encoder = Base64.getEncoder();  
//        String normalString = password;
//        String encodedString = encoder.encodeToString(   // encrypt password in database field
//        normalString.getBytes(StandardCharsets.UTF_8) );
//        this.password = encodedString;
		
		this.password = password;
        
		this.designation = designation;
		this.department = department;
		this.gender = gender;
		this.dob = dob;
		this.doj = doj;
	}

	public Long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		Base64.Encoder encoder = Base64.getEncoder();  
        String normalString = password;
        String encodedString = encoder.encodeToString(   // encrypt password in database field
        normalString.getBytes(StandardCharsets.UTF_8) );
        this.password = encodedString;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public Date getDoj() {
		return doj;
	}

	public void setDoj(Date doj) {
		this.doj = doj;
	}
	
	
	
}
