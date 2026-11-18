package com.example.demo.service;

import com.example.demo.entity.Employee;
import com.example.demo.repository.EmployeeRepository;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    // Add employee
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    // Get all employees
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    // Get employee by ID
    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id).orElse(null);
    }
    public List<Employee> searchByName(String name) {
    return employeeRepository.findByName(name);
}

    // Delete employee
    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }
    public Employee updateEmployee(Long id, Employee employee) {

    Employee existingEmployee = employeeRepository.findById(id)
            .orElse(null);

    if (existingEmployee == null) {
        return null;
    }

    existingEmployee.setName(employee.getName());
    existingEmployee.setEmail(employee.getEmail());
    existingEmployee.setSalary(employee.getSalary());

    return employeeRepository.save(existingEmployee);
}
}