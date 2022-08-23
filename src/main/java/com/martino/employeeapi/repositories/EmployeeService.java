package com.martino.employeeapi.repositories;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

import com.martino.employeeapi.models.Employee;

@Component
public class EmployeeService implements EmployeeRepository {

	@Override
	public Employee save(Employee employee) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Employee> findAll() {
		return Arrays.asList(new Employee(1, "Martin", "martino", 97192084, "Lomé"),
				new Employee(2, "Gérom", "martino", 97192084, "Lomé"));
	}

	@Override
	public Employee findById(Integer employeeId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Employee employee) {
		// TODO Auto-generated method stub

	}
}
