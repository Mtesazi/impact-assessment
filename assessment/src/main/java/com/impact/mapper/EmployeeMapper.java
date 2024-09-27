package com.impact.mapper;


import com.impact.dto.EmployeeDto;
import com.impact.model.Employee;

public class EmployeeMapper {
    public static EmployeeDto mapToEmployeeDto(Employee employee) {
        return new EmployeeDto(
                employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getContactNumber(),
                employee.getEmailAddress()
        );
    }

    public static Employee mapToEmployee(EmployeeDto employeeDto) {
        return new Employee(
                employeeDto.getId(),
                employeeDto.getFirstName(),
                employeeDto.getLastName(),
                employeeDto.getContactNumber(),
                employeeDto.getEmailAddress()
        );
    }
}