/*package com.impact.serviceTest;


import com.impact.model.Employee;
import com.impact.repository.EmployeeRepository;
import com.impact.service.impl.EmployeeServiceImpl;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.BDDAssumptions.given;
import static org.mockito.BDDMockito.willDoNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;


@ExtendWith(MockitoExtension.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class EmployeeServiceTests {

    @Mock
    private EmployeeRepository employeeRepository;

    @InjectMocks
    private EmployeeServiceImpl employeeService;
    private Employee employee;

    public EmployeeServiceTests(EmployeeServiceImpl employeeService) {
        this.employeeService = employeeService;
    }


    @BeforeEach
    public void setup(){

        employee = Employee.builder()
                .id(1L)
                .firstName("Bongani")
                .lastName("Gumede")
                .emailAddress("Mtesazi@gmail.com")
                .contactNumber("0734735290")
                .build();
    }

    @Test
    @Order(1)
    public void saveEmployeeTest(){

        // precondition
        given(employeeRepository.save(employee)).isEqualTo(employee);

        //action
        Employee savedEmployee = employeeService.saveEmployee(employee);

        // verify the output
        System.out.println(savedEmployee);
        assertThat(savedEmployee).isNotNull();
    }

    @Test
    @Order(2)
    public void getEmployeeById(){

        // precondition
        given(employeeRepository.findById(1L)).isEqualTo(Optional.of(employee));

        // action
        Employee existingEmployee = employeeService.getEmployeeById(employee.getId()).get();

        // verify
        System.out.println(existingEmployee);
        assertThat(existingEmployee).isNotNull();

    }


    @Test
    @Order(3)
    public void getAllEmployee(){
        Employee employee1 = Employee.builder()
                .id(2L)
                .firstName("Bongani")
                .lastName("Gumede")
                .emailAddress("Mtesazi@gmail.com")
                .contactNumber("0734735290")
                .build();

        // precondition
        given(employeeRepository.findAll()).isEqualTo(List.of(employee,employee1));

        // action
        List<Employee> employeeList = employeeService.getAllEmployees();

        // verify
        System.out.println(employeeList);
        assertThat(employeeList).isNotNull();
        assertThat(employeeList.size()).isGreaterThan(1);
    }

    @Test
    @Order(4)
    public void updateEmployee(){

        // precondition
        given(employeeRepository.findById(employee.getId())).isEqualTo(Optional.of(employee));
        employee.setEmailAddress("Mtesazi@gmail.com");
        employee.setFirstName("Bongani");
        given(employeeRepository.save(employee)).isEqualTo(employee);

        // action
        Employee updatedEmployee = employeeService.updateEmployee(employee.getId(), employee);

        // verify
        System.out.println(updatedEmployee);
        assertThat(updatedEmployee.getEmailAddress()).isEqualTo("Mtesazi@gmail.com");
        assertThat(updatedEmployee.getFirstName()).isEqualTo("Bongani");
    }

    @Test
    @Order(5)
    public void deleteEmployee() throws InstantiationException, IllegalAccessException {

        // precondition
        willDoNothing().given(Collections.singletonList(employeeRepository)).get(employee.getClass().getModifiers());

        // action
        employeeService.deleteEmployee(employee.getId());

        // verify
        verify(employeeRepository, times(1)).get(employee.getId());
    }
}*/