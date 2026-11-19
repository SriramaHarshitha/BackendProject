
package com.example.demo.service;

import com.example.demo.dto.EmployeeDTO;
import com.example.demo.entity.Employee;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.EmployeeRepository;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    // Save employee using DTO
    public EmployeeDTO saveEmployeeDTO(EmployeeDTO dto) {

        Employee employee = new Employee();

        employee.setName(dto.getName());
        employee.setEmail(dto.getEmail());
        employee.setSalary(dto.getSalary());

        Employee savedEmployee = employeeRepository.save(employee);

        EmployeeDTO response = new EmployeeDTO();

        response.setId(savedEmployee.getId());
        response.setName(savedEmployee.getName());
        response.setEmail(savedEmployee.getEmail());
        response.setSalary(savedEmployee.getSalary());

        return response;
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
        return employeeRepository.findById(id)
            .orElseThrow(() ->
                new ResourceNotFoundException(
                    "Employee not found with ID: " + id
                )
            );
    }

    // Search employee by name
    public List<Employee> searchByName(String name) {
        return employeeRepository.findByName(name);
    }

    // Delete employee
    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }

    // Update employee
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
