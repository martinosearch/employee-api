package com.martino.employeeapi.repositories;

import java.util.List;

import com.martino.employeeapi.models.Employee;

public interface EmployeeRepository {

	Employee save(Employee employee);

	List<Employee> findAll();

	Employee findById(Integer employeeId);

	void delete(Employee employee);
}
