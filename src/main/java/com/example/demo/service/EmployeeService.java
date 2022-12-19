package com.example.demo.service;

import com.example.demo.model.Department;
import com.example.demo.model.Employee;
import com.example.demo.repository.DepartmentRepository;
import com.example.demo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    public Optional<Employee> findById(int id) {
        return employeeRepository.findById(id);
    }

    public Employee saveEmployee(Employee employee) {
        if(employee.getDepartment() != null && departmentRepository.findById(employee.getDepartment()).isPresent()){
            return employeeRepository.save(employee);
        }
        Department department = new Department();
        department.setName(employee.getDepartment());
        departmentRepository.save(department);

        return employeeRepository.save(employee);
    }

    public Employee updateEmployee(int id, Employee employee) {
        Employee updatedEmployee = employeeRepository.findById(id).orElse(null);
        updatedEmployee.setName(employee.getName());
        updatedEmployee.setEmail(employee.getEmail());
        updatedEmployee.setCountry(employee.getCountry());
        updatedEmployee.setDepartment(employee.getDepartment());
        return employeeRepository.save(updatedEmployee);
    }

    public void deleteById(int id) {
        employeeRepository.deleteById(id);
    }

}
