package com.rachna.employee_management.controller;

import java.util.List;
import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.rachna.employee_management.entity.Employee;
import com.rachna.employee_management.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    
    @PostMapping("/save")
    public Employee saveEmployee( @Valid @RequestBody Employee emp) {
        return service.saveEmployee(emp);
    }

   
    @GetMapping("/all")
    public List<Employee> getAllEmployees() {
        return service.getAllEmployees();
    }

    
    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable int id) {
        return service.getEmployeeById(id);
    }

    
    @DeleteMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable int id) {
        service.deleteEmployee(id);
        return "Deleted Successfully";
    }s

    
    @PutMapping("/update")
    public Employee updateEmployee(@RequestBody Employee emp) {
        return service.updateEmployee(emp);
    }

    
    @PostMapping("/login")
    public String login(@RequestBody Employee emp) {
        return service.login(emp.getEmail(), emp.getPassword());
    }
}