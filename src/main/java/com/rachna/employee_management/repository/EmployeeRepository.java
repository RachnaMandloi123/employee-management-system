package com.rachna.employee_management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.rachna.employee_management.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	Employee findByEmail(String email);
}