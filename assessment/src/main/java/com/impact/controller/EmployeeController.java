package com.impact.controller;


import com.impact.model.Employee;
import com.impact.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;


@AllArgsConstructor
@RestController
@RequestMapping("/api/employees")
public class EmployeeController {


    @Autowired
    private EmployeeService employeeService;

    //Build create Employee REST API
    @PostMapping
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee){
        Employee saveEmployee = employeeService.saveEmployee(employee);
        return new ResponseEntity<>(saveEmployee, HttpStatus.CREATED);
    }

    //Build Get Employee By Id REST API
    @GetMapping("{id}")
    public ResponseEntity<Optional<Employee>> getEmployeeById(@PathVariable ("id") Long employeeId){
        Optional<Employee> employee = employeeService.getEmployeeById(employeeId);
        return ResponseEntity.ok(employee);
    }

    //Build Get All Employees REST API
    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployees (){
        List<Employee> employees= employeeService.getAllEmployees();
        return ResponseEntity.ok(employees);
    }

    //Build update Employee REST API
    @PutMapping("{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable ("id") Long employeeId, @RequestBody Employee updatedEmployee){
        Employee employee = employeeService.updateEmployee(employeeId,updatedEmployee);
        return ResponseEntity.ok(employee);
    }

    //Build delete Employee REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable ("id") Long employeeId){
        employeeService.deleteEmployee(employeeId);
        return ResponseEntity.ok("Employee deleted successfully");
    }
}