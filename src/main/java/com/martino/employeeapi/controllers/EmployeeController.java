package com.martino.employeeapi.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.martino.employeeapi.ResourceNotFoundException;
import com.martino.employeeapi.models.Employee;
import com.martino.employeeapi.repositories.EmployeeRepository;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class EmployeeController {
	Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private EmployeeRepository employeeRepository;

	@PostMapping("/employees")
	public Employee addEmployee(@RequestBody Employee employee) {
		return this.employeeRepository.save(employee);
	}

	@GetMapping("/employees")
	public ResponseEntity<List<Employee>> getAllEmployees() {
		this.logger.info(" >>>> Fetching employees.....");
		return ResponseEntity.ok(this.employeeRepository.findAll());
	}

	@GetMapping("/employees/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable(value = "id") Integer employeeId)
			throws ResourceNotFoundException {
		final Employee employee = this.employeeRepository.findById(employeeId);

		return ResponseEntity.ok().body(employee);
	}

	@PutMapping("/employees/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable(value = "id") Integer employeeId,
			@RequestBody Employee employeeDetails) throws ResourceNotFoundException {
		final Employee employee = this.employeeRepository.findById(employeeId);

		employee.setName(employeeDetails.getName());
		employee.setEmail(employeeDetails.getEmail());
		employee.setPhone(employeeDetails.getPhone());
		employee.setDepartment(employeeDetails.getDepartment());

		final Employee updatedEmployee = this.employeeRepository.save(employee);
		return ResponseEntity.ok(updatedEmployee);
	}

	@DeleteMapping("/employees/{id}")
	public Map<String, Boolean> deleteEmployee(@PathVariable(value = "id") Integer employeeId)
			throws ResourceNotFoundException {
		final Employee employee = this.employeeRepository.findById(employeeId);

		this.employeeRepository.delete(employee);
		final Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}
