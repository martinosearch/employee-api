package com.martino.employeeapi.repositories;

import org.springframework.stereotype.Repository;

import com.martino.employeeapi.models.Employee;

@Repository
public interface EmployeeRepository {

	Employee save(Employee employee);

	Object findAll();

	Object findById(Integer employeeId);
}
