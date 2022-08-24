package com.martino.employeeapi.interfaces;

import java.util.List;

import com.martino.employeeapi.models.Employee;

public interface EmployeeService {

	Employee save(Employee employee);

	List<Employee> findAll();

	void delete(Employee employee);

	Employee findOne(Long employeeId);

}
