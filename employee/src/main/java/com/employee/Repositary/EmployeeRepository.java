package com.employee.Repositary;

import org.springframework.data.jpa.repository.JpaRepository;

import com.employee.BO.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	Employee findByName(String name);
	
	Employee findByEmail(String name);
}
