package com.impact.repositoryTest;


import com.impact.model.Employee;
import com.impact.repository.EmployeeRepository;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import java.util.List;
import java.util.Optional;
import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class EmployeeRepositoryTests {

    @Autowired
    private EmployeeRepository employeeRepository;


    @Test
    @DisplayName("Save Employee Test")
    @Order(1)
    @Rollback(value = false)
    public void saveEmployeeTest(){

        //Action
        Employee employee = Employee.builder()
                .firstName("Bongani")
                .lastName("Gumede")
                .emailAddress("Mtesazi@gmail.com")
                .contactNumber("0734735290")
                .build();
        employeeRepository.save(employee);

        //Verify
        assertThat(employee).isNotNull();
        assertThat(employee.getId()).isGreaterThan(0);
    }


    @Test
    @Order(2)
    public void getEmployeeTest(){

        //Action
        Employee employee = employeeRepository.findById(1L).get();
        //Verify
        System.out.println(employee);
        assertThat(employee.getId()).isEqualTo(1L);
    }

    @Test
    @Order(3)
    public void getListOfEmployeesTest(){
        //Action
        List<Employee> employees = employeeRepository.findAll();
        //Verify
        System.out.println(employees);
        assertThat(employees.size()).isGreaterThan(0);

    }


    @Test
    @Order(4)
    @Rollback(value = false)
    public void updateEmployeeTest(){

        //Action
        Employee employee = employeeRepository.findById(1L).get();
        employee.setEmailAddress("Mtesazi@gmail.com");
        Employee employeeUpdated =  employeeRepository.save(employee);

        //Verify
        System.out.println(employeeUpdated);
        assertThat(employeeUpdated.getEmailAddress()).isEqualTo("Mtesazi@gmail.com");

    }

    @Test
    @Order(5)
    @Rollback(value = false)
    public void deleteEmployeeTest(){
        //Action
        employeeRepository.deleteById(1L);
        Optional<Employee> employeeOptional = employeeRepository.findById(1L);

        //Verify
        assertThat(employeeOptional).isEmpty();
    }
}