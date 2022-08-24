package com.martino.employeeapi.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.martino.employeeapi.interfaces.EmployeeService;
import com.martino.employeeapi.models.Employee;
import com.martino.employeeapi.repositories.EmployeeRepository;

@Component
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public Employee save(Employee employee) {
		return this.employeeRepository.save(employee);
	}

	@Override
	public List<Employee> findAll() {
		return this.employeeRepository.findAll();
	}

	@Override
	public Employee findOne(Long employeeId) {
		final Optional<Employee> result = this.employeeRepository.findById(employeeId);

		return result.isPresent() ? result.get() : null;
	}

	@Override
	public void delete(Employee employee) {
		this.employeeRepository.deleteById(employee.getId());

	}
}
