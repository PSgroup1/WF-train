package com.wellsfargo.training.loanEzz.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wellsfargo.training.loanEzz.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, String> {

	public Optional<Employee> findByEmail(String email);
	public Optional<Employee> findByEmployeeId(Long employeeId);
}
