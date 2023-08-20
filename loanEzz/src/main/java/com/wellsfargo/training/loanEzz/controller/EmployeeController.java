package com.wellsfargo.training.loanEzz.controller;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wellsfargo.training.loanEzz.exception.ResourceNotFoundException;
import com.wellsfargo.training.loanEzz.model.Employee;
import com.wellsfargo.training.loanEzz.service.EmployeeService;

@RestController
@RequestMapping(value = "/api")
public class EmployeeController {

	@Autowired
	private EmployeeService empservice;
	
	@PostMapping("/register")
	private ResponseEntity<String> createEmployee(@RequestBody @Validated Employee employee) {
		
		Employee registeredEmployee = empservice.registerEmployee(employee);
		if (registeredEmployee!= null) {
            return ResponseEntity.ok("Registration successful");
        } else {
            return ResponseEntity.badRequest().body("Registration failed");
        }
		
	}
	
	@PutMapping("/products/{id}")
	    public ResponseEntity<Employee> updateEMployee(@PathVariable(value = "id") Long eId, @Validated @RequestBody Employee e) 
	                                                throws ResourceNotFoundException {
	        Employee employee = empservice.findEmployeeById(eId).orElseThrow(() -> new ResourceNotFoundException("Employee Not Found"));
	        employee.setDepartment(e.getDepartment());
	        employee.setDesignation(e.getDesignation());
	        employee.setDob(e.getDob());
	        employee.setDoj(e.getDoj());
	        employee.setEmployeeName(e.getEmployeeName());
	        
	        return ResponseEntity.ok().body(empservice.registerEmployee(employee));
	        
	}
	
	@PostMapping("/login")
	private Boolean loginEmployee(@RequestBody @Validated Employee employee) throws ResourceNotFoundException {
		
		Boolean a = false;
        
		String email = employee.getEmail();
		String password = employee.getPassword();
				
		Employee e = empservice.loginEmployee(email).orElseThrow(() -> new ResourceNotFoundException("Employee not found"));
//		Base64.Decoder decoder = Base64.getDecoder();
//		String actualPassword = decoder.decode(e.getPassword()).toString();
//		System.out.println(actualPassword);
//		System.out.println(password);
		if(email.equals(e.getEmail()) && password.equals(e.getPassword())) {
			a= true;
		}
		return a;
	}
}
