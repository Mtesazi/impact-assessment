/*package com.impact.controllerTest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.impact.controller.EmployeeController;
import com.impact.model.Employee;
import com.impact.service.EmployeeService;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.ResultMatcher;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import static java.nio.file.Paths.get;
import static net.bytebuddy.matcher.ElementMatchers.is;
import static org.assertj.core.api.BDDAssumptions.given;
import static org.mockito.BDDMockito.willDoNothing;
import static org.springframework.mock.http.server.reactive.MockServerHttpRequest.post;
import static org.springframework.mock.http.server.reactive.MockServerHttpRequest.put;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(EmployeeController.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class EmployeeControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EmployeeService employeeService;

    @Autowired
    private ObjectMapper objectMapper;

    Employee employee;

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

    //Post Controller
    @Test
    @Order(1)
    public void SaveEmployeeTest() throws Exception{

        // precondition
        given(employeeService.saveEmployee(any(Employee.class))).isEqualTo(employee);

        // action
        ResultActions response = mockMvc.perform((org.springframework.test.web.servlet.RequestBuilder) post("/api/employees")
                .contentType(MediaType.APPLICATION_JSON)
                .contentType(MediaType.valueOf(objectMapper.writeValueAsString(employee))));

        // verify
        response.andDo(print()).
                andExpect(status().isCreated())
                .andExpect((ResultMatcher) jsonPath("$.firstName",is(employee.getFirstName())))
                .andExpect((ResultMatcher) jsonPath("$.lastName",is(employee.getLastName())))
                .andExpect((ResultMatcher) jsonPath("$.contactNumber",is(employee.getContactNumber())))
                .andExpect((ResultMatcher) jsonPath("$.emailAddress",is(employee.getEmailAddress())));
    }

    private Object any(Class<Employee> employeeClass) {
        return null;
    }

    //Get Controller
    @Test
    @Order(2)
    public void GetEmployeeTest() throws Exception{
        // precondition
        List<Employee> employeesList = new ArrayList<>();
        employeesList.add(employee);
        employeesList.add(Employee.builder().id(2L).firstName("Bongani")
                .lastName("Gumede")
                .emailAddress("Mtesazi@gmail.com")
                .contactNumber("0734735290").build());
        given(employeeService.getAllEmployees()).isEqualTo(employeesList);

        // action
        ResultActions response = mockMvc.perform((org.springframework.test.web.servlet.RequestBuilder) get("/api/employees"));

        // verify the output
        response.andExpect(status().isOk())
                .andDo(print())
                .andExpect((ResultMatcher) jsonPath("$.size()",
                        is(employeesList.size())));

    }



    //get by Id controller
    @Test
    @Order(3)
    public void GetByIdEmployeeTest() throws Exception{
        // precondition
        given(employeeService.getEmployeeById(employee.getId())).isEqualTo(Optional.of(employee));

        // action
        ResultActions response = mockMvc.perform((org.springframework.test.web.servlet.RequestBuilder) Array.get("/api/employees/{id}",
                Math.toIntExact(employee.getId())));

        // verify
        response.andExpect(status().isOk())
                .andDo(print())
                .andExpect((ResultMatcher) jsonPath("$.firstName", is(employee.getFirstName())))
                .andExpect((ResultMatcher) jsonPath("$.lastName", is(employee.getLastName())))
                .andExpect((ResultMatcher) jsonPath("$.contactNumber",is(employee.getContactNumber())))
                .andExpect((ResultMatcher) jsonPath("$.email", is(employee.getEmailAddress())));

    }


    //Update employee
    @Test
    @Order(4)
    public void UpdateEmployeeTest() throws Exception{
        // precondition
        given(employeeService.getEmployeeById(employee.getId())).isEqualTo(Optional.of(employee));
        employee.setFirstName("Bongani");
        employee.setEmailAddress("Mtesazi@gmail.com");
        given(employeeService.updateEmployee(employee.getId(), employee)).isEqualTo(employee);

        // action
        ResultActions response = mockMvc.perform((org.springframework.test.web.servlet.RequestBuilder) put("/api/employees/{id}", employee.getId())
                .contentType(MediaType.APPLICATION_JSON).contentType(MediaType.valueOf(objectMapper.writeValueAsString(employee))));

        // verify
        response.andExpect(status().isOk())
                .andDo(print())
                .andExpect((ResultMatcher) jsonPath("$.firstName", is(employee.getFirstName())))
                .andExpect((ResultMatcher) jsonPath("$.email", is(employee.getEmailAddress())));
    }


    // delete employee
    @Test
    public void DeleteEmployeeTest() throws Exception{
        // precondition
        willDoNothing().given(employeeService).deleteEmployee(employee.getId());

        // action
        ResultActions response = mockMvc.perform(delete("/api/employees/{id}", employee.getId()));

        // then - verify the output
        response.andExpect(status().isOk()).andDo(print());
    }
}
*/