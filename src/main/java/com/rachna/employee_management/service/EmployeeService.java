package com.rachna.employee_management.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.rachna.employee_management.entity.Employee;
import com.rachna.employee_management.repository.EmployeeRepository;
import com.rachna.employee_management.config.JwtUtil;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository repo;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private JwtUtil jwtUtil;

    
    public Employee saveEmployee(Employee emp) {

        
        if (emp.getRole() == null || emp.getRole().isEmpty()) {
            emp.setRole("USER");
        }

        
        emp.setPassword(passwordEncoder.encode(emp.getPassword()));

        return repo.save(emp);
    }

   
    public List<Employee> getAllEmployees() {
        return repo.findAll();
    }

   
    public Employee getEmployeeById(int id) {
        return repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found"));
    }

   
    public void deleteEmployee(int id) {
        repo.deleteById(id);
    }

   
    public Employee updateEmployee(Employee emp) {

       
        if (emp.getRole() == null || emp.getRole().isEmpty()) {
            emp.setRole("USER");
        }

        
        emp.setPassword(passwordEncoder.encode(emp.getPassword()));

        return repo.save(emp);
    }

   
    public String login(String email, String password) {

        Employee emp = repo.findByEmail(email);

        if (emp != null && passwordEncoder.matches(password, emp.getPassword())) {
            return jwtUtil.generateToken(emp.getEmail(),emp.getRole());
        } else {
            throw new RuntimeException("Invalid Email or Password");
        }
    }
}