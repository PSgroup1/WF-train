package com.wellsfargo.training.loanEzz.service;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wellsfargo.training.loanEzz.model.Employee;
import com.wellsfargo.training.loanEzz.repository.EmployeeRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class EmployeeService {
	
	private static final Class<? extends Optional> Employee = null;
	@Autowired
	private EmployeeRepository emprepo;
	
	public Employee registerEmployee(Employee employee) {
		return emprepo.save(employee);
	}
	
	public Optional<Employee> findEmployeeById(Long employeeId) {
		return emprepo.findByEmployeeId(employeeId);
	}
	
	public Optional<Employee> loginEmployee(String email) {
//		Base64.Encoder encoder = Base64.getEncoder();
//		String email = employee.getEmail();
//		String password = employee.getPassword();
//		String hashedPassword = encoder.encodeToString(   // encrypt password in database field
//				password.getBytes(StandardCharsets.UTF_8) );
		return emprepo.findByEmail(email);
//		if(e.getClass() == Employee) {
//			Employee regEmployee = e.get();
//			String regEmail = regEmployee.getEmail();
//			String regPassword = regEmployee.getPassword();
//			if(regEmail.equals(email) && regPassword.e)
//		}
	}

}
