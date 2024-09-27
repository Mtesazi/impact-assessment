package com.impact.service.impl;


import com.impact.exception.ResourceNotFoundException;
import com.impact.model.Employee;
import com.impact.repository.EmployeeRepository;
import com.impact.service.EmployeeService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;


@Service
public class EmployeeServiceImpl  implements EmployeeService {


    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }


    @Override
    public Employee saveEmployee(Employee employee) {

        Optional<Employee> savedEmployee = employeeRepository.findByEmailAddress(employee.getEmailAddress());
        if(savedEmployee.isPresent()){
            throw new RuntimeException("Employee already exist with given email:" + employee.getEmailAddress());
        }
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }


    @Override
    public Optional<Employee> getEmployeeById(Long employeeId) {
        return employeeRepository.findById(employeeId);
    }


    @Override
    public Employee updateEmployee(Long employeeId, Employee updatedEmployee) {
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(() ->
                new ResourceNotFoundException("Employee does not exist with given id :" + employeeId));

        employee.setFirstName(updatedEmployee.getFirstName());
        employee.setLastName(updatedEmployee.getLastName());
        employee.setContactNumber(updatedEmployee.getContactNumber());
        employee.setEmailAddress(updatedEmployee.getEmailAddress());
         employeeRepository.save(employee);
        return employee;
    }

    @Override
    public void deleteEmployee(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(() ->
                new ResourceNotFoundException("Employee does not exist with given id :" + employeeId));
        employeeRepository.deleteById(employeeId);
    }

    @Override
    public boolean saveEmployee(Object any) {
        return false;
    }
}