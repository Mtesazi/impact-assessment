package com.impact.service;



import com.impact.model.Employee;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;


@Service
public interface EmployeeService {

    Employee saveEmployee(Employee employee);
    Optional<Employee> getEmployeeById (Long employeeId);
    List<Employee> getAllEmployees();
    Employee updateEmployee(Long employeeId, Employee updatedEmployee);
    void deleteEmployee(Long employeeId);
    boolean saveEmployee(Object any);
}