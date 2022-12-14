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
import com.martino.employeeapi.interfaces.EmployeeService;
import com.martino.employeeapi.models.Employee;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/employees")
public class EmployeeController {
	Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private EmployeeService employeeService;

	@PostMapping("/save")
	public Employee addEmployee(@RequestBody Employee employee) {
		return this.employeeService.save(employee);
	}

	@GetMapping("/list")
	public ResponseEntity<List<Employee>> getAllEmployees() {
		this.logger.info(" >>>> Fetching employees.....");
		return ResponseEntity.ok(this.employeeService.findAll());
	}

	@GetMapping("/find/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable(value = "id") Long employeeId)
			throws ResourceNotFoundException {
		final Employee employee = this.employeeService.findOne(employeeId);

		return ResponseEntity.ok().body(employee);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable(value = "id") Long employeeId,
			@RequestBody Employee employeeDetails) throws ResourceNotFoundException {
		final Employee employee = this.employeeService.findOne(employeeId);

		employee.setName(employeeDetails.getName());
		employee.setEmail(employeeDetails.getEmail());
		employee.setPhone(employeeDetails.getPhone());
		employee.setDepartment(employeeDetails.getDepartment());

		final Employee updatedEmployee = this.employeeService.save(employee);
		return ResponseEntity.ok(updatedEmployee);
	}

	@DeleteMapping("/delete/{id}")
	public Map<String, Boolean> deleteEmployee(@PathVariable(value = "id") Long employeeId)
			throws ResourceNotFoundException {
		final Employee employee = this.employeeService.findOne(employeeId);

		this.employeeService.delete(employee);
		final Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}
