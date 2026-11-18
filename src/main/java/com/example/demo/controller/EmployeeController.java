package com.example.demo.controller;

import com.example.demo.entity.Employee;
import com.example.demo.service.EmployeeService;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

// 1. Add employee
@PostMapping
public Employee addEmployee(@RequestBody Employee employee) {
    return employeeService.saveEmployee(employee);
}

// 2. Get all employees
@GetMapping
public List<Employee> getAllEmployees() {
    return employeeService.getAllEmployees();
}

// 3. Search employee by name
@GetMapping("/search")
public List<Employee> searchByName(@RequestParam String name) {
    return employeeService.searchByName(name);
}

// 4. Get employee by ID
@GetMapping("/{id}")
public Employee getEmployeeById(@PathVariable Long id) {
    return employeeService.getEmployeeById(id);
}

}