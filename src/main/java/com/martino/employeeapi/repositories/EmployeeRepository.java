package com.martino.employeeapi.repositories;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import com.martino.employeeapi.models.Employee;

public interface EmployeeRepository extends JpaRepositoryImplementation<Employee, Long> {

}
